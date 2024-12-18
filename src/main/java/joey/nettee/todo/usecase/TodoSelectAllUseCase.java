package joey.nettee.todo.usecase;

import joey.nettee.todo.repository.projection.TodoProjection.TodoSummaryProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TodoSelectAllUseCase {
    Page<TodoSummaryProjection> findGeneralBy(Pageable pageable);
}
