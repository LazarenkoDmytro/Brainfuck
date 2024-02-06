package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.MovePointerLeft;
import io.javaclasses.brainfuck.classes.MovePointerLeftParser;
import io.javaclasses.brainfuck.classes.MutableInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * Tests the logic of the {@link MovePointerLeftParser} class.
 */
public class MovePointerLeftParserTest {
    private MovePointerLeftParser movePointerLeftParser;
    private String brainfuckExpression;
    private MutableInt mutableInt;

    @BeforeEach
    void setUp() {
        movePointerLeftParser = new MovePointerLeftParser();
        brainfuckExpression = "[><+-.]";
        mutableInt = new MutableInt(2);
    }

    @Test
    void testParse() {
        assertInstanceOf(MovePointerLeft.class, movePointerLeftParser.parse(brainfuckExpression, mutableInt));
    }
}
