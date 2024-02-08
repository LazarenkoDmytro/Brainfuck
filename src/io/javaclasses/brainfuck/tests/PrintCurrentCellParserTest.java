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
 * Tests the logic of the {@link MovePointerRightParser} class.
 */
public final class PrintCurrentCellParserTest {
    private PrintCurrentCellParser printCurrentCellParser;
    private List<Command> finalCommands;
    private Stack<CompositeCommand> compositeCommands;

    @BeforeEach
    void setUp() {
        printCurrentCellParser = new PrintCurrentCellParser();
        finalCommands = new ArrayList<>();
        compositeCommands = new Stack<>();
    }

    @Test
    void testParse() {
        printCurrentCellParser.parse(finalCommands, compositeCommands);

        assertEquals(1, finalCommands.size());
        assertInstanceOf(PrintCurrentCell.class, finalCommands.get(0));
        assert (compositeCommands.isEmpty());
        finalCommands.clear();

        compositeCommands.push(new Loop());
        printCurrentCellParser.parse(finalCommands, compositeCommands);

        assert (finalCommands.isEmpty());
        assertEquals(1, compositeCommands.size());
    }
}