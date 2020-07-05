package Com.Bank.Register.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
 
public class sendSMS 
{
	public String sendSms(String Phone, String OTP)
	{
		try 
		{
			// Construct data
			String apiKey = "apikey=" + "Lf7oIJL58V0-ay0KD7Omh7fFA93FuXuHx99j7f1Ajj";
			String message = "&message=" + "Your OTP For Registration Is - "+OTP;
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + "91"+Phone;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null)
			{
				stringBuffer.append(line);
			}
			rd.close();
			System.out.println("OTP Send..!");
			
			return stringBuffer.toString();
		} 
		catch (Exception e)
		{
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}