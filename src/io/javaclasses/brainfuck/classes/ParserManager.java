package io.javaclasses.brainfuck.classes;

import java.util.HashMap;

/**
 * A manager of Parser.
 * Defines the parser type by its character.
 */
public class ParserManager {
    private final HashMap<Character, Parser> parsersByCharacters = new HashMap<>() {
        {
            put('>', new MovePointerRightParser());
            put('<', new MovePointerLeftParser());
            put('+', new IncrementCurrentCellParser());
            put('-', new DecrementCurrentCellParser());
            put('.', new PrintCurrentCellParser());
            put('[', new LoopParser());
        }
    };

    public Parser parser(char character) {
        Parser parser = parsersByCharacters.get(character);
        if (parser == null) {
            throw new IllegalArgumentException("Unauthorized operation");
        }

        return parser;
    }
}
