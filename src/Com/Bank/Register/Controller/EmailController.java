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
import Com.Bank.Register.Model.MEST;
import Com.Bank.Register.Model.MST;
import Com.Bank.Register.Service.OTP_Generation;
import Com.Bank.Register.Service.SendMsgOnMail;

@WebServlet("/EmailController")
public class EmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
    	try
    	{
    		res.setContentType("text/html");			
			String email = req.getParameter("EmailAddress");	
			DAORegister dao = new DAORegister();
			if(dao.isEmailAvailable(email))
			{
				String otp= new OTP_Generation().GenerateOTP(6);
				System.out.println(otp);
			
				HttpSession session = req.getSession(true);
				MST mst = (MST)session.getAttribute("Mobile");
				String mobile = mst.getMobile();
				MEST mest = new MEST(mobile, email, otp);		
			
				//SendMsgOnMail s = new SendMsgOnMail();
				//s.sendMail(mail,otp);
						
				session.setAttribute("MOBEmail", mest);		
				res.sendRedirect("Email.html");
			}
			else
			{
				PrintWriter pw = res.getWriter();
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Email Already Exists...!Try With Different EmailId');");
				pw.println("window.location.href = \"Mobile.html\";");
				pw.println("</script>");	
			}
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
