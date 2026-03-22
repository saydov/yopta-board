package ru.saydov.message.repository;

import ru.saydov.message.entity.Message;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In-memory реализация репозитория сообщений.
 * <p>
 * Используется для хранения сообщений в оперативной памяти без персистентности.
 * Потокобезопасна за счёт использования {@link ConcurrentHashMap}.
 * </p>
 *
 * @see MessageRepository
 */
@Component
public final class InMemoryMessageRepository implements MessageRepository {

    /**
     * Внутреннее хранилище сообщений.
     * <p>
     * Ключ — UUID сообщения, значение — объект сообщения.
     * </p>
     */
    private final Map<UUID, Message> storage = new ConcurrentHashMap<>();

    @Override
    public void save(Message message) {
        storage.put(message.id(), message);
    }

    @Override
    public List<Message> findAll() {
        return List.copyOf(storage.values());
    }

    @Override
    public Optional<Message> findById(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void deleteById(UUID id) {
        storage.remove(id);
    }
}
