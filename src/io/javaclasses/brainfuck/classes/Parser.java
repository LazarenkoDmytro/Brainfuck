package io.javaclasses.brainfuck.classes;

import java.util.List;
import java.util.Stack;

/**
 * An abstract template of all parsers in the interpreter.
 */
public interface Parser {
    void parse(List<Command> finalCommands, Stack<CompositeCommand> compositeCommands);
}
