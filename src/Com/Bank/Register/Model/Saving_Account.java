package Com.Bank.Register.Model;
import java.util.Date;

public class Saving_Account extends Account 
{
	final float interest_Rate = 8;
	private double minimum_Balance;
	private double daily_Limit;
	
	public Saving_Account(Account a, double minimum_Balance, double daily_Limit)
	{
		super(a);
		this.minimum_Balance = minimum_Balance;
		this.daily_Limit = daily_Limit;
	}

	public float getInterest_Rate() {
		return interest_Rate;
	}

	public double getMinimum_Balance() {
		return minimum_Balance;
	}

	public void setMinimum_Balance(double minimum_Balance) {
		this.minimum_Balance = minimum_Balance;
	}

}
