package Transaction;

import java.util.Scanner;

class Transaction {
	private String acc_no;
	private String Name;
	private String acc_type;
	private long balance;
	private long pin;

	// Method for open Account
	Scanner sc = new Scanner(System.in);

	public void open_Acc() {
		System.out.println("Enter  Customer Account Number:");
		acc_no = sc.next();
		System.out.println("Enter customer Name:");
		Name = sc.next();
		System.out.println("Enter Account type:");
		acc_type = sc.next();
		System.out.println("Enter Balance:");
		balance = sc.nextLong();
		System.out.println("Enter Pin:");
		pin = sc.nextLong();
	}
     //method for show customer details
	public void showAccount() {
		System.out.println("Customer Account Number: " + acc_no);
		System.out.println("Customer Name: " + Name);
		System.out.println("Customer Account Type: " + acc_type);
		System.out.println("Customer Balance: " + balance);
	}

	// Method for credit Amount
	public void deposit() {
		long amt;
		System.out.println("Enter Amount you want deposit");
		amt = sc.nextLong();
		balance = balance + amt;
		System.out.println("Available Balance: " + balance);
	}

// Method for Debit Amount
	public void debit() {
		long amt;
		System.out.println("Enter Amount you want to withdraw");
		amt = sc.nextLong();
		if (amt <= balance) {
			balance = balance - amt;
			System.out.println("Balance After withdrawl: " + balance);
		} else
			System.out.println("You Don't have sufficient balance in your Account" + amt + "\tTransaction failed");
	}
	public void abc() {
		System.out.println("hello");
	}

// method for Balance inquiry
	public void Balance() {
		System.out.println("Available balance in your Account is:" + balance);
	}

	// Method for pin change
	public void Pin() {
		long p;
		// System.out.println("Do you Want to Change your Pin");
		System.out.println("Enter your old pin number");
		p = sc.nextLong();
		if (p == pin) {
			System.out.println("Enter your new pin number");
			int n = sc.nextInt();
			System.out.println("Enter your confirm pin number");
			int c = sc.nextInt();
			if (n == c) {
				pin = n;
				System.out.println("Updated pin:" + pin);
			} else
				System.out.println("You Entered Wrong pin");
		} else
			System.out.println("you entered wrong  pin");
	}
//method for show customer details through Account number
	public boolean search(String ac_no) {
		if (acc_no.equals(ac_no)) {
			showAccount();
			return (true);
		}
		return (false);
	}
}

public class BankingSystem{

	public static void main(String[] args)throws Exception  {

		int n, i;
		Scanner sc = new Scanner(System.in);
		System.out.println("How many Customer data you want to enter");
		n = sc.nextInt();
		int no = 1;
		Transaction t[] = new Transaction[n];
		for (i = 0; i < t.length; i++) {
			System.out.println("Customer: " + no);
			t[i] = new Transaction();
			t[i].open_Acc();
			no++;
		}
		
		int c;
		do {
			System.out.println("\n***Banking System Application***");
			System.out.println("1.Deposite Amount\n2.Withdraw Amount\n3.Balance Enquiery\n4.Change Pin\n5.Exit");
			System.out.println("Enter Your Choise");
			c = sc.nextInt();
			try {

			switch (c) {
		
			case 1:
				System.out.print("Enter Account no. : ");
				String ac_no = sc.next();
				boolean found = false;
				for (i = 0; i < t.length; i++) {
					found = t[i].search(ac_no);

					if (found) {
						t[i].deposit();
						break;
					}
				}
				if (!found) {
					System.out.println("Account doesn't exist");
				}
				break;
			case 2:
				System.out.print("Enter Account no. : ");

				ac_no = sc.next();
				found = false;
				for (i = 0; i < t.length; i++) {
					found = t[i].search(ac_no);
					if (found) {
						t[i].debit();
						break;
					}
				}
				if (!found) {
					System.out.println("Account doesn't exist");
				}
				break;
			case 3:
				System.out.print("Enter Account no. : ");

				ac_no = sc.next();
				found = false;
				for (i = 0; i < t.length; i++) {
					found = t[i].search(ac_no);
					if (found) {
						t[i].Balance();
						break;
					}
				}
				if (!found) {
					System.out.println("Account doesn't exist");
				}
				break;
			case 4:
				System.out.print("Enter Account no. : ");

				ac_no = sc.next();
				found = false;
				for (i = 0; i < t.length; i++) {
					found = t[i].search(ac_no);
					if (found) {
						t[i].Pin();
						break;
					}
				}
				if (!found) {
					System.out.println("Account doesn't exist");
				}
				break;
				
			case 5:
				System.out.println("See you soon");
				break;

			}}
			catch(Exception e)
			{
				System.out.print("Enter Number between 1 to 5");
			}
				
		}
		while (c != 5);
	}

}