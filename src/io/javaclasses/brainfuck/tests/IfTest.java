package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the logic of the {@link If} class.
 */
public final class IfTest {
    If ifCommand;
    Memory memory;
    MovePointerRight movePointerRight;

    @BeforeEach
    void setUp() {
        ifCommand = new If();
        memory = new Memory(10);

        for (int i = 0; i < 3; i++) {
            ifCommand.addInnerCommand(new IncrementCurrentCell());
        }

        ifCommand.addInnerCommand(new MovePointerRight());

        for (int i = 0; i < 4; i++) {
            ifCommand.addInnerCommand(new IncrementCurrentCell());
        }

        for (int i = 0; i < 2; i++) {
            ifCommand.addInnerCommand(new MovePointerLeft());
        }

        movePointerRight = new MovePointerRight();

    }

    @Test
    void testExecute() {
        ifCommand.execute(memory);
        assertEquals(0, memory.currentCell());

        movePointerRight.execute(memory);
        assertEquals(3, memory.currentCell());

        movePointerRight.execute(memory);
        assertEquals(4, memory.currentCell());
    }
}
