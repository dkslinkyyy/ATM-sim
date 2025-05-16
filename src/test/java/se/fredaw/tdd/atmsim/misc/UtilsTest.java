package se.fredaw.tdd.atmsim.misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UtilsTest {

    @Test
    void throwWith_shouldThrowGivenExceptionWithMessage() {
        // Arrange
        Message msg = Message.INSUFFICIENT_BALANCE;

        RuntimeException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Utils.throwWith(msg, IllegalArgumentException::new)
        );

        assertEquals(msg.getPlaceholder(), exception.getMessage());
    }

    @Test
    void throwWith_shouldThrowCustomExceptionWithCustomMessage() {
        Message msg = Message.INSUFFICIENT_BALANCE;

        RuntimeException exception = assertThrows(
                IllegalStateException.class,
                () -> Utils.throwWith(msg, m -> new IllegalStateException("error: " + m))
        );

        assertEquals("error: " + msg.getPlaceholder(), exception.getMessage());
    }
}
