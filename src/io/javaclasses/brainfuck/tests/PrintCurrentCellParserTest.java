package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.MutableInt;
import io.javaclasses.brainfuck.classes.PrintCurrentCell;
import io.javaclasses.brainfuck.classes.PrintCurrentCellParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * Tests the logic of the {@link PrintCurrentCellParser} class.
 */
public final class PrintCurrentCellParserTest {
    private PrintCurrentCellParser printCurrentCellParser;
    private String brainfuckExpression;
    private MutableInt mutableInt;

    @BeforeEach
    void setUp() {
        printCurrentCellParser = new PrintCurrentCellParser();
        brainfuckExpression = "[><+-.]";
        mutableInt = new MutableInt(5);
    }

    @Test
    void testParse() {
        assertInstanceOf(PrintCurrentCell.class, printCurrentCellParser.parse(brainfuckExpression, mutableInt));
    }
}