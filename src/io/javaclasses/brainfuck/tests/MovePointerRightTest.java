package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.Memory;
import io.javaclasses.brainfuck.classes.MovePointerRight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the logic of the {@link MovePointerRight} class.
 */
class MovePointerRightTest {
    private Memory memory;
    private MovePointerRight movePointerRight;

    @BeforeEach
    void setUp() {
        memory = new Memory(10);
        movePointerRight = new MovePointerRight();
    }

    @Test
    void testExecute() {
        movePointerRight.execute(memory);
        assertEquals(1, memory.currentPointer());

        movePointerRight.execute(memory);
        assertEquals(2, memory.currentPointer());
    }
}
