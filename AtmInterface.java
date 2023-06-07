import java.util.Scanner;

class Bank
{
	String account;
	String name;
	String accountType;
	Double bal;
	Scanner sc = new Scanner(System.in);

	public void OpenAccount()
	{
		System.out.println("Enter the bank account Number: ");
		account = sc.next();
		System.out.println("Enter the Account Holder Name: ");
		name = sc.next();
		System.out.println("Enter your Account Type: ");
		accountType = sc.next();
		System.out.println("Enter the Balance: ");
		bal = sc.nextDouble();
		System.out.println("Congrats Your Account is Created");
        System.out.println("Your account number is "+account);
	}
	public void deposite()
	{
		System.out.println("Enter the amount you want to deposite: ");
		double amount = sc.nextDouble();
		bal = bal + amount;
		System.out.println("Your "+amount+" deposited");
	}
	public void withdraw()
	{
		System.out.println("Enter the amount..");
		double amount = sc.nextDouble();
		if(bal>=amount)
		{
			bal = bal - amount;
		    System.out.println("Your "+amount+" Withdraw");
		}else{
			System.out.println("Your balance is less than "+amount+" Transition faild");
		}
	}
	public void transfer()
	{
		System.out.println("Enter the amount you Want to Transfer..");
		double amount = sc.nextDouble();
		if(bal>=amount)
		{
			if(amount<=65000)
			{
				balance = balance + amt;
				System.out.println("Your "+amount+" is Successfully Transfer");
			}
			else{
				System.out.println("Sorry...Limit is 65000.0");
			}
		}else{
			System.out.println("Insufficient Balance...");
		}
	}

	public void showAccount()
	{
		
		System.out.println("Name of Account Holder: "+name);
		System.out.println("Account Number: "+account);
		System.out.println("Account Type: "+accountType);
		System.out.println("Balance: "+bal);
		
	}
	public boolean search(String ac_no)
	{
		if(account.equals(ac_no))
		{
			showAccount();
			return(true);
		}
		return(false);
	}
}
 class AtmInterface
{

	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("How Many Number Of Customer do you want to Input:");
		int n = sc.nextInt();
		Bank A[] = new Bank[n];
		for(int i=0;i<A.length;i++)
		{
			A[i] = new Bank();
			A[i].OpenAccount();
		}
		int choice;
		do
		{
			System.out.println("\n");
			System.out.println("Welcome to Atm Interface");
			System.out.println("\n");
			System.out.println("1.Open Account");
			System.out.println("2.Deposite");
			System.out.println("3.Withdraw");
			System.out.println("4.Transfer");
			System.out.println("5.Display");
			System.out.println("0.Exit");
			System.out.println("Enter your choice here: ");
			choice = sc.nextInt();
			if(choice==0)
			{
				break;
			}
			if(choice==1)
			{
				for(int i=0;i<A.length;i++)
				{
					A[i].OpenAccount();
				}
				break;
			}
			else if(choice==2)
			{
				System.out.println("Enter account no: ");
				String ac_no = sc.next();
				boolean found = false;
				for(int i=0;i<A.length;i++)
				{
					found = A[i].search(ac_no);
					if(found)
					{
						A[i].deposite();
					}
				}
				if(!found)
				{
					System.out.println("Account dosent Exit....");
				}
			}
			else if(choice==3)
			{
				System.out.println("Enter account no: ");
				String ac_no = sc.next();
				boolean found = false;
				for(int i=0;i<A.length;i++)
				{
					found = A[i].search(ac_no);
					if(found)
					{
						A[i].withdraw();
					}
				}
				if(!found)
				{
					System.out.println("Account dosent Exit....");
				}
			}
			else if(choice==4)
			{
				System.out.println("Enter account no: ");
				String ac_no = sc.next();
				boolean found = false;
				for(int i=0;i<A.length;i++)
				{
				found = A[i].search(ac_no);
					if(found)
					{
						A[i].transfer();
					}
				}
				if(!found)
				{
					System.out.println("Account dose not Exit....");
				}
			}
			else if(choice==5)
			{
				for(int i=0;i<A.length;i++)
				{
					A[i].showAccount();
				}
			}
		}
		while(choice!=0);
	}
}