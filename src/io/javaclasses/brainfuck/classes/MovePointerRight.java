package io.javaclasses.brainfuck.classes;

/**
 * A command of the interpreter.
 * Implements the {@link Command} interface.
 * Moves the pointer of the memory to the right.
 */
public class MovePointerRight implements Command {
    @Override
    public void execute(Memory memory) {
        memory.movePointerRight();
    }
}