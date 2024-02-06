package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.DecrementCurrentCell;
import io.javaclasses.brainfuck.classes.Memory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the logic of the {@link DecrementCurrentCell} class.
 */
public class DecrementCurrentCellTest {
    private Memory memory;
    private DecrementCurrentCell decrementCurrentCell;

    @BeforeEach
    void setUp() {
        memory = new Memory(10);
        decrementCurrentCell = new DecrementCurrentCell();
    }

    @Test
    void testExecute() {
        for (byte i = 0; i > Byte.MIN_VALUE; i--) {
            decrementCurrentCell.execute(memory);
        }
        assertEquals(Byte.MIN_VALUE, memory.currentCell());

        decrementCurrentCell.execute(memory);
        assertEquals(Byte.MAX_VALUE, memory.currentCell());
    }
}
