package Com.Bank.Register.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Bank.Register.Model.MST;

@WebServlet("/VerifyMobile")
public class VerifyMobile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		try
		{
			res.setContentType("text/html");
			String userenteredotp = req.getParameter("OtpValue");
		
			HttpSession session = req.getSession(true);
			MST mst = (MST)session.getAttribute("Mobile");
			String otp = mst.getOtp();
			
			PrintWriter pw = res.getWriter();
			pw.println("<script type=\"text/javascript\">");
			if(otp.contains(userenteredotp))
			{				
			    pw.println("alert('Mobile Verified Successfully..!');");
			    pw.println("window.location.href = \"Email.html\";");
			}
			else
			{
				pw.println("alert('Wrong OTP Entered.. Plz Try Again');");
				pw.println("window.location.href = \"Mobile.html\";");
			}
			
		    pw.println("</script>");	
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		doGet(req, res);
	}

}
