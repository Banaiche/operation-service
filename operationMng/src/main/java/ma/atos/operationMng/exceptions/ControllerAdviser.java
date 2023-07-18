package ma.atos.operationMng.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

//@ControllerAdvice
public class ControllerAdviser {
   // @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleNotFoundEntite(Exception e){
        System.out.println("test");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
