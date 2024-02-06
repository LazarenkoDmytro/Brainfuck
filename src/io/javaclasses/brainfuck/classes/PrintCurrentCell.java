package io.javaclasses.brainfuck.classes;

/**
 * A command of the interpreter.
 * Implements the {@link Command} interface.
 * Prints the char view of the current cell value.
 */
public class PrintCurrentCell implements Command {
    @Override
    public void execute(Memory memory) {
        memory.printCurrentCell();
    }
}
