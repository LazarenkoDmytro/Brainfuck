package io.javaclasses.brainfuck.tests;

import io.javaclasses.brainfuck.classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the logic of the {@link ParserManager} class.
 */
public final class ParserManagerTest {
    ParserManager parserManager;

    @BeforeEach
    void setUp() {
        parserManager = new ParserManager();
    }

    @Test
    void testParser() {
        assertInstanceOf(MovePointerRightParser.class, parserManager.parser('>'));
        assertInstanceOf(MovePointerLeftParser.class, parserManager.parser('<'));
        assertInstanceOf(IncrementCurrentCellParser.class, parserManager.parser('+'));
        assertInstanceOf(DecrementCurrentCellParser.class, parserManager.parser('-'));
        assertInstanceOf(PrintCurrentCellParser.class, parserManager.parser('.'));
        assertInstanceOf(LoopOpenParser.class, parserManager.parser('['));
        assertInstanceOf(LoopCloseParser.class, parserManager.parser(']'));
        assertInstanceOf(IfOpenParser.class, parserManager.parser('{'));
        assertInstanceOf(IfCloseParser.class, parserManager.parser('}'));
        assertThrowsExactly(IllegalArgumentException.class, () -> parserManager.parser(' '));
    }
}
