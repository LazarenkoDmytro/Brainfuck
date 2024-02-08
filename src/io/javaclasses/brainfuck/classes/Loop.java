package io.javaclasses.brainfuck.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * A composite command of the interpreter.
 * Implements the {@link CompositeCommand} interface.
 * Executes a series of commands repeatedly.
 */
public final class Loop implements CompositeCommand {
    private final List<Command> innerCommands;

    public Loop() {
        innerCommands = new ArrayList<>();
    }

    @Override
    public void execute(Memory memory) {
        while (memory.currentCell() != 0) {
            for (Command command : innerCommands) {
                command.execute(memory);
            }
        }
    }

    @Override
    public void addInnerCommand(Command command) {
        innerCommands.add(command);
    }

    public List<Command> innerCommands() {
        return new ArrayList<>(innerCommands);
    }
}
