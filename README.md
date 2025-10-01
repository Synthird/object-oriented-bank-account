# Object Oriented Bank Account

An OOP class library for simulating bank accounts.

It is not meant for full-blown banking systems in everyday life.

[Documentation](https://synthird.github.io/object-oriented-bank-account/) is also available.

<details>
<summary>Sample code</summary>

```Java
import makingtransactions.NegativeBalanceException;
import makingtransactions.Transaction;
import makingtransactions.bankaccounts.JointAccount;
import makingtransactions.bankaccounts.SingleAccount;
import userservice.User;

public class TestZone {
	public static void main(String[] args) throws NegativeBalanceException {
		User user = new User("User", 15, 25);
		User wow = new User("Wow", 15, 21);

		SingleAccount singleAccount = new SingleAccount(45, user, "Single", "USD", 152, 23, 12);
		JointAccount jointAccount = new JointAccount(user, "Joint", "USD", 02, 01, 20);

		System.out.println("--- Swapping single account owners ---");

		System.out.println("User accounts: " + user.getBankAccounts());
		System.out.println("Wow accounts: " + wow.getBankAccounts());

		singleAccount.setUserHolder(wow);

		System.out.println("\nSwapped holder to Wow:\n");
		System.out.println("User holder: " + singleAccount.getUserHolder());

		System.out.println("User accounts: " + user.getBankAccounts());
		System.out.println("Wow accounts: " + wow.getBankAccounts());

		System.out.println("--- Adding and removing joint account users ---");

		System.out.println(jointAccount.getUsers());

		jointAccount.addUser(wow);
		System.out.println(jointAccount.getUsers());

		jointAccount.addUser(wow);
		System.out.println(jointAccount.getUsers());

		jointAccount.removeUser(user);
		System.out.println(jointAccount.getUsers());

		jointAccount.removeUser(wow);
		System.out.println(jointAccount.getUsers());

		System.out.println("--- TRANSACTIONS ---");

		Transaction transaction = new Transaction("Groceries", 0, 0, 12);

		System.out.println("Single account before: " + singleAccount.getBalance());

		singleAccount.addTransaction(transaction);

		System.out.println("Single account now: " + singleAccount.getBalance());
		System.out.println("Single account transactions: " + singleAccount.getTransactions());
	}
}
```
</details>

## Installation

The library is contained in a jar file in the [releases page](https://github.com/Synthird/object-oriented-bank-account/releases/latest).

**Note:** The process of inserting the jar file into your project depends on your IDE and build tools.

### Visual Studio Code Java project (No build tools)

Download the jar file and place it into the ```lib``` folder, which is located at the root of the project.

![Jar file in the root folder of a non-build tools Java project](https://github.com/user-attachments/assets/1984ea04-bfa1-4796-99f2-e556834e81ec)

If there is not a ```lib``` folder at the root folder, create it.

## License

This repository contains the MIT license. You must give credit if you are going to use its source code or the class library.
