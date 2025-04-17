package makingtransactions;

/**
 * A transaction class for creating transactions.
 * 
 * @author Synthird
 * @version 1.0.0
 */
public class Transaction {
	private String transactionName;
	private double debit, credit;

	/**
	 * Create a transaction with credit and debit.
	 * 
	 * @param transactionName - The name of the transaction.
	 * @param debit - The debit of the transaction.
	 * @param credit - The crebit of the transaction.
	 */
	public Transaction(String transactionName, double debit, double credit) {
		setTransactionName(transactionName);
		setDebit(debit);
		setCredit(credit);
	}

	/**
	 * Create a transaction without any credit and debit.
	 * 
	 * @param transactionName - The name of the transaction.
	 */
	public Transaction(String transactionName) {
		setTransactionName(transactionName);
	}

	/**
	 * Get the name of the transaction.
	 * 
	 * @return The name of the transaction.
	 */
	public String getTransactionName() {
		return transactionName;
	}

	/**
	 * Change the name of the transaction.
	 * 
	 * @param transactionName
	 */
	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

	/**
	 * Get the debit (How much money should be earned) for the transaction.
	 * 
	 * @return The debit for the transaction.
	 */
	public double getDebit() {
		return debit;
	}

	/**
	 * Change the debit (How much money should be earned) for the transaction.
	 * 
	 * @param debit
	 * @throws IllegalArgumentException
	 */
	public void setDebit(double debit) throws IllegalArgumentException {
		if (debit >= 0) {
			this.debit = debit;
		} else {
			throw new IllegalArgumentException("A negative debit is not allowed!");
		}
	}

	/**
	 * Get the crebit (How much money should be spent) for the transaction.
	 * 
	 * @return The credit for the transaction.
	 */
	public double getCredit() {
		return credit;
	}

	/**
	 * Change the credit (How much money should be spent) for the transaction.
	 * 
	 * @param credit
	 * @throws IllegalArgumentException
	 */
	public void setCredit(double credit) throws IllegalArgumentException {
		if (credit >= 0) {
			this.credit = credit;
		} else {
			throw new IllegalArgumentException("A negative credit is not allowed!");
		}
	}

	@Override
	public String toString() {
		return transactionName;
	}
}
