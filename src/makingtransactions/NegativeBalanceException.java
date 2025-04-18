package makingtransactions;

/**
 * A custom exception for cases where credit on a transaction is bigger than the
 * balance on a bank account.
 * 
 * @author Synthird
 * @version 1.0.0
 */
public class NegativeBalanceException extends Exception {
	private double credit, balance;

	/**
	 * Throw the NegativeBalanceException, to avoid a negative balance on a bank
	 * account.
	 * 
	 * @param credit  The credit of the transaction.
	 * @param balance The balance on the bank account.
	 */
	public NegativeBalanceException(double credit, double balance) {
		this.credit = credit;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return String.format("Credit %.2f is bigger than balance %.2f! No values were changed.", credit, balance);
	}
}
