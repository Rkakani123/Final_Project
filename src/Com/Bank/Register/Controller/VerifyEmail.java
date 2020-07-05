package Com.Bank.Register.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Com.Bank.Register.Model.MEST;


@WebServlet("/VerifyEmail")
public class VerifyEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		try
		{
			res.setContentType("text/html");
			String userenteredotp = req.getParameter("OtpValue");
			
			HttpSession session = req.getSession(true);
			MEST mest = (MEST)session.getAttribute("MOBEmail");
			String otp = mest.getOtp();
			
			PrintWriter pw = res.getWriter();
			pw.println("<script type=\"text/javascript\">");
			if(otp.equals(userenteredotp))
			{				
			    pw.println("alert('Email Verified Successfully..!');");
			    pw.println("window.location.href = \"Register.html\";");
			}
			else
			{
				pw.println("alert('Wrong OTP Entered.. Plz Try Again');");
				pw.println("window.location.href = \"Email.html\";");
			}
			
		    pw.println("</script>");	
		    
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
