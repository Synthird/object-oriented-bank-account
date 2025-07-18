package userservice;

import java.util.ArrayList;

import makingtransactions.bankaccounts.BankAccount;
import makingtransactions.bankaccounts.JointAccount;

/**
 * A class for creating a user.
 * 
 * @author Synthird
 * @version 1.0.1
 */
public final class User {
	private String name;
	private int age, userId;

	private ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();

	private ArrayList<String> emailAddresses = new ArrayList<String>();
	private ArrayList<String> phoneNumbers = new ArrayList<String>();

	/**
	 * Create a user.
	 * 
	 * @param name   The name of the user.
	 * @param age    The age of the user.
	 * @param userId The user ID.
	 */
	public User(String name, int age, int userId) {
		setName(name);
		setAge(age);
		setUserId(userId);
	}

	/**
	 * Create a user with an email address.
	 * 
	 * @param name   The name of the user.
	 * @param age    The age of the user.
	 * @param userId The user ID.
	 * @param email  An email address.
	 */
	public User(String name, int age, int userId, String email) {
		setName(name);
		setAge(age);
		setUserId(userId);
		addEmail(email);
	}

	/**
	 * Create a user with an phone number.
	 * 
	 * @param name        The name of the user.
	 * @param age         The age of the user.
	 * @param userId      The user ID.
	 * @param email       An email address.
	 * @param phoneNumber A phone number.
	 */
	public User(String name, int age, int userId, String email, String phoneNumber) {
		setName(name);
		setAge(age);
		setUserId(userId);
		addEmail(email);
		addPhoneNumber(phoneNumber);
	}

	/**
	 * Get the name of the user.
	 * 
	 * @return The name of the user.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the user.
	 * 
	 * @param name The name of the user.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the age of the user.
	 * 
	 * @return The age of the user.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Set the age of the user.
	 * 
	 * @param age The age of the user.
	 * @throws IllegalArgumentException If age is 0 or below.
	 */
	public void setAge(int age) throws IllegalArgumentException {
		if (age <= 0) {
			throw new IllegalArgumentException("A user with an age of 0 or below is not allowed!");
		} else {
			this.age = age;
		}
	}

	/**
	 * Increment the age of the user by one.
	 */
	public void incrementAge() {
		age++;
	}

	/**
	 * Get the ID of the user.
	 * 
	 * @return The ID of the user.
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Set the ID of the user.
	 * 
	 * @param userId The ID of the user.
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Get the <code>ArrayList</code> of bank accounts from a user.
	 * 
	 * @return An <code>ArrayList</code> of BankAccount classes.
	 */
	public ArrayList<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	/**
	 * Give the user a bank account.
	 * 
	 * @param bankAccount The bank account to be added.
	 */
	public void addBankAccount(BankAccount bankAccount) {
		if (!bankAccounts.contains(bankAccount)) {
			bankAccounts.add(bankAccount);

			if (bankAccount instanceof JointAccount) {
				((JointAccount) bankAccount).addUser(this);
			}
		}
	}

	/**
	 * Remove a bank account from the user.
	 * 
	 * @param bankAccount The bank account to be removed.
	 */
	public void removeBankAccount(BankAccount bankAccount) {
		boolean removedAccount = bankAccounts.remove(bankAccount);

		if (removedAccount && bankAccount instanceof JointAccount) {
			((JointAccount) bankAccount).removeUser(this);
		}
	}

	/**
	 * Add an email to the <code>ArrayList</code> of email addresses
	 * 
	 * @param email The email to be added.
	 */
	public void addEmail(String email) {
		emailAddresses.add(email);
	}

	/**
	 * Remove an email address from the user.
	 * 
	 * @param email The email to be removed.
	 */
	public void removeEmail(String email) {
		removeFromStringArrayList(email, emailAddresses);
	}

	/**
	 * Get an <code>ArrayList</code> of email addresses linked to the user.
	 * 
	 * @return An <code>ArrayList</code> of email addresses.
	 */
	public ArrayList<String> getEmailAddresses() {
		return emailAddresses;
	}

	/**
	 * Add a phone number to the user.
	 * 
	 * @param phoneNumber The phone number to be added.
	 */
	public void addPhoneNumber(String phoneNumber) {
		phoneNumbers.add(phoneNumber);
	}

	/**
	 * Remove a phone number from the user.
	 * 
	 * @param phoneNumber The phone number to be removed.
	 */
	public void removePhoneNumber(String phoneNumber) {
		removeFromStringArrayList(phoneNumber, phoneNumbers);
	}

	/**
	 * Get an <code>ArrayList</code> of phone numbers linked to the user.
	 * 
	 * @return An <code>ArrayList</code> of phone numbers.
	 */
	public ArrayList<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	@Override
	public String toString() {
		return name;
	}

	/**
	 * @hidden
	 * @param item            The item to be removed.
	 * @param stringArrayList An ArrayList of strings.
	 */
	private void removeFromStringArrayList(String item, ArrayList<String> stringArrayList) {
		if (stringArrayList.contains(item)) {
			stringArrayList.remove(item);
		} else {
			System.out.println(String.format("%s was not found! Nothing was removed", item));
		}
	}
}
