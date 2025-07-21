package exceptions;

public class NumberShouldBePositive extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NumberShouldBePositive(String type) {
		super(type+" should be positive");
	}

}
