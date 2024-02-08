package io.javaclasses.brainfuck.classes;

import java.util.List;
import java.util.Stack;

/**
 * A parser of the interpreter.
 * Implements the {@link Parser} interface.
 * Parses the LoopClose symbol.
 */
public final class LoopCloseParser implements Parser {
    @Override
    public void parse(List<Command> finalCommands, Stack<CompositeCommand> compositeCommands) {
        assert (!compositeCommands.empty() && compositeCommands.peek() instanceof Loop);

        CommandUpdater.updateCommands(finalCommands, compositeCommands, compositeCommands.pop());
    }
}
