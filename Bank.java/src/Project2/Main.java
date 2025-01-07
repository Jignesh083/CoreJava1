package Project2;

import java.util.Scanner;

import Project2.ExceptionHandling.AccountNotFoundException;
import Project2.ExceptionHandling.InsufficientFundException;

public class Main {
	public static void main(String[] args) {
		Bank bank = new Bank(10);
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
			case 1:
				System.out.println("Enter Account Number: ");
				String accountNumber = scn.nextLine();
				System.out.println("Account Holder Name: ");
				String accountHolder = scn.nextLine();
				bank.createAccounts(accountNumber, accountHolder);
				break;
			
			case 2:
				System.out.println("Enter Account number to Deposit: ");
				accountNumber = scn.nextLine();
				
				try {
					BankAccount account = bank.getAccount(accountNumber);
					System.out.println("Enter your Deposit Amount: ");
					double depositAmount = scn.nextDouble();
					account.dposite(depositAmount);
				} catch (AccountNotFoundException e) {
					System.out.println(e.getMessage());
				}	
				break;
			case 3:
				System.out.println("Enter Account number to Withdraw: ");
				accountNumber = scn.nextLine();
				
				try {
					BankAccount bankAccount = bank.getAccount(accountNumber);
					System.out.println("Enter Amount to withdraw: ");
					double withdrawAmount = scn.nextDouble();
					bankAccount.withdraw(withdrawAmount);
				} catch (AccountNotFoundException e) {
					System.out.println(e.getMessage());
				}
				catch(InsufficientFundException e) {
					System.out.println(e.getMessage());
				}
				
				break;
				
			case 4:
				System.out.println("Enter account number to check balance: ");
				accountNumber = scn.nextLine();
				
				try {
					BankAccount bankAccount = bank.getAccount(accountNumber);
					System.out.println("Balance: "+bankAccount.getBalance());
				} catch (AccountNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			
			default:
				System.out.println("Thank you for using the bank. GoodBye!");
			}
			
				
		}
	}
}
