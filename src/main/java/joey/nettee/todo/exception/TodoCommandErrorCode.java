package joey.nettee.todo.exception;

import joey.nettee.common.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public enum TodoCommandErrorCode implements ErrorCode {
    TODO_NOT_FOUND("할 일을 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    TODO_ALREADY_COMPLETED("이미 완료된 작업입니다.", HttpStatus.CONFLICT),
    TODO_ALREADY_DELETED("이미 삭제된 작업입니다.", HttpStatus.GONE),
    DEFAULT("할일 조작 오류", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String message;
    private final HttpStatus status;

    TodoCommandErrorCode(String message, HttpStatus status) {
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
    public TodoCommandException defaultException() {
        return new TodoCommandException(this);
    }

    public TodoCommandException defaultException(Throwable cause) {
        return new TodoCommandException(this, cause);
    }

}