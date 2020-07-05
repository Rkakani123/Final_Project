package Com.Bank.Register.Controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Bank.Register.Database.DAORegister;
import Com.Bank.Register.Model.Account;
import Com.Bank.Register.Model.Customer;

@WebServlet("/FinalAccountController")
public class FinalAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		try
		{
			res.setContentType("text/html");
			
			String username = req.getParameter("Username");
			String password = req.getParameter("Password");
			
			DAORegister dao = new DAORegister();
			if(dao.isUsernameAvailable(username))
			{
				HttpSession session = req.getSession(true);
				Account a = (Account) session.getAttribute("Account");
				a.setUsername(username);
				a.setPassword(password);
				
				a.setBalance(25000);
				Customer c = new Customer(0, a.getCustomer_Name(), a.getAddress(), a.getCustomer_DOB(), a.getMobile_No(), a.getEmail_Id(), a.getCustomer_UID());
				dao.addCustomer(c);
				a.setCustomer_Id(dao.getCustomerId(a.getMobile_No()));
				dao.addAccount(a);		
						
				/*if(a.getAccount_Type().equals("Saving"))
				{	
					Saving_Account SAC = (Saving_Account)a;
				}
				if(a.getAccount_Type().equals("Current"))
				{
					Current_Account CAC = (Current_Account)a;
				}*/
			}
			else
			{
				PrintWriter pw = res.getWriter();
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Username Already Exists...! Try Again..!');");
				pw.println("window.location.href = \"Mobile.html\";");
				pw.println("</script>");	
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
