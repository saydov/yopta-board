package ru.saydov.message.repository;

import ru.saydov.message.entity.Message;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Репозиторий сообщений.
 * <p>
 * Определяет контракт для хранения и выборки сообщений.
 * Реализуется через {@link InMemoryMessageRepository}.
 * </p>
 *
 * @see Message
 */
public interface MessageRepository {

    /**
     * Сохраняет сообщение в хранилище.
     *
     * @param message объект сообщения
     */
    void save(Message message);

    /**
     * Возвращает все сообщения.
     *
     * @return неизменяемый список всех сообщений
     */
    List<Message> findAll();

    /**
     * Ищет сообщение по идентификатору.
     *
     * @param id идентификатор сообщения
     * @return сообщение или пустой Optional
     */
    Optional<Message> findById(UUID id);

    /**
     * Удаляет сообщение по идентификатору.
     *
     * @param id идентификатор сообщения
     */
    void deleteById(UUID id);
}
