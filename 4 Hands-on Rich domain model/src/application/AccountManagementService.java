package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map;

import models.Account;
import models.Credit;
import models.CreditAccount;
import models.Customer;

public class AccountManagementService {
	private Map<Integer, Customer> customerList = new HashMap<Integer, Customer>();
	private int customerNumberCounter = 0;
	private Map<Integer, Account> accountList = new HashMap<Integer, Account>();
	private int accountNumberCounter = 0;
	
	
	public AccountManagementService() {
		
	}
	
	public Customer newCustomer(String firstName, String familyName, LocalDate dateOfBirth) {
		Customer customer = new Customer(firstName, familyName, dateOfBirth, customerNumberCounter++);	
		customerList.put(customer.getCustomerNumber(), customer); 
		return customer;
	}
	
	public Account newAccount(float balance, Customer customer) {		
		Account account = new Account(accountNumberCounter++);	
		account.deposit(balance);
		accountList.put(account.getAccountnumber(), account);
		customer.getAccountList().add(account);
		return account;
	}
	
	public CreditAccount newCreditAccount(Credit credit) {		
		CreditAccount account = new CreditAccount(credit, accountNumberCounter++);		
		accountList.put(account.getAccountnumber(), account);
		credit.getCustomer().getAccountList().add(account);
		return account;
	}


	public List<Account> getAccountList() {
		return new ArrayList<Account>(accountList.values());
	}

	public List<Customer> getCustomerList() {
		return new ArrayList<Customer>(customerList.values());
	}

	
	public void transferMoney (float amount, int debitorAccountNumber, int creditorAccountNumber) {
		accountList.get(debitorAccountNumber).withdraw(amount);
		accountList.get(creditorAccountNumber).deposit(amount);
		
	}

	public Set<Integer> getAccountNumberList() {
		
		return accountList.keySet();
	}

	public Account getAccount(int accountNumber) {
		return accountList.get(accountNumber);
	}
	
	public Customer getCustomer(int accountNumber) {
		Customer customer = null;
		for (Map.Entry<Integer, Customer> entry : customerList.entrySet()) {
			List<Account> accountList = entry.getValue().getAccountList();
			Iterator<Account> iterator = accountList.iterator();
			while (iterator.hasNext() && customer == null) {
				Account account = iterator.next();
				if (account.getAccountnumber() == accountNumber)
				{
					customer = entry.getValue();
				}
			}			
		}
		return customer;
	}	
}