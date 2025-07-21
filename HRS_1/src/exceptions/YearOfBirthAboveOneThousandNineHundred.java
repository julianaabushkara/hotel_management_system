package exceptions;

public class YearOfBirthAboveOneThousandNineHundred extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public YearOfBirthAboveOneThousandNineHundred() {
		super("The Year Should be Above 1900 and the current year");
	}


}
