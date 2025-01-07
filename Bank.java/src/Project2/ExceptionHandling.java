package Project2;

public class ExceptionHandling {
	
	class  InsufficientFundException extends Exception {
		public InsufficientFundException (String msg) {
			super(msg);
		}
	}
	
	
	class AccountNotFoundException extends Exception{
		public AccountNotFoundException(String msg) {
			super(msg);
		}
	}
	
}
