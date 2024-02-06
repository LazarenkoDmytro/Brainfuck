package io.javaclasses.brainfuck.classes;

import java.util.List;

/**
 * A command of the interpreter.
 * Implements the {@link Command} interface.
 * Executes a series of commands once.
 */
public record If(List<Command> innerCommands) implements Command {
    public If {
        assert (innerCommands != null && !innerCommands.isEmpty());
    }

    @Override
    public void execute(Memory memory) {
        if (memory.currentCell() == 0) {
            for (Command command : innerCommands) {
                command.execute(memory);
            }
        }
    }
}
