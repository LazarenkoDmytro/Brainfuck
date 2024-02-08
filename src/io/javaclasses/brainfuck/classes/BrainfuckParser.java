package io.javaclasses.brainfuck.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Parser of the String in Brainfuck standard.
 * Extracts the Commands from the expression.
 */
public final class BrainfuckParser {
    private final ParserManager parserManager = new ParserManager();

    public List<Command> parse(String brainfuckExpression) {
        List<Command> finalCommands = new ArrayList<>();
        Stack<CompositeCommand> compositeCommands = new Stack<>();

        for (int i = 0; i < brainfuckExpression.length(); i++) {
            char currentCharacter = brainfuckExpression.charAt(i);
            Parser parser = parserManager.parser(currentCharacter);

            parser.parse(finalCommands, compositeCommands);
        }

        assert (compositeCommands.empty());
        return finalCommands;
    }
}
