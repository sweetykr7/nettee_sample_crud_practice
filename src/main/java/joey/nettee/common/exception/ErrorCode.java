package joey.nettee.common.exception;

import org.springframework.http.HttpStatus;

public interface ErrorCode {
    String name();
    String defaultMessage();
    HttpStatus defaultHttpStatus();
    RuntimeException defaultException();
    RuntimeException defaultException(Throwable cause);
}