package io.javaclasses.brainfuck.classes;

import java.util.List;

/**
 * The general structure, that connects every component together.
 */
public class Interpreter {
    private final Memory memory;
    BrainfuckParser brainfuckParser;

    public Interpreter() {
        memory = new Memory(30000);
        brainfuckParser = new BrainfuckParser();
    }
    public void interpret(String brainfuckExpression) {
        List<Command> commands = brainfuckParser.parse(brainfuckExpression);

        commands.forEach(command -> command.execute(memory));
    }
}
