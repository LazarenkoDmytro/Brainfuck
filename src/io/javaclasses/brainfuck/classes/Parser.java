package io.javaclasses.brainfuck.classes;

/**
 * An abstract template of all parsers in the interpreter.
 */
public interface Parser {
    Command parse(String brainfuckExpression, MutableInt index);
}
