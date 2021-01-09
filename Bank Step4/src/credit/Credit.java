package credit;

import valueObjects.Amount;
import valueObjects.CreditNumber;

public class Credit {
	private Amount amountOfCredit;
	private CreditNumber creditNumber;
	private Status status;
	private CreditAccount account;


	public enum Status {
		applied,
		refused,
		granted,
		delayed,
		payed
	};
	
	public Credit(Amount amountOfCredit) {
		super();
		this.amountOfCredit = amountOfCredit;
		this.creditNumber = new CreditNumber();
		this.status = Status.applied;
	}

	public Amount getAmountOfCredit() {
		return amountOfCredit;
	}

	public void setAmountOfCredit(Amount amountOfCredit) {
		this.amountOfCredit = amountOfCredit;
	}


	public CreditNumber getCreditNumber() {
		return creditNumber;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public CreditAccount getAccount() {
		return account;
	}

	public void setAccount(CreditAccount account) {
		this.account = account;
	}

}
