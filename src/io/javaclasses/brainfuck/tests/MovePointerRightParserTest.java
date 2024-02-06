package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.MovePointerRight;
import io.javaclasses.brainfuck.classes.MovePointerRightParser;
import io.javaclasses.brainfuck.classes.MutableInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * Tests the logic of the {@link MovePointerRightParser} class.
 */
public final class MovePointerRightParserTest {
    private MovePointerRightParser movePointerRightParser;
    private String brainfuckExpression;
    private MutableInt mutableInt;

    @BeforeEach
    void setUp() {
        movePointerRightParser = new MovePointerRightParser();
        brainfuckExpression = "[><+-.]";
        mutableInt = new MutableInt(1);
    }

    @Test
    void testParse() {
        assertInstanceOf(MovePointerRight.class, movePointerRightParser.parse(brainfuckExpression, mutableInt));
    }
}
