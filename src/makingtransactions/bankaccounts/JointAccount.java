package makingtransactions.bankaccounts;

import java.util.ArrayList;

import userservice.User;

/**
 * A joint account class for creating a joint account containing multiple
 * holders.
 * 
 * @author Synthird
 * @version 1.0.0
 */
public class JointAccount extends BankAccount {
	private ArrayList<User> users = new ArrayList<User>();

	/**
	 * Create a joint account with a balance.
	 * 
	 * @param user              The first user to hold the account.
	 * @param balance           The balance of the account.
	 * @param accountName       The name of the account.
	 * @param currency          The type of currency.
	 * @param transitNumber     The transit number.
	 * @param institutionNumber The institution number.
	 * @param accountNumber     The account number.
	 */
	public JointAccount(User user, double balance, String accountName, String currency, int transitNumber,
			int institutionNumber, int accountNumber) {
		super(balance, accountName, currency, transitNumber, institutionNumber, accountNumber);
		addUser(user);
	}

	/**
	 * Create a joint account without a balance.
	 * 
	 * @param user              The first user to hold the account.
	 * @param accountName       The name of the account.
	 * @param currency          The type of currency.
	 * @param transitNumber     The transit number.
	 * @param institutionNumber The institution number.
	 * @param accountNumber     The account number.
	 */
	public JointAccount(User user, String accountName, String currency, int transitNumber, int institutionNumber,
			int accountNumber) {
		super(accountName, currency, transitNumber, institutionNumber, accountNumber);
		addUser(user);
	}

	/**
	 * Get an <code>ArrayList</code> of users connected to the joint account.
	 * 
	 * @return An <code>ArrayList</code> of users connected to the joint account.
	 *         This is
	 *         not the <code>users</code> field of the JointAccount
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
	 * @param user The user to be added to the joint account.
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
	 * @param user The user to be removed from the joint account.
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
	 * @param user The user that is being checked.
	 * @return <code>true</code> if the user is connected to the account. If not, it
	 *         returns <code>false</code>.
	 */
	public boolean containsUser(User user) {
		return users.contains(user);
	}
}
