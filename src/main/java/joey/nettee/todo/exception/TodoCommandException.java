package joey.nettee.todo.exception;

import joey.nettee.common.exception.CustomException;
import joey.nettee.common.exception.ErrorCode;

public class TodoCommandException extends CustomException {
    public TodoCommandException(ErrorCode errorCode) {
        super(errorCode);
    }
    public TodoCommandException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
