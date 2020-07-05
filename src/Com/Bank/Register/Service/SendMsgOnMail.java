package Com.Bank.Register.Service;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMsgOnMail
{
	public void sendMail(String Recepient, String Otp)
	{
		try
		{
			Properties properties = new Properties();
			
			properties.put("mail.smtp.auth","true");
			properties.put("mail.smtp.starttls.enable","true");
			properties.put("mail.smtp.host","smtp.gmail.com");
			properties.put("mail.smtp.port","587");
			
			String Mymail ="rkakani123@gmail.com";
			String Mypass ="Rkakani@1999";
			
			Session session = Session.getInstance(properties, new Authenticator() 
			{
					protected PasswordAuthentication getPasswordAuthentication()
					{	return new PasswordAuthentication(Mymail, Mypass); }
			});
			
			Message msg = prepareOTPMessage(session,Mymail,Recepient,Otp);
			Transport.send(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private Message prepareOTPMessage(Session session, String mymail, String recepient, String otp) 
	{
		try
		{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mymail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("OTP For Registration");
			message.setText(otp+" - Your OTP For Registration");
			return message;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
