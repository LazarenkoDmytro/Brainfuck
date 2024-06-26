package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.Memory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the logic of the {@link Memory} class.
 */
public final class MemoryTest {
    private Memory memory;

    @BeforeEach
    void setUp() {
        memory = new Memory(10);
    }

    @Test
    void testMovePointerRight() {
        memory.movePointerRight();
        assertEquals(1, memory.currentPointer());
    }

    @Test
    void testMovePointerLeft() {
        memory.movePointerLeft();
        assertEquals(9, memory.currentPointer());
    }

    @Test
    void testIncrementCurrentCell() {
        memory.incrementCurrentCell();
        assertEquals(1, memory.currentCell());
    }

    @Test
    void testDecrementCurrentCell() {
        memory.decrementCurrentCell();
        assertEquals(-1, memory.currentCell());
    }

    @Test
    void testWrapAroundFromMaxValue() {
        for (int i = 0; i < Byte.MAX_VALUE; i++) {
            memory.incrementCurrentCell();
        }
        assertEquals(Byte.MAX_VALUE, memory.currentCell());

        memory.incrementCurrentCell();
        assertEquals(Byte.MIN_VALUE, memory.currentCell());
    }

    @Test
    void testWrapAroundFromMinValue() {
        for (int i = 0; i > Byte.MIN_VALUE; i--) {
            memory.decrementCurrentCell();
        }
        assertEquals(Byte.MIN_VALUE, memory.currentCell());

        memory.decrementCurrentCell();
        assertEquals(Byte.MAX_VALUE, memory.currentCell());
    }

    @Test
    void testPrintCurrentCell() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        setUpStreams(outContent);

        for (byte i = 0; i < 'A'; i++) {
            memory.incrementCurrentCell();
        }
        memory.printCurrentCell();
        assertEquals("A", outContent.toString());

        memory.incrementCurrentCell();
        memory.printCurrentCell();
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
