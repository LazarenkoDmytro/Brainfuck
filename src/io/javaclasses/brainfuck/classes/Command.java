package io.javaclasses.brainfuck.classes;

/**
 * An abstract template of all commands in the interpreter.
 */
public interface Command {
    void execute(Memory memory);
}
