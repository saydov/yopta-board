package ru.saydov.message.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.saydov.message.dto.MessageRequest;
import ru.saydov.message.dto.MessageResponse;
import ru.saydov.message.service.MessageService;

import java.util.List;
import java.util.UUID;

/**
 * REST-контроллер для работы с сообщениями.
 * <p>
 * Используется для обработки запросов создания, получения и удаления сообщений.
 * Все операции делегируются в {@link MessageService}.
 * </p>
 *
 * @see MessageService
 */
@Slf4j
@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    /**
     * Сервис для управления сообщениями.
     */
    private final MessageService service;

    /**
     * Возвращает все сообщения.
     *
     * @return список всех сообщений
     */
    @GetMapping
    public List<MessageResponse> findAll() {
        return service.findAll();
    }

    /**
     * Создаёт новое сообщение.
     *
     * @param request тело запроса с текстом сообщения
     * @return созданное сообщение
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse create(@Valid @RequestBody MessageRequest request) {
        return service.create(request);
    }

    /**
     * Удаляет сообщение по идентификатору.
     *
     * @param id идентификатор сообщения
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
