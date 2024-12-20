package joey.nettee.todo.service;

import jakarta.transaction.Transactional;
import joey.nettee.todo.controller.dto.TodoCommandDto.TodoCreateRequest;
import joey.nettee.todo.exception.TodoCommandErrorCode;
import joey.nettee.todo.mapper.TodoDtoMapper;
import joey.nettee.todo.domain.Todo;
import joey.nettee.todo.domain.type.TodoStatus;
import joey.nettee.todo.repository.TodoCommandRepository;
import joey.nettee.todo.usecase.TodoCreateUseCase;
import joey.nettee.todo.usecase.TodoDeleteUseCase;
import joey.nettee.todo.usecase.TodoUpdateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class TodoCommandService implements TodoCreateUseCase, TodoUpdateUseCase, TodoDeleteUseCase
{
    private final TodoCommandRepository todoCommandRepository;
    private final TodoDtoMapper mapper;

    @Override
    public Todo create(Todo todo) {
        return todoCommandRepository.save(todo);
    }

    @Override
    public Todo create(TodoCreateRequest request) {
        Instant now = Instant.now();
        Todo todo = mapper.toEntity(request, TodoStatus.PENDING, now, now);
        return create(todo);
    }

    @Transactional
    @Override
    public Todo update(Long id, String content) {
        Todo todo = findTodoById(id);
        todo.prepareUpdate().content(content).update();
        return todo;
    }

//    @Transactional //soft delete라 필요 없을듯?
    @Override
    public void delete(Long id) {
        Todo todo = findTodoById(id);
        todo.markAsRemoved();
    }

    private Todo findTodoById(Long id){
        Todo todo = todoCommandRepository.findById(id)
                .orElseThrow(TodoCommandErrorCode.TODO_NOT_FOUND::defaultException);
        if(todo.status() == TodoStatus.REMOVED){
            throw TodoCommandErrorCode.TODO_ALREADY_DELETED.defaultException();
        }

        return todo;
    }
}
