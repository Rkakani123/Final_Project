package Com.Bank.Register.Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Bank.Register.Model.Account;
import Com.Bank.Register.Model.Current_Account;
import Com.Bank.Register.Model.Saving_Account;


@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		try
		{
			res.setContentType("text/html");
			HttpSession session = req.getSession(true);
			Account a = (Account)session.getAttribute("Account");
			String AC_Type = a.getAccount_Type();
			
			if(AC_Type.equals("Saving"))
			{
				double minimum_Balance = (double)Double.parseDouble(req.getParameter("Minimum_Balance"));
				double daily_Limit = (double)Double.parseDouble(req.getParameter("Daily_Limit"));
				Saving_Account SAC = new Saving_Account(a, minimum_Balance, daily_Limit);
				session.setAttribute("Account",SAC);
			}
			
			if(AC_Type.equals("Current"))
			{
				String name_of_Company = req.getParameter("Name_of_Company");
				String date_of_Opening = req.getParameter("Date_of_Opening");
				int overDraft_Limit = (int)Integer.parseInt(req.getParameter("OverDraft_Limit"));
				Current_Account CAC = new Current_Account(a, name_of_Company, date_of_Opening, overDraft_Limit);
				session.setAttribute("Account",CAC);
			}
			
			res.sendRedirect("UserPass.html");
			
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

}
