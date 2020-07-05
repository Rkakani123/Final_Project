package Com.Bank.Register.Model;
import java.util.Date;

public class Current_Account extends Account 
{
	private String name_of_Company;
	private String date_of_Opening;
	private int overDraft_Limit;
	
	public Current_Account(Account a, String name_of_Company, String date_of_Opening, int overDraft_Limit) 
	{
		super(a);
		this.name_of_Company = name_of_Company;
		this.date_of_Opening = date_of_Opening;
		this.overDraft_Limit = overDraft_Limit;
	}

	public String getName_of_Company() {
		return name_of_Company;
	}

	public void setName_of_Company(String name_of_Company) {
		this.name_of_Company = name_of_Company;
	}

	public String getDate_of_Opening() {
		return date_of_Opening;
	}

	public void setDate_of_Opening(String date_of_Opening) {
		this.date_of_Opening = date_of_Opening;
	}

	public int getOverDraft_Limit() {
		return overDraft_Limit;
	}

	public void setOverDraft_Limit(int overDraft_Limit) {
		this.overDraft_Limit = overDraft_Limit;
	}	
}
