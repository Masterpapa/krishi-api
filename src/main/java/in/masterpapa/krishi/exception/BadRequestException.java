package in.masterpapa.krishi.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 6048495993000007226L;

	public BadRequestException(String message) {
		super(message);
	}

}
