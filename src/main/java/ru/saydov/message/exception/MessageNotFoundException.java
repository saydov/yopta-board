package ru.saydov.message.exception;

import lombok.experimental.StandardException;

import java.util.UUID;

/**
 * Исключение при отсутствии сообщения в репозитории.
 */
@StandardException
public class MessageNotFoundException extends RuntimeException {

    public MessageNotFoundException(UUID uniqueId) {
        this("id=" + uniqueId);
    }
}
