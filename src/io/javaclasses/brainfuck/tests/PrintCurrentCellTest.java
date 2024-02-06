package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.IncrementCurrentCell;
import io.javaclasses.brainfuck.classes.Memory;
import io.javaclasses.brainfuck.classes.PrintCurrentCell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the logic of the {@link PrintCurrentCell} class.
 */
public final class PrintCurrentCellTest {
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
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        setUpStreams(outContent);

        for (byte i = 0; i < 'A'; i++) {
            incrementCurrentCell.execute(memory);
        }
        printCurrentCell.execute(memory);
        assertEquals("A", outContent.toString());

        incrementCurrentCell.execute(memory);
        printCurrentCell.execute(memory);
        assertEquals("AB", outContent.toString());

        restoreStreams(originalOut);
    }

    public void setUpStreams(ByteArrayOutputStream outContent) {
        System.setOut(new PrintStream(outContent));
    }

    public void restoreStreams(PrintStream originalOut) {
        System.setOut(originalOut);
    }
}
