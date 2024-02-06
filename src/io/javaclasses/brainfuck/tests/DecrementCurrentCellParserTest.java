package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.DecrementCurrentCell;
import io.javaclasses.brainfuck.classes.DecrementCurrentCellParser;
import io.javaclasses.brainfuck.classes.MutableInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * Tests the logic of the {@link DecrementCurrentCellParser} class.
 */
public class DecrementCurrentCellParserTest {
    private DecrementCurrentCellParser decrementCurrentCellParser;
    private String brainfuckExpression;
    private MutableInt mutableInt;

    @BeforeEach
    void setUp() {
        decrementCurrentCellParser = new DecrementCurrentCellParser();
        brainfuckExpression = "[><+-.]";
        mutableInt = new MutableInt(4);
    }

    @Test
    void testParse() {
        assertInstanceOf(DecrementCurrentCell.class, decrementCurrentCellParser.parse(brainfuckExpression, mutableInt));
    }
}