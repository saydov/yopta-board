package ru.saydov.message.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.saydov.message.repository.MessageRepository;
import ru.saydov.message.service.MessageService;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Доменный объект сообщения.
 * <p>
 * Иммутабельный value-объект, представляющий единицу сообщения на доске.
 * Создаётся через {@link #builder()}, хранится в {@link MessageRepository}.
 * </p>
 *
 * <h3>Жизненный цикл</h3>
 * <ol>
 *     <li>Создаётся в {@link MessageService}</li>
 *     <li>Сохраняется в {@link MessageRepository}</li>
 *     <li>Удаляется по запросу через {@code id}</li>
 * </ol>
 *
 * @see MessageRepository
 */
@Getter
@ToString
@Builder(toBuilder = true)
@Accessors(fluent = true)
public class Message {

    /**
     * Уникальный идентификатор сообщения.
     */
    private final UUID id;

    /**
     * Текст сообщения.
     * <p>
     * Не может быть пустым — валидируется на уровне контроллера.
     * </p>
     */
    private final String text;

    /**
     * Время создания сообщения.
     * <p>
     * Проставляется автоматически в момент создания.
     * </p>
     */
    private final LocalDateTime createdAt;
}
