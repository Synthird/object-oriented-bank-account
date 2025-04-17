package makingtransactions.bankaccounts;

import java.util.ArrayList;

import makingtransactions.NegativeBalanceException;
import makingtransactions.Transaction;

/**
 * An abstract bank account class for creating different kinds of bank account.
 * 
 * @author Synthird
 * @version 1.0.0
 */
public abstract class BankAccount {
	private double balance;
	private String currency, accountName;

	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	private int transitNumber, institutionNumber, accountNumber;

	/**
	 * Create a bank account with a balance.
	 * 
	 * @param balance
	 * @param accountName
	 * @param currency
	 * @param transitNumber
	 * @param institutionNumber
	 * @param accountNumber
	 */
	public BankAccount(double balance, String accountName, String currency, int transitNumber, int institutionNumber,
			int accountNumber) {
		setAccountName(accountName);
		setBalance(balance);
		setCurrency(currency);
		setTransitNumber(transitNumber);
		setInstitutionNumber(institutionNumber);
		setAccountNumber(accountNumber);
	}

	/**
	 * Create a bank account without a balance.
	 * 
	 * @param accountName
	 * @param currency
	 * @param transitNumber
	 * @param institutionNumber
	 * @param accountNumber
	 */
	public BankAccount(String accountName, String currency, int transitNumber, int institutionNumber,
			int accountNumber) {
		setAccountName(accountName);
		setCurrency(currency);
		setTransitNumber(transitNumber);
		setInstitutionNumber(institutionNumber);
		setAccountNumber(accountNumber);
	}

	/**
	 * Get the balance of the bank account.
	 * 
	 * @return The balance of the account.
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Change the balance of the bank account.
	 * 
	 * @param balance
	 * @throws IllegalArgumentException
	 */
	public void setBalance(double balance) throws IllegalArgumentException {
		if (balance >= 0) {
			this.balance = balance;
		} else {
			throw new IllegalArgumentException("A negative balance is not allowed!");
		}
	}

	/**
	 * Get the currency on the bank account.
	 * 
	 * @return The currency on the account.
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Change the currency on the bank account.
	 * 
	 * @param currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Get the name of the bank account.
	 * 
	 * @return The name of the account.
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * Change the name of the bank account
	 * 
	 * @param accountName
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * Get an ArrayList of transactions.
	 * 
	 * @return An ArrayList of Transaction instances/objects.
	 */
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	/**
	 * Add a transaction to the bank account.
	 * 
	 * @param transaction
	 * @throws NegativeBalanceException
	 */
	public void addTransaction(Transaction transaction) throws NegativeBalanceException {
		double credit = transaction.getCredit();

		if (credit > balance) {
			throw new NegativeBalanceException(credit, balance);
		} else {
			transactions.add(transaction);
			balance += transaction.getDebit();
			balance -= credit;
		}
	}

	/**
	 * Get the transit number on the bank account.
	 * 
	 * @return The transit number on the account.
	 */
	public int getTransitNumber() {
		return transitNumber;
	}

	/**
	 * Change the transit number on the bank account.
	 * 
	 * @param transitNumber
	 */
	public void setTransitNumber(int transitNumber) {
		this.transitNumber = transitNumber;
	}

	/**
	 * Get the institution number on the bank account.
	 * 
	 * @return The institution number on the account.
	 */
	public int getInstitutionNumber() {
		return institutionNumber;
	}

	/**
	 * Change the institution number on the bank account.
	 * 
	 * @param institutionNumber
	 */
	public void setInstitutionNumber(int institutionNumber) {
		this.institutionNumber = institutionNumber;
	}

	/**
	 * Get the account number for the bank account.
	 * 
	 * @return The account number for the account.
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Change the account number for the bank account.
	 * 
	 * @param accountNumber
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return accountName;
	}
}
