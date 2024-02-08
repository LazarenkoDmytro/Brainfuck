package io.javaclasses.brainfuck.tests;


import io.javaclasses.brainfuck.classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the logic of the {@link Loop} class.
 */
public final class LoopTest {
    private Memory memory;
    private Loop loop;
    private MovePointerRight movePointerRight;
    private IncrementCurrentCell incrementCurrentCell;

    @BeforeEach
    void setUp() {
        memory = new Memory(10);
        loop = new Loop();

        loop.addInnerCommand(new DecrementCurrentCell());
        loop.addInnerCommand(new MovePointerRight());

        for (int i = 0; i < 2; i++) {
            loop.addInnerCommand(new IncrementCurrentCell());
        }

        loop.addInnerCommand(new MovePointerRight());

        for (int i = 0; i < 3; i++) {
            loop.addInnerCommand(new IncrementCurrentCell());
        }

        for (int i = 0; i < 2; i++) {
            loop.addInnerCommand(new MovePointerLeft());
        }

        movePointerRight = new MovePointerRight();
        incrementCurrentCell = new IncrementCurrentCell();
    }

    @Test
    void testExecute() {
        for (int i = 0; i < 2; i++) {
            incrementCurrentCell.execute(memory);
        }

        loop.execute(memory);
        assertEquals(0, memory.currentCell());

        movePointerRight.execute(memory);
        assertEquals(4, memory.currentCell());

        movePointerRight.execute(memory);
        assertEquals(6, memory.currentCell());
    }
}