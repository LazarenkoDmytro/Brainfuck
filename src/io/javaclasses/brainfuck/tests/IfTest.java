package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        memory = new Memory(10);

        List<Command> innerCommands = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            innerCommands.add(new IncrementCurrentCell());
        }

        innerCommands.add(new MovePointerRight());

        for (int i = 0; i < 4; i++) {
            innerCommands.add(new IncrementCurrentCell());
        }

        for (int i = 0; i < 2; i++) {
            innerCommands.add(new MovePointerLeft());
        }

        movePointerRight = new MovePointerRight();
        ifCommand = new If(innerCommands);
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
