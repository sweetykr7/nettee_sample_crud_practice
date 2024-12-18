package joey.nettee.todo.controller;

import lombok.RequiredArgsConstructor;
import joey.nettee.todo.controller.dto.TodoQueryDto.TodoSelectAllResponse;
import joey.nettee.todo.controller.dto.TodoQueryDto.TodoSelectOneResponse;
import joey.nettee.todo.mapper.TodoDtoMapper;
import joey.nettee.todo.usecase.TodoSelectAllUseCase;
import joey.nettee.todo.usecase.TodoSelectOneUseCase;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
@Validated
public class TodoQueryApi {

    private final TodoSelectOneUseCase todoSelectOneUseCase;
    private final TodoSelectAllUseCase todoSelectAllUseCase;
    private final TodoDtoMapper mapper;

    @GetMapping("/{id}")
    public TodoSelectOneResponse selectOne(@PathVariable("id") Long id) {
        var todo = todoSelectOneUseCase.findById(id);

        return TodoSelectOneResponse.builder()
                .todo(todo)
                .build();
    }

    @GetMapping
    public TodoSelectAllResponse selectAll(
            @PageableDefault(size = 10)
            Pageable pageable
    ) {
        pageable = pageable.previousOrFirst();

        var page = todoSelectAllUseCase.findGeneralBy(pageable);

        return mapper.toResponse(page, pageable.getPageNumber() + 1);
    }
}
