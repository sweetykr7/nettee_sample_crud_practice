package joey.nettee.todo.usecase;

import joey.nettee.todo.repository.projection.TodoProjection.TodoDetailProjection;

public interface TodoSelectOneUseCase {
    TodoDetailProjection findById(Long id);
}