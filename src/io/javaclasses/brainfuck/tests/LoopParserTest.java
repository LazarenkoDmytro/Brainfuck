package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * Tests the logic of the {@link LoopParser} class.
 */
public class LoopParserTest {
    private LoopParser loopParser;
    private String brainfuckExpression;
    private MutableInt mutableInt;

    @BeforeEach
    void setUp() {
        loopParser = new LoopParser();
        brainfuckExpression = "[><+-.]";
        mutableInt = new MutableInt(0);
    }

    @Test
    void testParse() {
        Command command = loopParser.parse(brainfuckExpression, mutableInt);
        assertInstanceOf(Loop.class, command);

        Loop loop = (Loop) command;
        List<Command> innerCommands = loop.innerCommands();

        assertInstanceOf(MovePointerRight.class, innerCommands.get(0));
        assertInstanceOf(MovePointerLeft.class, innerCommands.get(1));
        assertInstanceOf(IncrementCurrentCell.class, innerCommands.get(2));
        assertInstanceOf(DecrementCurrentCell.class, innerCommands.get(3));
        assertInstanceOf(PrintCurrentCell.class, innerCommands.get(4));

        assertEquals(5, innerCommands.size());
    }
}

