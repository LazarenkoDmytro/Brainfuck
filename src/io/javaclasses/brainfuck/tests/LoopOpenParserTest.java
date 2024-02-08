package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.Command;
import io.javaclasses.brainfuck.classes.CompositeCommand;
import io.javaclasses.brainfuck.classes.LoopOpenParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the logic of the {@link LoopOpenParser} class.
 */
public final class LoopOpenParserTest {
    LoopOpenParser loopOpenParser;
    private List<Command> finalCommands;
    private Stack<CompositeCommand> compositeCommands;

    @BeforeEach
    void setUp() {
        loopOpenParser = new LoopOpenParser();
        finalCommands = new ArrayList<>();
        compositeCommands = new Stack<>();
    }

    @Test
    void testParse() {
        loopOpenParser.parse(finalCommands, compositeCommands);

        assert (finalCommands.isEmpty());
        assertEquals(1, compositeCommands.size());
    }
}