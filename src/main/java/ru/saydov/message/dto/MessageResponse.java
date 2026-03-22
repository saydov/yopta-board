package ru.saydov.message.dto;

import ru.saydov.message.entity.Message;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Ответ с данными сообщения.
 * <p>
 * Используется для передачи информации о сообщении клиенту.
 * Создаётся через фабричный метод {@link #from(Message)}.
 * </p>
 *
 * @see MessageRequest
 * @see Message
 */
@Getter
@ToString
@Builder
public class MessageResponse {

    /**
     * Создаёт ответ из доменного объекта.
     * <p>
     * Используется для преобразования {@link Message} в DTO перед отправкой клиенту.
     * </p>
     *
     * @param message доменный объект сообщения
     * @return DTO с данными сообщения
     */
    public static MessageResponse from(Message message) {
        return MessageResponse.builder()
                .id(message.id())
                .text(message.text())
                .createdAt(message.createdAt())
                .build();
    }

    private final UUID id;

    private final String text;

    private final LocalDateTime createdAt;
}
