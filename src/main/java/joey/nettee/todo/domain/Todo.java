package joey.nettee.todo.domain;


import jakarta.persistence.*;
import joey.nettee.common.jpa.support.BaseEntity;
import joey.nettee.todo.domain.type.TodoStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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


    public TodoStatus status() {
        return status;
    }

    @Builder(
            builderClassName = "UpdateTodoBuilder",
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