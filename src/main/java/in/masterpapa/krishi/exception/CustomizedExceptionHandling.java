package in.masterpapa.krishi.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandling {

	@ExceptionHandler(value = ServiceException.class)
	public ResponseEntity<Object> handleServiceException(ServiceException ex) {
		ExceptionResponse response = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.name(), "Internal Server Error", LocalDateTime.now());
		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleException(Exception ex) {
		ExceptionResponse response = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.name(), "Internal Server Error", LocalDateTime.now());
		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
