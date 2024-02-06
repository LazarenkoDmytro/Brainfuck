package io.javaclasses.brainfuck.classes;

/**
 * A parser of the interpreter.
 * Implements the {@link Parser} interface.
 * Parses the PrintCurrentCell symbol.
 */
public final class PrintCurrentCellParser implements Parser {
    @Override
    public Command parse(String brainfuckExpression, MutableInt index) {
        return new PrintCurrentCell();
    }
}
