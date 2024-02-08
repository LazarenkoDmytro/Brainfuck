package io.javaclasses.brainfuck.classes;

import java.util.List;
import java.util.Stack;

/**
 * A parser of the interpreter.
 * Implements the {@link Parser} interface.
 * Parses the DecrementCurrentCell symbol.
 */
public final class DecrementCurrentCellParser implements Parser {
    @Override
    public void parse(List<Command> finalCommands, Stack<CompositeCommand> compositeCommands) {
        CommandUpdater.updateCommands(finalCommands, compositeCommands, new DecrementCurrentCell());
    }
}
