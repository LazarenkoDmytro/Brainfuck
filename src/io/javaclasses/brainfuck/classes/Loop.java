package io.javaclasses.brainfuck.classes;

import java.util.List;

/**
 * A command of the interpreter.
 * Implements the {@link Command} interface.
 * Executes a series of commands repeatedly.
 */
public class Loop implements Command {
    private final List<Command> innerCommands;

    public Loop(List<Command> commands) {
        this.innerCommands = commands;
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
