package joey.nettee.todo.repository;

import joey.nettee.todo.domain.Todo;
import joey.nettee.todo.domain.type.TodoStatus;
import joey.nettee.todo.repository.projection.TodoProjection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface TodoQueryRepository extends JpaRepository<Todo, Long> {
    Optional<TodoProjection.TodoDetailProjection> findTodoById(Long id);
    Page<TodoProjection.TodoSummaryProjection> findPageByStatusIn(Collection<TodoStatus> status, Pageable pageable);
    //지금은 page로 받는데 이렇게 하면 느리다고 한다. 추후에 PageableExecutionUtils이거 사용하면 List로 반환됨.
}
