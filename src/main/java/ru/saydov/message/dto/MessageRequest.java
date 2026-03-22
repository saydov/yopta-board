package ru.saydov.message.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Входящий запрос на создание сообщения.
 * <p>
 * Используется для приёма текста сообщения от клиента.
 * </p>
 *
 * @see MessageResponse
 */
@Getter
@ToString
@Builder
@Jacksonized
public class MessageRequest {

    /**
     * Текст сообщения.
     * <p>
     * Не может быть пустым или состоять только из пробелов.
     * </p>
     */
    @NotBlank
    private final String text;
}
