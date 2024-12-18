package joey.nettee.todo.repository;

import joey.nettee.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoCommandRepository extends JpaRepository<Todo, Long> {
    //기본 CRUD기능 >>  JpaRepository에서 제공한다고 함.
}

