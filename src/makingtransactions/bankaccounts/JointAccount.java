package makingtransactions.bankaccounts;

import java.util.ArrayList;

import userservice.User;

/**
 * A joint account class for creating a joint account with multiple holders..
 * 
 * @author Synthird
 * @version 1.0.0
 */
public class JointAccount extends BankAccount {
	private ArrayList<User> users = new ArrayList<User>();

	/**
	 * Create a joint account with a balance.
	 * 
	 * @param user
	 * @param balance
	 * @param accountName
	 * @param currency
	 * @param transitNumber
	 * @param institutionNumber
	 * @param accountNumber
	 */
	public JointAccount(User user, double balance, String accountName, String currency, int transitNumber,
			int institutionNumber, int accountNumber) {
		super(balance, accountName, currency, transitNumber, institutionNumber, accountNumber);
		addUser(user);
	}

	/**
	 * Create a joint account without a balance.
	 * 
	 * @param user
	 * @param accountName
	 * @param currency
	 * @param transitNumber
	 * @param institutionNumber
	 * @param accountNumber
	 */
	public JointAccount(User user, String accountName, String currency, int transitNumber, int institutionNumber,
			int accountNumber) {
		super(accountName, currency, transitNumber, institutionNumber, accountNumber);
		addUser(user);
	}

	/**
	 * Get an ArrayList of users connected to the joint account.
	 * 
	 * @return An ArrayLists of users connected to the joint account. This is
	 *         <strong>not</strong> the <code>users</code> field of the JointAccount
	 *         instance/object.
	 */
	public ArrayList<User> getUsers() {
		ArrayList<User> usersClone = new ArrayList<User>();
		usersClone.addAll(users);
		return usersClone;
	}

	/**
	 * Connect a user to the joint account.
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		if (!containsUser(user)) {
			users.add(user);
			user.addBankAccount(this);
		}
	}

	/**
	 * Remove a user from the joint account.
	 * 
	 * @param user
	 */
	public void removeUser(User user) {
		if (users.size() > 1) {
			if (containsUser(user)) {
				users.remove(user);
				user.getBankAccounts().remove(this);
			} else {
				System.out.println(String.format("%s is not part of this joint account called %s", user, this));
			}
		} else {
			System.err.println("A joint account must have at least one user!");
		}
	}

	/**
	 * Check to see if a user is connected to the joint account.
	 * 
	 * @param user
	 * @return <code>true</code> if the user is connected to the account. If not, it
	 *         returns <code>false</code>.
	 */
	public boolean containsUser(User user) {
		return users.contains(user);
	}
}
