package joey.nettee.todo.exception;

import joey.nettee.common.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public enum TodoQueryErrorCode implements ErrorCode {
    TODO_NOT_FOUND("존재하지 않는 할 일입니다.", HttpStatus.NOT_FOUND),
    TODO_ACCESS_FORBIDDEN("접근 권한이 없는 할일 입니다.", HttpStatus.CONFLICT),
    TODO_ALREADY_DELETED("이미 삭제된 작업입니다.", HttpStatus.GONE),
    DEFAULT("할일 조회 오류", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String message;
    private final HttpStatus status;

    TodoQueryErrorCode(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String defaultMessage() {
        return message;
    }

    @Override
    public HttpStatus defaultHttpStatus() {
        return status;
    }

    @Override
    public TodoQueryException defaultException() {
        return new TodoQueryException(this);
    }

    @Override
    public RuntimeException defaultException(Throwable cause) {
        return new TodoQueryException(this, cause);
    }
}



