package io.javaclasses.brainfuck.classes;

/**
 * A parser of the interpreter.
 * Implements the {@link Parser} interface.
 * Parses the IncrementCurrentCell symbol.
 */
public final class IncrementCurrentCellParser implements Parser {
    @Override
    public Command parse(String brainfuckExpression, MutableInt index) {
        return new IncrementCurrentCell();
    }
}
