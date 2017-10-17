package javaass6;

import java.util.LinkedList;

public class User {

	// Create an User class with attributes name, age, address, phoneNumber and
	// bankAccountNumber
	private String name;
	private int age;
	private String address;
	private String phoneNumber;
	private String bankAccountNumber;
	private String password;
	private boolean isLoggin;
	private double availableBalance;
	private LinkedList<String> recentTransaction;

	User() {
	}

	public User(String name, int age, String address, String phoneNumber, String bankAccountNumber, String passWord,
			double availableBalance) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.bankAccountNumber = bankAccountNumber;
		this.password = passWord;
		this.isLoggin = false;
		this.availableBalance = availableBalance;
		this.recentTransaction = new LinkedList<String>();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLoggin() {
		return isLoggin;
	}

	public void setLoggin(boolean isLoggin) {
		this.isLoggin = isLoggin;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public LinkedList<String> getRecentTransaction() {
		return recentTransaction;
	}

	public void setRecentTransaction(LinkedList<String> recentTransaction) {
		this.recentTransaction = recentTransaction;
	}
}
