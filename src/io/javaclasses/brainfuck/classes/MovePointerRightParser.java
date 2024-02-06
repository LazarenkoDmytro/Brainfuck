package io.javaclasses.brainfuck.classes;

/**
 * A parser of the interpreter.
 * Implements the {@link Parser} interface.
 * Parses the MovePointerRight symbol.
 */
public class MovePointerRightParser implements Parser {
    @Override
    public Command parse(String brainfuckExpression, MutableInt index) {
        return new MovePointerRight();
    }
}
