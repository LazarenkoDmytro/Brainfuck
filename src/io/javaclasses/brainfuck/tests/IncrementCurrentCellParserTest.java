package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.IncrementCurrentCell;
import io.javaclasses.brainfuck.classes.IncrementCurrentCellParser;
import io.javaclasses.brainfuck.classes.MutableInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * Tests the logic of the {@link IncrementCurrentCellParser} class.
 */
public class IncrementCurrentCellParserTest {
    private IncrementCurrentCellParser incrementCurrentCellParser;
    private String brainfuckExpression;
    private MutableInt mutableInt;

    @BeforeEach
    void setUp() {
        incrementCurrentCellParser = new IncrementCurrentCellParser();
        brainfuckExpression = "[><+-.]";
        mutableInt = new MutableInt(3);
    }

    @Test
    void testParse() {
        assertInstanceOf(IncrementCurrentCell.class, incrementCurrentCellParser.parse(brainfuckExpression, mutableInt));
    }
}
