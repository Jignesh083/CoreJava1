package ExceptionHandlingProject;

public class CustomException{
	
	
	class InsufficientFundsException extends Exception{
		public InsufficientFundsException(String msg) {
			super(msg);
		}
	}
	
	
	class AccountNotFoundException extends Exception{
		public AccountNotFoundException(String msg) {
			super(msg);
		}
	}
	
}
