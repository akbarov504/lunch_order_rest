package uz.jl.lunch_order_rest.exception.custom_exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ForbiddenException extends RuntimeException {
    private final HttpStatus status;

    public ForbiddenException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public ForbiddenException(String message) {
        this(message, HttpStatus.FORBIDDEN);
    }
}
