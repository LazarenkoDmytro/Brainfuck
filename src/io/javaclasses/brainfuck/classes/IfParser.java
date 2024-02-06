package io.javaclasses.brainfuck.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * A parser of the interpreter.
 * Implements the {@link Parser} interface.
 * Parses the string between curly braces.
 */
public final class IfParser implements Parser {
    @Override
    public Command parse(String brainfuckExpression, MutableInt index) {
        List<Command> innerCommands = new ArrayList<>();
        ParserManager parserManager = new ParserManager();

        index.increment();
        while (index.value() < brainfuckExpression.length() && brainfuckExpression.charAt(index.value()) != '}') {
            Parser parser = parserManager.parser(brainfuckExpression.charAt(index.value()));

            Command innerCommand = parser.parse(brainfuckExpression, index);
            innerCommands.add(innerCommand);

            index.increment();
        }

        if (index.value() == brainfuckExpression.length() && brainfuckExpression.charAt(index.value() - 1) != '}') {
            throw new IllegalArgumentException("Insufficiently closed curly brace");
        }
        return new If(innerCommands);
    }
}
