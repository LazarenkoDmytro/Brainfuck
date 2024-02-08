package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.Interpreter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the logic of the {@link Interpreter} class.
 */
public final class InterpreterTest {
    Interpreter interpreter;

    @BeforeEach
    void setUp() {
        interpreter = new Interpreter();
    }

    @Test
    void testInterpret() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        setUpStreams(outContent);

        String brainfuckExpression = "+[-->-[>>+>-----<<]<--<---]>-.>>>+.>>..+++[.>]<<<<.+++.------.<<-.>>>>+.";
        interpreter.interpret(brainfuckExpression);

        assertEquals("Hello, World!", outContent.toString());

        restoreStreams(originalOut);
    }

    public void setUpStreams(ByteArrayOutputStream outContent) {
        System.setOut(new PrintStream(outContent));
    }

    public void restoreStreams(PrintStream originalOut) {
        System.setOut(originalOut);
    }
}
