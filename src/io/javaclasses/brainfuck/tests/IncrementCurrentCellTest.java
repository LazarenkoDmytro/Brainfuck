package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.IncrementCurrentCell;
import io.javaclasses.brainfuck.classes.Memory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the logic of the {@link IncrementCurrentCell} class.
 */
public final class IncrementCurrentCellTest {
    private Memory memory;
    private IncrementCurrentCell incrementCurrentCell;

    @BeforeEach
    void setUp() {
        memory = new Memory(10);
        incrementCurrentCell = new IncrementCurrentCell();
    }

    @Test
    void testExecute() {
        for (byte i = 0; i < Byte.MAX_VALUE; i++) {
            incrementCurrentCell.execute(memory);
        }
        assertEquals(Byte.MAX_VALUE, memory.currentCell());

        incrementCurrentCell.execute(memory);
        assertEquals(Byte.MIN_VALUE, memory.currentCell());
    }
}
