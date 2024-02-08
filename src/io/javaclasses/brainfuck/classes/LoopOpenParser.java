package io.javaclasses.brainfuck.classes;

import java.util.List;
import java.util.Stack;

/**
 * A parser of the interpreter.
 * Implements the {@link Parser} interface.
 * Parses the string between brackets.
 */
public final class LoopOpenParser implements Parser {
    @Override
    public void parse(List<Command> finalCommands, Stack<CompositeCommand> compositeCommands) {
        compositeCommands.push(new Loop());
    }
}
