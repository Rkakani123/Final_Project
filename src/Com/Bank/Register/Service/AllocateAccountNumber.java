package Com.Bank.Register.Service;
import java.util.function.Supplier;

public class AllocateAccountNumber 
{	
	public String AllocateAccount()
	{
		Supplier<String> s = ()->{
			String accountNumber = "";
			for(int i=0;i<7;i++)
			{
				accountNumber  = accountNumber  + (int)(Math.random()*10);
			}
			return accountNumber ;
		};		
		return s.get();
	}	
}
