package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * Tests the logic of the {@link IfCloseParser} class.
 */
public final class IfCloseParserTest {
    IfCloseParser ifCloseParser;
    private List<Command> finalCommands;
    private Stack<CompositeCommand> compositeCommands;

    @BeforeEach
    void setUp() {
        ifCloseParser = new IfCloseParser();
        finalCommands = new ArrayList<>();
        compositeCommands = new Stack<>();
    }

    @Test
    void testParse() {
        compositeCommands.push(new If());
        ifCloseParser.parse(finalCommands, compositeCommands);

        assertEquals(1, finalCommands.size());
        assertInstanceOf(If.class, finalCommands.get(0));
        assert(compositeCommands.isEmpty());
    }
}