package exceptions;

public class ObjectDoesNotExist extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ObjectDoesNotExist(String type) {
		super("The "+type+" Does Not Exist");
	}


}
