package cn.com.transcosmos.training.exception.handler;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author NRI
 */
@ControllerAdvice
public class RestExceptionHandler {

	private static final Logger logger = LogManager.getLogger(RestExceptionHandler.class);

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidExceptionResponse> invalidInput(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		return new ResponseEntity<ValidExceptionResponse>(processFieldErrors(fieldErrors), HttpStatus.BAD_REQUEST);
	}
	
	private ValidExceptionResponse processFieldErrors(List<FieldError> fieldErrors) {
		ValidExceptionResponse response = new ValidExceptionResponse();
		for (FieldError fieldError : fieldErrors) {
			logger.debug(fieldError.getField());
			logger.debug(fieldError.getDefaultMessage());
			response.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return response;
	}

}
