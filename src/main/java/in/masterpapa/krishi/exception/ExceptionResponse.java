package in.masterpapa.krishi.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {

	private Integer code;
	
	private String error;
	
	private String message;
	
	private LocalDateTime time;

}
