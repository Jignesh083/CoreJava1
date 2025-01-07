package ExceptionHandlingProject;

public class BankAccount extends CustomException {
	private String accountNumber;
	private String accountHolderName;
	private double balance;
	
	public BankAccount(String accountNumber,String accountHolderName){
		this.accountNumber = accountNumber;
		this.balance = 0.0;
		this.accountHolderName = accountHolderName;
	}
	
	
	
	
	public String getAccountHolderName() {
		return accountHolderName;
	}
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	
	
	
	
	public void deposite(double amount){
		if(amount>0) {
			balance+=amount;
			System.out.printf("Deposited: " + amount);
		}
		else {
			System.out.println("Deposit amount must be positive.");
		}
		
		
	}
	
	public void withdraw(double amount) throws InsufficientFundsException{
		if(amount>balance) {
			throw new InsufficientFundsException("Insufficient funds for Withdrawal.");
		}
		if(amount>0) {
			balance -= amount;
			System.out.printf("Withdrawn: "+amount);
		}
		else {
			System.out.println("Withdrawal amount must be positive.");
		}
		
	}
	
}
