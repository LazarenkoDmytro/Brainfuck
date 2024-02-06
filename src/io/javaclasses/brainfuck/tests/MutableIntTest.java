package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.MutableInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the logic of the {@link MutableInt} class.
 */
public class MutableIntTest {
    private MutableInt mutableInt;

    @BeforeEach
    void setUp() {
        mutableInt = new MutableInt(0);
    }

    @Test
    void testExecute() {
        assertEquals(0, mutableInt.value());

        mutableInt.increment();
        assertEquals(1, mutableInt.value());
    }
}