import java.util.InputMismatchException;

public class InputMistypingException extends InputMismatchException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InputMistypingException(String message) {
		System.out.println(message);
	}
}
