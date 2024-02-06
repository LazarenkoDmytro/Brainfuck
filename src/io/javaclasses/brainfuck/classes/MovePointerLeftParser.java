package io.javaclasses.brainfuck.classes;

/**
 * A parser of the interpreter.
 * Implements the {@link Parser} interface.
 * Parses the MovePointerLeft symbol.
 */
public class MovePointerLeftParser implements Parser {
    @Override
    public Command parse(String brainfuckExpression, MutableInt index) {
        return new MovePointerLeft();
    }
}
