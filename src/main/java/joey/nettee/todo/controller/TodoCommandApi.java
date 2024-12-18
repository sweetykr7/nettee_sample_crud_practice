package joey.nettee.todo.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import joey.nettee.todo.controller.dto.TodoCommandDto;
import joey.nettee.todo.usecase.TodoCreateUseCase;
import joey.nettee.todo.usecase.TodoDeleteUseCase;
import joey.nettee.todo.usecase.TodoUpdateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
@Validated
public class TodoCommandApi {

    private final TodoCreateUseCase todoCreateUseCase;
    private final TodoUpdateUseCase todoUpdateUseCase;
    private final TodoDeleteUseCase todoDeleteUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoCommandDto.TodoCreateResponse create(
            @RequestBody @Valid TodoCommandDto.TodoCreateRequest request
    ) {
        var todo = todoCreateUseCase.create(request);

        return TodoCommandDto.TodoCreateResponse.builder()
                .todo(todo)
                .build();
    }

    @PutMapping("/{id}")
    public TodoCommandDto.TodoUpdateResponse update(
            @PathVariable("id")
            @NotNull(message = "작업 번호가 지정되지 않았습니다.")
            Long id,
            @RequestBody @Valid TodoCommandDto.TodoUpdateRequest request
    ) {
        var todo = todoUpdateUseCase.update(id, request.content());

        return TodoCommandDto.TodoUpdateResponse.builder()
                .todo(todo)
                .build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable("id")
            @NotNull(message = "작업 번호가 지정되지 않았습니다.")
            Long id
    ) {
        todoDeleteUseCase.delete(id);
    }
}