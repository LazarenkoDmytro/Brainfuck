package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.IncrementCurrentCell;
import io.javaclasses.brainfuck.classes.Memory;
import io.javaclasses.brainfuck.classes.PrintCurrentCell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the logic of the {@link PrintCurrentCell} class.
 */
class PrintCurrentCellTest {
    private Memory memory;
    private IncrementCurrentCell incrementCurrentCell;
    private PrintCurrentCell printCurrentCell;

    @BeforeEach
    void setUp() {
        memory = new Memory(10);
        incrementCurrentCell = new IncrementCurrentCell();
        printCurrentCell = new PrintCurrentCell();
    }

    @Test
    void testExecute() {
        for (byte i = 0; i < 'A'; i++) {
            incrementCurrentCell.execute(memory);
        }
        printCurrentCell.execute(memory); // 'A' expected in the console

        incrementCurrentCell.execute(memory);
        printCurrentCell.execute(memory); // 'B' expected in the console
    }
}
