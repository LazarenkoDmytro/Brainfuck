package io.javaclasses.brainfuck.classes;

/**
 * The memory of the
 * <a href="https://en.wikipedia.org/wiki/Brainfuck">Brainfuck</a>
 * programming language interpreter.
 */
public class Memory {
    private final byte[] cells;

    private int pointer = 0;

    public Memory(int memorySize) {
        assert (memorySize > 0);

        cells = new byte[memorySize];
    }

    public byte currentCell() {
        return cells[pointer];
    }

    public int currentPointer() {
        return pointer;
    }

    public void movePointerRight() {
        if (pointer == cells.length - 1) {
            pointer = 0;
        } else {
            pointer++;
        }
    }

    public void movePointerLeft() {
        if (pointer == 0) {
            pointer = cells.length - 1;
        } else {
            pointer--;
        }
    }

    public void incrementCurrentCell() {
        if (cells[pointer] == Byte.MAX_VALUE) {
            cells[pointer] = Byte.MIN_VALUE;
        } else {
            cells[pointer]++;
        }
    }

    public void decrementCurrentCell() {
        if (cells[pointer] == Byte.MIN_VALUE) {
            cells[pointer] = Byte.MAX_VALUE;
        } else {
            cells[pointer]--;
        }
    }

    public void printCurrentCell() {
        System.out.print((char) cells[pointer]);
    }
}
