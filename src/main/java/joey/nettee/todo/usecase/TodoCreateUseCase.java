package joey.nettee.todo.usecase;

import joey.nettee.todo.controller.dto.TodoCommandDto;
import joey.nettee.todo.domain.Todo;

public interface TodoCreateUseCase {
    Todo create(Todo todo);
    Todo create(TodoCommandDto.TodoCreateRequest request);
}