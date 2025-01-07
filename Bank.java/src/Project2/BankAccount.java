package Project2;

import Project2.ExceptionHandling.InsufficientFundException;

public class BankAccount extends ExceptionHandling {
	private String accountNumber;
	private String accountHolderName;
	private double balance;
	
	public BankAccount(String accountNumber,String accountHolderName) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = 0.0;
	}
	
	
	public String getAccountNumber(){
		return accountNumber;
	}
	
	public String getAccountHolderName() {
		return accountHolderName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void dposite(double amount) {
		if(amount>0) {
			balance+=amount;
			System.out.println("Deposited Amount: "+amount);
		}
		else {
			System.out.println("Deposit amount must be positive.");
		}
		
	}
	
	
	public void withdraw(double amount) throws InsufficientFundException{
		
		if(amount>balance) {
			throw new InsufficientFundException("Insufficient funds for withdrawal.");
		}
		if(amount>0) {
			balance-=amount;
			System.out.println("Withdrawn Amount: "+amount);
		}
		else {
			System.out.println("Withdrawal amount must be positive.");
		}
		
	}
	
}
