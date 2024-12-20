package joey.nettee.todo.controller.dto;

import jakarta.validation.constraints.Size;
import joey.nettee.todo.domain.Todo;
import lombok.Builder;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

public final class TodoCommandDto {
    private TodoCommandDto() {}

    @Builder
    public record TodoCreateRequest(
            @NotBlank(message = "할 일을 입력하십시오.")
            @Size(min = 3, message = "할 일은 세 글자 이상 입력하세요.")
            @Size(max = 200, message = "할 일은 최대 200글자입니다.")
            String content
    ){}

    @Builder
    public record TodoUpdateRequest(
            @NotBlank(message = "할 일을 입력하십시오.")
            @Size(min = 3, message = "할 일은 세 글자 이상 입력하세요.")
            @Size(max = 200, message = "할 일은 최대 200글자입니다.")
            String content
    ) {}

    @Builder
    public record TodoUpdateEditedRequest(
            @NotBlank(message = "할 일을 입력하십시오.")
            @Size(min = 3, message = "할 일은 세 글자 이상 입력하세요.")
            @Size(max = 200, message = "할 일은 최대 200글자입니다.")
            String content
    ) {}

    @Builder
    public record TodoCreateResponse(
            Todo todo
    ) {}

    @Builder
    public record TodoUpdateResponse(
            Todo todo
    ) {}
}
