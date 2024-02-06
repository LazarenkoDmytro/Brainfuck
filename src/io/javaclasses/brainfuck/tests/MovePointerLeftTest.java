package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.Memory;
import io.javaclasses.brainfuck.classes.MovePointerLeft;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the logic of the {@link MovePointerLeft} class.
 */
class MovePointerLeftTest {
    private Memory memory;
    private MovePointerLeft movePointerLeft;

    @BeforeEach
    void setUp() {
        memory = new Memory(10);
        movePointerLeft = new MovePointerLeft();
    }

    @Test
    void testExecute() {
        movePointerLeft.execute(memory);
        assertEquals(9, memory.currentPointer());

        movePointerLeft.execute(memory);
        assertEquals(8, memory.currentPointer());
    }
}
