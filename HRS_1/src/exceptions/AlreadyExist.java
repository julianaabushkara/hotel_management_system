package exceptions;

public class AlreadyExist extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public AlreadyExist(String type) {
		super("The "+type+" Already Exist");
	}


}
