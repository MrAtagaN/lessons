package controllers;

import model.MyException;
import model.MyException2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Обработчик ошибок, выбрасываемых из контроллеров
 *
 * https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Вариант 1
     */
    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Data integrity violation")  // 409
    @ExceptionHandler(MyException.class)
    public void handleMyException() {
        System.out.println("GlobalExceptionHandler ERROR");
    }

    /**
     * Вариант 2
     */
    @ExceptionHandler(MyException2.class)
    public ResponseEntity<String> handleMyException2() {

        return new ResponseEntity<String>("Some Error Message", HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
