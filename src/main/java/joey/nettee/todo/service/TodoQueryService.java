package joey.nettee.todo.service;

import joey.nettee.todo.domain.type.TodoStatus;
import joey.nettee.todo.exception.TodoQueryErrorCode;
import joey.nettee.todo.repository.TodoQueryRepository;
import joey.nettee.todo.repository.projection.TodoProjection;
import joey.nettee.todo.repository.projection.TodoProjection.TodoDetailProjection;
import joey.nettee.todo.usecase.TodoSelectAllUseCase;
import joey.nettee.todo.usecase.TodoSelectOneUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class TodoQueryService implements TodoSelectOneUseCase, TodoSelectAllUseCase {
    private final TodoQueryRepository todoQueryRepository;

    @Override
    public TodoDetailProjection findById(Long id) {
        return todoQueryRepository.findTodoById(id)
                .orElseThrow(TodoQueryErrorCode.TODO_NOT_FOUND::defaultException);
    }

    @Override
    public Page<TodoProjection.TodoSummaryProjection> findGeneralBy(Pageable pageable) {
        Collection<TodoStatus> statuses = TodoStatus.getGeneralQueryStatus();
        var page = todoQueryRepository.findPageByStatusIn(statuses, pageable);
        page.map(this::hideContentIfCompleted);
        return page;
    }

    private TodoProjection.TodoSummaryProjection hideContentIfCompleted(TodoProjection.TodoSummaryProjection todo) {
        return todo.status() == TodoStatus.COMPLETED
                ? todo.toBuilder()
                .content("이 작업은 완료되었습니다.")
                .build()
                : todo;
    }
}
