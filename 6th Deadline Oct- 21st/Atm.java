package javaass6;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Atm {

	private int availableAmountInMachine;
	private int transactionFee;
	private LinkedList<User> userData;
	private User currentUser;

	public Atm(int availableAmountInMachine, int transactionFee) {
		super();
		this.availableAmountInMachine = availableAmountInMachine;
		this.transactionFee = transactionFee;
		this.userData = new LinkedList<User>();
		this.userData.add(new User("Aaaaaa", 22, "1011 NE 56th ST", "1111111111", "111111", "123456", 0));
		this.userData.add(new User("Bbbbbb", 22, "1011 NE 56th ST", "2222222222", "222222", "123456", 1));
		this.userData.add(new User("Cccccc", 22, "1011 NE 56th ST", "3333333333", "333333", "123456", 2));
		this.userData.add(new User("Dddddd", 22, "1011 NE 56th ST", "4444444444", "444444", "123456", 3.5));
		this.userData.add(new User("Eeeeee", 22, "1011 NE 56th ST", "5555555555", "555555", "123456", 3.6));
		this.userData.add(new User("Ffffff", 22, "1011 NE 56th ST", "6666666666", "666666", "123456", 10000));
		this.userData.add(new User("Gggggg", 22, "1011 NE 56th ST", "7777777777", "777777", "123456", 1000000));
	}

	public static void main(String[] args) {
		Atm boa = new Atm(100000, 5);
		if (boa.isNew())
			boa.addNew();
		if (boa.passwordIsForgotten())
			boa.resetpassword();
		boa.login();
		if (boa.currentUser == null)
			System.exit(0);
		while (boa.currentUser.isLoggin()) {
			System.out.println("------------------------");
			System.out.println("your available balance: " + boa.currentUser.getAvailableBalance());
			System.out.println("press 1 to withDrawal;");
			System.out.println("press 2 to deposit;");
			System.out.println("press 3 for recentTransactions;");
			System.out.println("press 4 to change password;");
			System.out.println("press 0 to exit;");
			System.out.print("please:");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice) {
			case 0:
				boa.exit();
				break;
			case 1:
				boa.withDrawal();
				break;
			case 2:
				boa.deposit();
				break;
			case 3:
				boa.recentTransactions();
				break;
			case 4:
				boa.changePassword();
				break;
			}
		}
	}

	public boolean isNew() {
		System.out.print("New user press 1, current user press 2: ");
		Scanner sc = new Scanner(System.in);
		try {
			int i = sc.nextInt();
			if (i != 1 && i != 2) {
				throw new InputMismatchException();
			}
			if (i == 1) {
				return true;
			} else {
				return false;
			}
		} catch (InputMismatchException e) {
			return this.isNew();
		}
	}

	public void addNew() {
		// just an example
		User yuxin = new User("Yuxin", 22, "1011 NE 56th ST", "2066737628", "123456", "123456", 20000);
		System.out.println(yuxin.getName() + ", your account has been created!");
		userData.add(yuxin);
	}

	public boolean passwordIsForgotten() {
		System.out.print("Forgot password press 1, else press 2: ");
		Scanner sc = new Scanner(System.in);
		try {
			int i = sc.nextInt();
			if (i != 1 && i != 2) {
				throw new InputMismatchException();
			}
			if (i == 1) {
				return true;
			} else {
				return false;
			}
		} catch (InputMismatchException e) {
			return this.passwordIsForgotten();
		}
	}

	public void resetpassword() {
		Scanner sc = new Scanner(System.in);
		User temp = new User("default", 0, "default", "default", "default", "default", 0);
		System.out.print("your name: ");
		String name = sc.nextLine();
		for (User i : userData)
			if (name.equals(i.getName())) {
				temp = i;
				break;
			}
		if (temp.getName().equals("default")) {
			System.out.println("Sorry, not found your name!");
			return;
		}
		System.out.print("your age: ");
		int age = sc.nextInt();
		if (age != temp.getAge()) {
			System.out.println("Sorry, age wrong!");
			return;
		}
		System.out.print("your phone number: ");
		String phoneNumber = sc.nextLine();
		phoneNumber = sc.nextLine();
		if (!temp.getPhoneNumber().equals(phoneNumber)) {
			System.out.println("Sorry, not found your phone number!");
			return;
		} else {
			String password = "1";
			String password2 = "2";
			while (!password.equals(password2)) {
				System.out.print("your new password: ");
				password = sc.nextLine();
				System.out.print("confirm your password: ");
				password2 = sc.nextLine();
			}
			for (User i : userData)
				if (temp.getName().equals(i.getName())) {
					i.setPassword(password);
					break;
				}
		}
	}

	public void login() {
		System.out.print("phoneNumber: ");
		Scanner sc = new Scanner(System.in);
		String phoneNumber = sc.nextLine();
		System.out.print("password: ");
		String password = sc.nextLine();
		for (User i : userData) {
			if (i.getPhoneNumber().equals(phoneNumber) && i.getPassword().equals(password)) {
				i.setLoggin(true);
				currentUser = i;
				System.out.println(i.getName() + ", welcome!");
				return;
			}
		}
		System.out.println("Not login!");
	}

	public void withDrawal() {
		System.out.print("withDrawal amount: ");
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
		if (amount <= this.availableAmountInMachine
				&& (amount + this.transactionFee) <= this.currentUser.getAvailableBalance()) {
			this.currentUser.setAvailableBalance(this.currentUser.getAvailableBalance() - amount - this.transactionFee);
			this.availableAmountInMachine = this.availableAmountInMachine - amount;
			System.out.println("withDrawal succeeded!");
			if (this.currentUser.getRecentTransaction().size() < 10)
				this.currentUser.getRecentTransaction().add("withDrawal - " + amount);
			else {
				this.currentUser.getRecentTransaction().removeFirst();
				this.currentUser.getRecentTransaction().add("withDrawal - " + amount);
			}
		} else
			System.out.println("withDrawal failed!");
	}

	public void recentTransactions() {
		for (String i : this.currentUser.getRecentTransaction())
			System.out.println(i);
	}

	public void deposit() {
		System.out.print("deposit amount: ");
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
		this.availableAmountInMachine = this.availableAmountInMachine + amount;
		this.currentUser.setAvailableBalance(this.currentUser.getAvailableBalance() + amount - this.transactionFee);
		if (this.currentUser.getRecentTransaction().size() < 10)
			this.currentUser.getRecentTransaction().add("deposit - " + amount);
		else {
			this.currentUser.getRecentTransaction().removeFirst();
			this.currentUser.getRecentTransaction().add("deposit - " + amount);
		}
	}

	public void changePassword() {
		Scanner sc = new Scanner(System.in);
		System.out.print("new password: ");
		String password = sc.nextLine();
		System.out.print("confirm password: ");
		String password2 = sc.nextLine();
		if (!password.equals(password2)) {
			System.out.print("input again!");
			changePassword();
		}
		else {
			this.currentUser.setPassword(password);
			System.out.print("password changed!");
		}
	}

	public void exit() {
		this.currentUser.setLoggin(false);
		System.out.println("Thank you! Bye!");
	}
}
