package io.javaclasses.brainfuck.classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main class, where you can input the Brainfuck expressions from console and receive result.
 * Works, until "exit" is entered.
 */
public final class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            while (!(input = reader.readLine()).equals("exit")) {
                Interpreter interpreter = new Interpreter();
                interpreter.interpret(input);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
