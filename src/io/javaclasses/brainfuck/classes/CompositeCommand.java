package io.javaclasses.brainfuck.classes;

/**
 * An abstract template of composite commands in the interpreter.
 */
public interface CompositeCommand extends Command {
    void addInnerCommand(Command command);
}
