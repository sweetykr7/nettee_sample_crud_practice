package joey.nettee.todo.repository.projection;

import jakarta.persistence.Column;
import joey.nettee.todo.domain.type.TodoStatus;
import lombok.Builder;

import java.time.Instant;

public final class TodoProjection {
    @Builder(toBuilder = true)
    public record TodoSummaryProjection (
        Long id,
        String content,
        TodoStatus status,
        @Column(name = "created_at")
        Instant createdAt
    ) {}

    @Builder
    public record TodoDetailProjection(
        Long id,
        String content,
        TodoStatus status,
        @Column(name = "created_at")
        Instant createdAt,
        @Column(name = "updated_at")
        Instant updatedAt
    ) {}
}
