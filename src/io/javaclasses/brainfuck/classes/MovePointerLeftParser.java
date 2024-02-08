package io.javaclasses.brainfuck.classes;

import java.util.List;
import java.util.Stack;

/**
 * A parser of the interpreter.
 * Implements the {@link Parser} interface.
 * Parses the MovePointerLeft symbol.
 */
public final class MovePointerLeftParser implements Parser {
    @Override
    public void parse(List<Command> finalCommands, Stack<CompositeCommand> compositeCommands) {
        CommandUpdater.updateCommands(finalCommands, compositeCommands, new MovePointerLeft());
    }
}
