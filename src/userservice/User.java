package userservice;

import java.util.ArrayList;

import makingtransactions.bankaccounts.BankAccount;
import makingtransactions.bankaccounts.JointAccount;

/**
 * A user class for creating a user.
 * 
 * @author Synthird
 * @version 1.0.0
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
	 * @param name - The name of the user.
	 * @param age - The age of the user.
	 * @param userId - The user ID.
	 */
	public User(String name, int age, int userId) {
		setName(name);
		setAge(age);
		setUserId(userId);
	}

	/**
	 * Create a user with an email address.
	 * 
	 * @param name - The name of the user.
	 * @param age - The age of the user.
	 * @param userId -- The user ID.
	 * @param email - An email address.
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
	 * @param name - The name of the user.
	 * @param age - The age of the user.
	 * @param userId - The user ID.
	 * @param email - An email address.
	 * @param phoneNumber - A phone number.
	 */
	public User(String name, int age, int userId, String email, String phoneNumber) {
		setName(name);
		setAge(age);
		setUserId(userId);
		addEmail(email);
		addPhoneNumber(phoneNumber);
	}

	/**
	 * @return The name of the user.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Changes the name of the user.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return The age of the user.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Set the age of the user.
	 * 
	 * @param age
	 * @throws IllegalArgumentException if age is 0 or below.
	 */
	public void setAge(int age) throws IllegalArgumentException {
		if (age <= 0) {
			throw new IllegalArgumentException("A person's age cannot be 0 or below!");
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
	 * Get the userId of the user.
	 * 
	 * @return The userId of the user.
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Change the userId of the user.
	 * 
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Get the user's ArrayList of bank accounts.
	 * 
	 * @return An ArrayList of BankAccount classes.
	 */
	public ArrayList<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	/**
	 * Give the user a bank account.
	 * 
	 * @param bankAccount
	 */
	public void addBankAccount(BankAccount bankAccount) {
		bankAccounts.add(bankAccount);

		if (bankAccount instanceof JointAccount) {
			((JointAccount) bankAccount).addUser(this);
		}
	}

	/**
	 * Add an email to the ArrayList of email addresses
	 * 
	 * @param email
	 */
	public void addEmail(String email) {
		emailAddresses.add(email);
	}

	/**
	 * Remove an email address from the user.
	 * 
	 * @param email
	 */
	public void removeEmail(String email) {
		removeFromStringArrayList(email, emailAddresses);
	}

	/**
	 * Get an ArrayList of email addresses linked to the user.
	 * 
	 * @return An ArrayList of email addresses.
	 */
	public ArrayList<String> getEmailAddresses() {
		return emailAddresses;
	}

	public void addPhoneNumber(String phoneNumber) {
		phoneNumbers.add(phoneNumber);
	}

	/**
	 * Remove a phone number from the user.
	 * 
	 * @param phoneNumber
	 */
	public void removePhoneNumber(String phoneNumber) {
		removeFromStringArrayList(phoneNumber, phoneNumbers);
	}

	/**
	 * Get an ArrayList of phone numbers linked to the user.
	 * 
	 * @return An ArrayList of phone numbers.
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
	 * @param item
	 * @param stringArrayList
	 */
	private void removeFromStringArrayList(String item, ArrayList<String> stringArrayList) {
		if (stringArrayList.contains(item)) {
			stringArrayList.remove(item);
		} else {
			System.out.println(String.format("%s was not found! Nothing was removed", item));
		}
	}
}
