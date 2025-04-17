package makingtransactions.bankaccounts;

import userservice.User;

/**
 * A single account class for creating a single account containing only one holder.
 * 
 * @author Synthird
 * @version 1.0.0
 */
public class SingleAccount extends BankAccount {
	private User userHolder;

	/**
	 * Create a single account with a balance.
	 * 
	 * @param userHolder        The account holder.
	 * @param balance           The balance of the account.
	 * @param accountName       The name of the account.
	 * @param currency          The type of currency.
	 * @param transitNumber     The transit number.
	 * @param institutionNumber The institution number.
	 * @param accountNumber     The account number.
	 */
	public SingleAccount(User userHolder, double balance, String accountName, String currency, int transitNumber,
			int institutionNumber, int accountNumber) {
		super(balance, accountName, currency, transitNumber, institutionNumber, accountNumber);
		setUserHolder(userHolder);
	}

	/**
	 * Create a single account without a balance.
	 * 
	 * @param userHolder        The account holder.
	 * @param accountName       The name of the account.
	 * @param currency          The type of currency.
	 * @param transitNumber     The transit number.
	 * @param institutionNumber The institution number.
	 * @param accountNumber     The account number.
	 */
	public SingleAccount(User userHolder, String accountName, String currency, int transitNumber, int institutionNumber,
			int accountNumber) {
		super(accountName, currency, transitNumber, institutionNumber, accountNumber);
		setUserHolder(userHolder);
	}

	/**
	 * Get the holder of the bank account.
	 * 
	 * @return The holder of the account.
	 */
	public User getUserHolder() {
		return userHolder;
	}

	/**
	 * Change the holder of the account.
	 * 
	 * @param userHolder The account holder.
	 */
	public void setUserHolder(User userHolder) {
		this.userHolder = userHolder;
		userHolder.addBankAccount(this);
	}
}
