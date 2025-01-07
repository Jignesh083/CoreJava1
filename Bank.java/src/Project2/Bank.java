package Project2;

public class Bank extends ExceptionHandling {
	private BankAccount[] accounts;
	private int numbersOfAccounts;
	
	public Bank(int capacity) {
		this.accounts = new BankAccount[capacity];
		numbersOfAccounts = 0;
	}
	
	public void createAccounts(String accountNumber,String accountHolderName) {
		if(numbersOfAccounts<accounts.length) {
			accounts[numbersOfAccounts] = new BankAccount(accountNumber,accountHolderName);
			System.out.println("Account created for: "+accountHolderName);
			numbersOfAccounts++;
		}
		else {
			System.out.println("Account limit reached. Cannot create new Account.");
		}
		
	}
	
	public BankAccount getAccount(String accountNumber) throws AccountNotFoundException{
		for(int i=0;i<numbersOfAccounts;i++) {
			if(accounts[i].getAccountNumber().equals(accountNumber)) {
				return accounts[i];
			}
		}
		throw new AccountNotFoundException("Account Not Found: "+accountNumber);
	}
}
