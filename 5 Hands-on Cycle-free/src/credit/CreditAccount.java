package credit;

import valueObjects.AccountNumber;
import valueObjects.Amount;

public class CreditAccount {
	private Amount balance;
	private AccountNumber accountNumber;

	public CreditAccount(Amount amountOfCredit) {
		super();
		this.balance = Amount.of(0).subtract(amountOfCredit);
		this.accountNumber = AccountNumber.getValidAccountNumber();
	}

	public Amount getBalance() {
		return balance;
	}

	public AccountNumber getAccountnumber() {
		return accountNumber;
	}

	public void deposit(Amount amount) {
		this.balance = balance.add(amount);
	}

	public void withdraw(Amount amount) {
		this.balance = balance.subtract(amount);
	}
}
