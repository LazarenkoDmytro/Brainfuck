package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.Command;
import io.javaclasses.brainfuck.classes.CompositeCommand;
import io.javaclasses.brainfuck.classes.IfOpenParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the logic of the {@link IfOpenParser} class.
 */
public final class IfOpenParserTest {
    IfOpenParser ifOpenParser;
    private List<Command> finalCommands;
    private Stack<CompositeCommand> compositeCommands;

    @BeforeEach
    void setUp() {
        ifOpenParser = new IfOpenParser();
        finalCommands = new ArrayList<>();
        compositeCommands = new Stack<>();
    }

    @Test
    void testParse() {
        ifOpenParser.parse(finalCommands, compositeCommands);

        assert (finalCommands.isEmpty());
        assertEquals(1, compositeCommands.size());
    }
}