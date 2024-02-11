package in.masterpapa.krishi.util;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<?> deterMineListResp(List<?> list) {
		if (list.isEmpty()) {
			return new ResponseEntity(null, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity(list, HttpStatus.OK);
		}
	}

}
