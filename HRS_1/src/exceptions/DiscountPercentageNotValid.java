package exceptions;

public class DiscountPercentageNotValid extends Exception {
		private static final long serialVersionUID = 1L;

		public DiscountPercentageNotValid() {
			super("Discount should be Between 0 and 1");
		}

}
