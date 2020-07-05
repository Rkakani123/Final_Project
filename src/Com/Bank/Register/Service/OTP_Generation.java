package Com.Bank.Register.Service;
import java.util.function.Supplier;

public class OTP_Generation 
{	
	public String GenerateOTP(int n)
	{
		Supplier<String> s = ()->{
			String OTP = "";
			String symbol_List = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890@$#";
			Supplier<Character> c = ()-> symbol_List.charAt((int)(Math.random()*symbol_List.length()));
			
			for(int i=0;i<n;i++)
			{
				OTP = OTP + c.get();
			}
			return OTP;
		};		
		return s.get();
	}	

}
