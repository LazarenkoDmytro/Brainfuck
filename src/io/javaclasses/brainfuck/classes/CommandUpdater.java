package io.javaclasses.brainfuck.classes;

import java.util.List;
import java.util.Stack;

/**
 * A structure to update the storages of commands.
 * Used to avoid a duplication of code in the implementers of {@link Parser} Interface.
 */
public final class CommandUpdater {
    public static void updateCommands(List<Command> finalCommands, Stack<CompositeCommand> compositeCommands, Command command) {
        if (compositeCommands.empty()) {
            finalCommands.add(command);
        } else {
            compositeCommands.peek().addInnerCommand(command);
        }
    }
}
