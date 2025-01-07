package ExceptionHandlingProject;


public class Bank extends CustomException{

	private BankAccount[] accounts;
	private int numberOfAccounts;
	
	public Bank(int capacity) {
		accounts = new BankAccount[capacity];
		numberOfAccounts = 0;
	}
	
	public void createAccount(String accountNumber,String accountHolderName) {
		if(numberOfAccounts < accounts.length) {
			accounts[numberOfAccounts] = new BankAccount(accountNumber,accountHolderName);
			System.out.println("Account Created for: "+ accountHolderName);
			numberOfAccounts++;
		}
		else {
			System.out.println("Account limit reached. Cannot create new Account.");
		}
	}
	
	public BankAccount getAccount(String accountNumber) throws AccountNotFoundException {
		for(int i=0;i<numberOfAccounts;i++) {
			if(accounts[i].getAccountNumber().equals(accountNumber)) {
				return accounts[i];
			}
		}
		throw new AccountNotFoundException("Account Not Found: "+ accountNumber);
	}
}