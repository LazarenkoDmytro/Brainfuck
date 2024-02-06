package io.javaclasses.brainfuck.classes;

import java.util.List;

/**
 * A command of the interpreter.
 * Implements the {@link Command} interface.
 * Executes a series of commands repeatedly.
 */
public record Loop(List<Command> innerCommands) implements Command {
    public Loop {
        assert (innerCommands != null && !innerCommands.isEmpty());
    }

    @Override
    public void execute(Memory memory) {
        while (memory.currentCell() != 0) {
            for (Command command : innerCommands) {
                command.execute(memory);
            }
        }
    }
}
