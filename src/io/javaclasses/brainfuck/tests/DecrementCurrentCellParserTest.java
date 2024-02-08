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
 * Tests the logic of the {@link DecrementCurrentCellParser} class.
 */
public final class DecrementCurrentCellParserTest {
    private DecrementCurrentCellParser decrementCurrentCellParser;
    private List<Command> finalCommands;
    private Stack<CompositeCommand> compositeCommands;

    @BeforeEach
    void setUp() {
        decrementCurrentCellParser = new DecrementCurrentCellParser();
        finalCommands = new ArrayList<>();
        compositeCommands = new Stack<>();
    }

    @Test
    void testParse() {
        decrementCurrentCellParser.parse(finalCommands, compositeCommands);

        assertEquals(1, finalCommands.size());
        assertInstanceOf(DecrementCurrentCell.class, finalCommands.get(0));
        assert(compositeCommands.isEmpty());
        finalCommands.clear();

        compositeCommands.push(new Loop());
        decrementCurrentCellParser.parse(finalCommands, compositeCommands);

        assert(finalCommands.isEmpty());
        assertEquals(1, compositeCommands.size());
    }
}