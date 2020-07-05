package Com.Bank.Register.Model;
import java.util.Date;

public class Customer 
{
	private int customer_Id;
	private String customer_Name;
	private String address;
	private String customer_DOB;
	private long mobile_No;
	private String email_Id;
	private String customer_UID;
	
	public Customer(Customer c)
	{
		this.customer_Id = c.customer_Id;
		this.customer_Name = c.customer_Name;
		this.address = c.address;
		this.customer_DOB= c.customer_DOB;
		this.mobile_No = c.mobile_No;
		this.email_Id = c.email_Id;
		this.customer_UID = c.customer_UID;
	}
	
	public Customer(String customer_Name, String address, String customer_DOB, String customer_UID)
	{
		super();
		this.customer_Name = customer_Name;
		this.address = address;
		this.customer_DOB = customer_DOB;
		this.customer_UID = customer_UID;
	}



	public Customer(int customer_Id, String customer_Name, String address, String customer_DOB, long mobile_No,
			String email_Id, String customer_UID)
	{
		this.customer_Id = customer_Id;
		this.customer_Name = customer_Name;
		this.address = address;
		this.customer_DOB= customer_DOB;
		this.mobile_No = mobile_No;
		this.email_Id = email_Id;
		this.customer_UID = customer_UID;
	}

	public int getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}

	public String getCustomer_Name() {
		return customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustomer_DOB() {
		return customer_DOB;
	}

	public void setCustomer_DOB(String customer_DOB) {
		this.customer_DOB = customer_DOB;
	}

	public long getMobile_No() {
		return mobile_No;
	}

	public void setMobile_No(long mobile_No) {
		this.mobile_No = mobile_No;
	}

	public String getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}

	public String getCustomer_UID() {
		return customer_UID;
	}

	public void setCustomer_UID(String customer_UID) {
		this.customer_UID = customer_UID;
	}
}