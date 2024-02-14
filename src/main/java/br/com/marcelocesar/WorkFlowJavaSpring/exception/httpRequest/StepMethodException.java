package br.com.marcelocesar.WorkFlowJavaSpring.exception.httpRequest;

public class StepMethodException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StepMethodException() {
		super();
	}

	public StepMethodException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public StepMethodException(String message, Throwable cause) {
		super(message, cause);
	}

	public StepMethodException(String message) {
		super(message);
	}

	public StepMethodException(Throwable cause) {
		super(cause);
	}

	
}
