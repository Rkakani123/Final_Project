package Com.Bank.Register.Model;

public class Account extends Customer
{
	private long account_No;
	private String account_Type;
	private String username;
	private String password;	
	private double Balance;
	
	public Account(Customer c,long account_No, String account_Type)
	{
		super(c);
		this.account_No = account_No;
		this.account_Type = account_Type;		
	}
	
	public Account(Customer c, long account_No, String account_Type, String username, String password)
	{
		super(c);
		this.account_No = account_No;
		this.account_Type = account_Type;
		this.username = username;
		this.password = password;
	}
	
	public Account(Account a)
	{
		super(a.getCustomer_Id(), a.getCustomer_Name(), a.getAddress(), a.getCustomer_DOB(), a.getMobile_No(), a.getEmail_Id(), a.getCustomer_UID());
		this.account_No = a.account_No;
		this.account_Type = a.account_Type;
		this.username = a.username;
		this.password = a.password;	
	}
	
	public long getAccount_No() {
		return account_No;
	}

	public void setAccount_No(long account_No) {
		this.account_No = account_No;
	}

	public String getAccount_Type() {
		return account_Type;
	}

	public void setAccount_Type(String account_Type) {
		this.account_Type = account_Type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		Balance = balance;
	}
	
 
}
