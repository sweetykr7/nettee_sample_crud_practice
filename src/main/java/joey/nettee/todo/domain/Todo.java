package joey.nettee.todo.domain;


import jakarta.persistence.*;
import joey.nettee.common.jpa.support.BaseEntity;
import joey.nettee.todo.domain.type.TodoStatus;
import lombok.*;

import java.time.Instant;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
@Getter
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    @Enumerated(EnumType.STRING)
    private TodoStatus status;
    private Instant createdAt;
    private Instant updatedAt;


    @Builder
    public Todo(Long id, String content, TodoStatus status, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.content = content;
        this.status = status;
        this.createdAt = createdAt != null ? createdAt:Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt:Instant.now();
    }

    public TodoStatus status() {
        return status;
    }

    @Builder(
            builderClassName = "UpdateContentTodoBuilder",
            builderMethodName = "prepareUpdate",
            buildMethodName = "update"
    )
    public void updateContent(String content) {
        this.content = content;
    }

    @Builder(
            builderClassName = "UpdateEditedTodoBuilder",
            builderMethodName = "prepareUpdateEdited",
            buildMethodName = "update"
    )
    public void updateContentEdited(String content) {
        this.content = content + " 으로 변경됨";
    }

    public void markAsCompleted() {
        this.status = TodoStatus.COMPLETED;
    }
    public void markAsPending() {
        this.status = TodoStatus.PENDING;
    }

    public void markAsRemoved() {
        this.status = TodoStatus.REMOVED;
    }

}