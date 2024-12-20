package joey.nettee.todo.usecase;

import joey.nettee.todo.domain.Todo;

public interface TodoUpdateUseCase {
    Todo update(Long id, String content);
    Todo updateEdited(Long id, String content);
}
