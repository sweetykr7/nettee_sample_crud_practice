package joey.nettee.todo.exception;

import joey.nettee.common.exception.CustomException;
import joey.nettee.common.exception.ErrorCode;

public class TodoQueryException extends CustomException {
    public TodoQueryException(ErrorCode errorCode) {
        super(errorCode);
    }

    public TodoQueryException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
