package ru.saydov.message.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.saydov.message.dto.MessageRequest;
import ru.saydov.message.dto.MessageResponse;
import ru.saydov.message.entity.Message;
import ru.saydov.message.exception.MessageNotFoundException;
import ru.saydov.message.repository.MessageRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Реализация сервиса сообщений по умолчанию.
 * <p>
 * Используется для оркестрации операций над сообщениями через {@link MessageRepository}.
 * </p>
 *
 * @see MessageService
 * @see MessageRepository
 */
@Service
@RequiredArgsConstructor
public final class MessageService {

    /**
     * Репозиторий для хранения и выборки сообщений.
     */
    private final MessageRepository repository;

    public MessageResponse create(MessageRequest request) {
        var message = Message.builder()
                .id(UUID.randomUUID())
                .text(request.getText())
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(message);
        return MessageResponse.from(message);
    }

    public List<MessageResponse> findAll() {
        return repository.findAll().stream()
                .map(MessageResponse::from)
                .toList();
    }

    public void delete(UUID id) {
        repository.findById(id).orElseThrow(() -> new MessageNotFoundException(id));
        repository.deleteById(id);
    }
}
