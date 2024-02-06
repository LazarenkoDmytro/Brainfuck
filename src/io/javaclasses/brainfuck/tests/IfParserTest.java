package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * Tests the logic of the {@link IfParser} class.
 */
public final class IfParserTest {
    private IfParser ifParser;
    private String brainfuckExpression;
    private MutableInt mutableInt;

    @BeforeEach
    void setUp() {
        ifParser = new IfParser();
        brainfuckExpression = "{><+-.}";
        mutableInt = new MutableInt(0);
    }

    @Test
    void testParse() {
        Command command = ifParser.parse(brainfuckExpression, mutableInt);
        assertInstanceOf(If.class, command);

        If ifCommand = (If) command;
        List<Command> innerCommands = ifCommand.innerCommands();

        BrainfuckParserTest.testCommands(innerCommands);

        assertEquals(5, innerCommands.size());
    }
}
