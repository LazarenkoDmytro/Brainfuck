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
 * Tests the logic of the {@link MovePointerLeftParser} class.
 */
public final class MovePointerLeftParserTest {
    private MovePointerLeftParser movePointerLeftParser;
    private List<Command> finalCommands;
    private Stack<CompositeCommand> compositeCommands;

    @BeforeEach
    void setUp() {
        movePointerLeftParser = new MovePointerLeftParser();
        finalCommands = new ArrayList<>();
        compositeCommands = new Stack<>();
    }

    @Test
    void testParse() {
        movePointerLeftParser.parse(finalCommands, compositeCommands);

        assertEquals(1, finalCommands.size());
        assertInstanceOf(MovePointerLeft.class, finalCommands.get(0));
        assert(compositeCommands.isEmpty());
        finalCommands.clear();

        compositeCommands.push(new Loop());
        movePointerLeftParser.parse(finalCommands, compositeCommands);

        assert(finalCommands.isEmpty());
        assertEquals(1, compositeCommands.size());
    }
}