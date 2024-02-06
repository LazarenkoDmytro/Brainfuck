package io.javaclasses.brainfuck.classes;

/**
 * A command of the interpreter.
 * Implements the {@link Command} interface.
 * Moves the pointer of the memory to the left.
 */
public class MovePointerLeft implements Command {
    @Override
    public void execute(Memory memory) {
        memory.movePointerLeft();
    }
}