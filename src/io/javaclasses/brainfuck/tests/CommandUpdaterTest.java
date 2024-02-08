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
 * Tests the logic of the {@link CommandUpdater} class.
 */
public final class CommandUpdaterTest {
    private List<Command> finalCommands;
    private Stack<CompositeCommand> compositeCommands;

    @BeforeEach
    void setUp() {
        finalCommands = new ArrayList<>();
        compositeCommands = new Stack<>();
    }

    @Test
    void testUpdateCommands() {
        CommandUpdater.updateCommands(finalCommands, compositeCommands, new PrintCurrentCell());

        assertEquals(1, finalCommands.size());
        assertInstanceOf(PrintCurrentCell.class, finalCommands.get(0));
        assert(compositeCommands.isEmpty());
        finalCommands.clear();

        compositeCommands.push(new Loop());
        CommandUpdater.updateCommands(finalCommands, compositeCommands, new PrintCurrentCell());

        assert(finalCommands.isEmpty());
        assertEquals(1, compositeCommands.size());
    }
}