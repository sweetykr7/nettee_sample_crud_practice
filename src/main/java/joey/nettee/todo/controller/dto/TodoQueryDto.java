package joey.nettee.todo.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import joey.nettee.todo.repository.projection.TodoProjection;
import lombok.Builder;

import java.util.List;

public final class TodoQueryDto {
    private TodoQueryDto() {}

    @Builder
    public record TodoSelectOneResponse(
            TodoProjection.TodoDetailProjection todo
    ){}

    @Builder
    public record TodoSelectAllResponse(
        List<TodoProjection.TodoSummaryProjection> todos,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Integer page,
        @JsonInclude(JsonInclude.Include.NON_NULL)

        Long total,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Integer lastPage
    ) {}
}
