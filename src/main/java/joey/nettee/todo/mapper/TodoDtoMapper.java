package joey.nettee.todo.mapper;

import joey.nettee.todo.controller.dto.TodoCommandDto;
import joey.nettee.todo.controller.dto.TodoQueryDto.TodoSelectAllResponse;
import joey.nettee.todo.domain.Todo;
import joey.nettee.todo.domain.type.TodoStatus;
import joey.nettee.todo.repository.projection.TodoProjection.TodoSummaryProjection;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.time.Instant;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface TodoDtoMapper {
    //DTO에서 Entity
    Todo toEntity(TodoCommandDto.TodoCreateRequest dto, TodoStatus status, Instant createdAt, Instant updatedAt);
    //Page에서 Response
    default TodoSelectAllResponse toResponse(Page<TodoSummaryProjection> todos, int currentpage) {
        return TodoSelectAllResponse.builder()
                .todos(todos.stream().toList()) //page를 리스트로 바꾸기
                .page(currentpage)
                .total(todos.getTotalElements())
                .lastPage(todos.getTotalPages())
                .build();
    }
}

