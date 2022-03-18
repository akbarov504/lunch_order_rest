package uz.jl.lunch_order_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.jl.lunch_order_rest.entity.app.ApplicationError;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({RuntimeException.class})
    public ApplicationError runtime(RuntimeException e, WebRequest request) {
        return ApplicationError.builder()
                .message(e.getMessage())
                .request(request)
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }
}
