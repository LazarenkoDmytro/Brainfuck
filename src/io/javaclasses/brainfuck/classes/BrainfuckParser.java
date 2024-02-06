package io.javaclasses.brainfuck.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Parser of the String in Brainfuck standard.
 * Extracts the Commands from the expression.
 */
public final class BrainfuckParser {
    private final ParserManager parserManager = new ParserManager();

    public List<Command> parse(String brainfuckExpression) {
        List<Command> commands = new ArrayList<>();
        for (MutableInt index = new MutableInt(0); index.value() < brainfuckExpression.length(); index.increment()) {
            char currentCharacter = brainfuckExpression.charAt(index.value());
            Parser parser = parserManager.parser(currentCharacter);

            Command command = parser.parse(brainfuckExpression, index);
            commands.add(command);
        }

        return commands;
    }
}
