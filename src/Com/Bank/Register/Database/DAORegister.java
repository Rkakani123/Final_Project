package Com.Bank.Register.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import Com.Bank.Register.Model.Account;
import Com.Bank.Register.Model.Current_Account;
import Com.Bank.Register.Model.Customer;
import Com.Bank.Register.Model.Saving_Account;
import Com.Bank.Register.Service.RegisterService;

public class DAORegister implements RegisterService
{
	public Connection getConnection()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_webproject","root","Rkakani");
		}
		catch(Exception e)
		{	}
		return conn;
	}
	public int addCustomer(Customer c)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_webproject","root","Rkakani");
			PreparedStatement ps = conn.prepareStatement("insert into customerdetails values(0,?,?,?,?,?,?)");
			ps.setString(1,c.getCustomer_Name());
			ps.setString(2,c.getAddress());
			ps.setLong(3,c.getMobile_No());
			ps.setString(4,c.getEmail_Id());
			ps.setString(5,c.getCustomer_UID());
			ps.setString(6,c.getCustomer_DOB());
			ps.execute();
			return 1;
		}
		catch(Exception e)
		{		
			e.printStackTrace(); 
			return 0;
		}
	}
	public List<Customer> getAllCustomer()
	{
		List<Customer> lst = new LinkedList<Customer>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_webproject","root","Rkakani");
			PreparedStatement ps = conn.prepareStatement("select * from customerdetails");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Customer c = new Customer(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getLong(5), rs.getString(6), rs.getString(7));
				lst.add(c);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
		return lst;
	}
	public void deleteCustomer(int CustomerId)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_webproject","root","Rkakani");
			PreparedStatement ps = conn.prepareStatement("delete from customerdetails where CustomerId=?");
			ps.setInt(1,CustomerId);
			ps.execute();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
	}
	public Customer getCustomer(int CustomerId)
	{
		Customer c = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_webproject","root","Rkakani");
			PreparedStatement ps = conn.prepareStatement("select * from customerdetails");
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{ c = new Customer(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getLong(5), rs.getString(6), rs.getString(7)); }
		}
		catch(Exception e)
		{	e.printStackTrace();	}
		return c;
	}
	public int getCustomerId(long Mob)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_webproject","root","Rkakani");
			PreparedStatement ps = conn.prepareStatement("select CustomerId from customerdetails where Mobile=? ");
			ps.setLong(1,Mob);			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
		}
		catch(Exception e)
		{		e.printStackTrace(); 	}
		return 0;
	}
	public int addAccount(Account a)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_webproject","root","Rkakani");
			PreparedStatement ps = conn.prepareStatement("insert into accountdetails values(?,?,?,?,aes_encrypt(?,?),?)");
			ps.setLong(1,a.getAccount_No());
			ps.setInt(2,a.getCustomer_Id());
			ps.setString(3,a.getAccount_Type());
			ps.setString(4,a.getUsername());
			ps.setString(5,a.getPassword());
			ps.setString(6,a.getUsername());
			ps.setDouble(7,a.getBalance());
			ps.execute();
			return 1;
		}
		catch(Exception e)
		{		e.printStackTrace(); 	}
		return 0;
	}
	public int addSavingAccount(Saving_Account sac)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_webproject","root","Rkakani");
			PreparedStatement ps = conn.prepareStatement("insert into accountdetails values(?,?,?,?,aes_encrypt(?,?),?)");
		
			ps.execute();
			return 1;
		}
		catch(Exception e)
		{		e.printStackTrace(); 	}
		return 0;
	}	
	public int addCurrentAccount(Current_Account cac)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_webproject","root","Rkakani");
			PreparedStatement ps = conn.prepareStatement("insert into accountdetails values(?,?,?,?,aes_encrypt(?,?),?)");
		
			ps.execute();
			return 1;
		}
		catch(Exception e)
		{		e.printStackTrace(); 	}
		return 0;
	}	
	public boolean isMobileAvailable(String Mobile)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_webproject","root","Rkakani");
			PreparedStatement ps = conn.prepareStatement("select * from customerdetails where Mobile=?");
			ps.setString(1,Mobile);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return false;
			}
		}
		catch(Exception e)
		{		e.printStackTrace(); 	}
		return true;
	}
	public boolean isEmailAvailable(String Email)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_webproject","root","Rkakani");
			PreparedStatement ps = conn.prepareStatement("select * from customerdetails where Email=?");
			ps.setString(1,Email);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return false;
			}
		}
		catch(Exception e)
		{		e.printStackTrace(); 	}
		return true;
	}
	public boolean isAccountNoAvailable(long AccountNo)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_webproject","root","Rkakani");
			PreparedStatement ps = conn.prepareStatement("select * from accountdetails where AccountNo=?");
			ps.setLong(1,AccountNo);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
		}
		catch(Exception e)
		{		e.printStackTrace(); 	}
		return false;
	}	
	public boolean isUsernameAvailable(String Username)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_webproject","root","Rkakani");
			PreparedStatement ps = conn.prepareStatement("select * from accountdetails where Username=?");
			ps.setString(1,Username);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return false;
			}
		}
		catch(Exception e)
		{		e.printStackTrace(); 	}
		return true;
	}	
}
