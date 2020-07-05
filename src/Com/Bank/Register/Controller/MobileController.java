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
import Com.Bank.Register.Model.MST;
import Com.Bank.Register.Service.OTP_Generation;
import Com.Bank.Register.Service.sendSMS;

@WebServlet("/MobileController")
public class MobileController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		try
		{
			res.setContentType("text/html");
			DAORegister dao = new DAORegister();
						
			String phone=req.getParameter("MobileNumber");
			if(dao.isMobileAvailable(phone))
			{
				String otp= new OTP_Generation().GenerateOTP(4);
				System.out.println(otp);
				MST mst = new MST(phone, otp);
				//sendSMS s = new sendSMS();
				//s.sendSms(phone,otp);	
			
				HttpSession session = req.getSession(true); 
				session.setAttribute("Mobile",mst);
				res.sendRedirect("Mobile.html");
			}
			else
			{
				PrintWriter pw = res.getWriter();
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Mobile Already Exists...!');");
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
