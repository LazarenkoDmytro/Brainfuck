package io.javaclasses.brainfuck.classes;

/**
 * A command of the interpreter.
 * Implements the {@link Command} interface.
 * Decrements the value of the current cell in the memory.
 */
public final class DecrementCurrentCell implements Command {
    @Override
    public void execute(Memory memory) {
        memory.decrementCurrentCell();
    }
}
