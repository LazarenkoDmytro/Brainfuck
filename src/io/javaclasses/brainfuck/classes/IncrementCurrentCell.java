package io.javaclasses.brainfuck.classes;

/**
 * A command of the interpreter.
 * Implements the {@link Command} interface.
 * Increments the value of the current cell in the memory.
 */
public final class IncrementCurrentCell implements Command {
    @Override
    public void execute(Memory memory) {
        memory.incrementCurrentCell();
    }
}
