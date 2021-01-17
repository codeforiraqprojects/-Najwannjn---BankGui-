import java.util.Date;
import java.util.Scanner;

//Creating multiple objects by one type only

//where we deposit and withdraw amount from our account.  
//Creating an Account class which has deposit() and withdraw() methods

class Account {
	// Default Constructor
	Account() {
	};

	// Constructor to initialize object values
	Account(int a, String n, float amt) {
		this.acc_no = a;
		this.name = n;
		this.amount = amt;
		this.create_dt = new Date();
	};

	int acc_no;
	String name;
	float amount;
	Date create_dt;
	Date deposit_dt;
	Date withdraw_dt;

	// Method to initialize object
	void insert(int a, String n, float amt) {
		acc_no = a;
		name = n;
		amount = amt;
	}

	// deposit method
	boolean deposit(float amt) {
		amount = amount + amt;
		deposit_dt = new Date();
		return true;
		//System.out.println(amt + " deposited " + "at " + deposit_dt);
	}

	// withdraw method
	boolean withdraw(float amt) {
		if (amount < amt) {
			//System.out.println("Insufficient Balance");
			return false;
		} else {
			amount = amount - amt;
			withdraw_dt = new Date();
			return true;
			//System.out.println(amt + " withdrawn " + "at " + withdraw_dt);
		}
	}

	// method to check the balance of the account
	void checkBalance() {
		System.out.println("Balance is: " + amount);
	}

	// method to display the values of an object
	void display() {
		System.out.println(acc_no + " " + name + " " + amount);
	}
}
