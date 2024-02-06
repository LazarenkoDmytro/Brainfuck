package io.javaclasses.brainfuck.tests;


import io.javaclasses.brainfuck.classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

        List<Command> innerCommands = new ArrayList<>();

        innerCommands.add(new DecrementCurrentCell());
        innerCommands.add(new MovePointerRight());

        for (int i = 0; i < 2; i++) {
            innerCommands.add(new IncrementCurrentCell());
        }

        innerCommands.add(new MovePointerRight());

        for (int i = 0; i < 3; i++) {
            innerCommands.add(new IncrementCurrentCell());
        }

        for (int i = 0; i < 2; i++) {
            innerCommands.add(new MovePointerLeft());
        }

        loop = new Loop(innerCommands);
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