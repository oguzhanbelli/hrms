package kodlamaio.hrmsdemo.core.utilities.validations;

import kodlamaio.hrmsdemo.core.utilities.results.ErrorDataResult;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@ControllerAdvice
@ResponseBody
public class ExceptionHandlerCustom {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException   exceptions){


        Map<String,String> validationErrors = new HashMap<String,String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){

            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());

        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
        return errors;
    }
    @ExceptionHandler({SQLException.class, DataAccessException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleSQLException(SQLException   exceptions){


        Map<String,String> validationErrors = new HashMap<String,String>();
        List<String> details = new ArrayList<>();
        details.add(exceptions.getMessage());
        for(String fieldError : details){

            validationErrors.put(fieldError,fieldError);

        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
        return errors;
    }
}
