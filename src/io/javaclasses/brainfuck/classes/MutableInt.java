package io.javaclasses.brainfuck.classes;

/**
 * A mutable wrapper of int primitive.
 * Used to pass the int value as a reference.
 */
public class MutableInt {
    private int value;

    public MutableInt(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public void increment() {
        value++;
    }
}
