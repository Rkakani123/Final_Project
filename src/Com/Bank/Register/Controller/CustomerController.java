package Com.Bank.Register.Controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Bank.Register.Database.DAORegister;
import Com.Bank.Register.Model.Account;
import Com.Bank.Register.Model.Customer;
import Com.Bank.Register.Model.MEST;
import Com.Bank.Register.Service.AllocateAccountNumber;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		try
		{
			res.setContentType("text/html");
			long account_No ;
					
			String customer_Name = req.getParameter("Customer_Name");
			String s1 = null;
			       s1 = req.getParameter("Street");
			String s2 = req.getParameter("Address");
			String address = s1.concat(" "+s2);			
			String customer_DOB = req.getParameter("Date_of_Birth");			
			
			HttpSession session = req.getSession(true);
			MEST mest = (MEST)session.getAttribute("MOBEmail");
			String mob = mest.getMobile();
			long mobile_No = (long)Long.parseLong(mob);
			String email_Id = mest.getEmail();
						
			String customer_UID = req.getParameter("Customer_UID");
			DAORegister dao = new DAORegister();
			do
			{
			AllocateAccountNumber AC = new AllocateAccountNumber();
			System.out.println(AC);
			account_No = (long)Long.parseLong(AC.AllocateAccount());
			}while(dao.isAccountNoAvailable(account_No));
			
			String account_Type = req.getParameter("Account_type");
			
			Customer c = new Customer(0, customer_Name, address, customer_DOB, mobile_No, email_Id, customer_UID);
			Account a = new Account(c, account_No, account_Type);
			
			session.setAttribute("Account",a);
			res.sendRedirect(a.getAccount_Type()+".html");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
	
	public Cookie getDesiredCookie(Cookie[] cookieset, String desiredCookie )
	{
		Cookie mycookie = null;
		for(int i=0;i<cookieset.length;i++)
		{
			if(cookieset[i].getName().equals(desiredCookie))
			{
				mycookie = cookieset[i];
			}
		}
		return mycookie;
	}

}
