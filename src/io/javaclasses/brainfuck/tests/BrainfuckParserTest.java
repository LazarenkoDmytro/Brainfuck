package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * Tests the logic of the {@link BrainfuckParser} class.
 */
public class BrainfuckParserTest {
    private BrainfuckParser brainfuckParser;
    private String brainfuckExpression;

    @BeforeEach
    void setUp() {
        brainfuckParser = new BrainfuckParser();
        brainfuckExpression = "><+-.[><+-.]";
    }

    @Test
    void testParse() {
        List<Command> commands = brainfuckParser.parse(brainfuckExpression);

        assertEquals(6, commands.size());

        testCommands(commands);
        assertInstanceOf(Loop.class, commands.get(5));

        Loop loop = (Loop) commands.get(5);
        List<Command> innerCommands = loop.innerCommands();

        testCommands(innerCommands);
    }

    static void testCommands(List<Command> commands) {
        assertInstanceOf(MovePointerRight.class, commands.get(0));
        assertInstanceOf(MovePointerLeft.class, commands.get(1));
        assertInstanceOf(IncrementCurrentCell.class, commands.get(2));
        assertInstanceOf(DecrementCurrentCell.class, commands.get(3));
        assertInstanceOf(PrintCurrentCell.class, commands.get(4));
    }
}
