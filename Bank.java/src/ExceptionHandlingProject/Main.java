package ExceptionHandlingProject;

import java.util.Scanner;

import ExceptionHandlingProject.CustomException.AccountNotFoundException;
import ExceptionHandlingProject.CustomException.InValidAmountException;
import ExceptionHandlingProject.CustomException.InsufficientFundsException;

public class Main {
	public static void main(String[] args) {
		Bank bank = new Bank(10); //Total HoldAccount
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("1. Create Account");
			System.out.println("2. Deposite Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Check Balance");
			System.out.println("5. Exit");
			System.out.println("Choose an Option: ");
			
			
			int choice = scn.nextInt();
			
			scn.nextLine();
			
			switch(choice) {
			//Create Account
			case 1:
				System.out.println("Enter Account Number: ");
				String accountNumber = scn.nextLine();
				System.out.println("Account Holder Name: ");
				String accountHolder = scn.nextLine();
				bank.createAccount(accountNumber, accountHolder);
				break;
				
			case 2:
				//Deposit
				System.out.println("Enter account number to deposit: ");
				accountNumber = scn.nextLine();
				
				try {
					BankAccount account = bank.getAccount(accountNumber);
					System.out.println("Enter Amount to Deposit: ");
					double depositAmount = scn.nextDouble();
					account.deposite(depositAmount);
				}
				catch(AccountNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 3:
				//withdraw
				System.out.println("Enter Account number to Withdraw: ");
				accountNumber = scn.nextLine();
				
				try {
					BankAccount account = bank.getAccount(accountNumber);
					System.out.println("Enter Amount to Withdraw: ");
					double withdrawAmount = scn.nextDouble();
					account.withdraw(withdrawAmount);
				}
				catch(AccountNotFoundException e) {
					System.out.println(e.getMessage());
				}
				catch(InsufficientFundsException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 4:
				//Check balance
				System.out.println("Enter account number to check balance: ");
				accountNumber = scn.nextLine();
				try {
					BankAccount account = bank.getAccount(accountNumber);
					System.out.println("Balance: "+account.getBalance());
				}
				catch(AccountNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			
			case 5:
				//Exit
				System.out.println("Thank you for using the bank. GoodBye!");
				scn.close();
				return;
				
			default:
				System.out.println("InValid Choice. Please try again.");
			
			}

		}
	}
}
