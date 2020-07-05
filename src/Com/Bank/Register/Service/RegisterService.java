package Com.Bank.Register.Service;
import java.util.List;

import Com.Bank.Register.Model.Account;
import Com.Bank.Register.Model.Current_Account;
import Com.Bank.Register.Model.Customer;
import Com.Bank.Register.Model.Saving_Account;

public interface RegisterService
{
	public int addCustomer(Customer c);
	public List<Customer> getAllCustomer();
	public void deleteCustomer(int CustomerId);
	public Customer getCustomer(int CustomerId);
		
	public int addAccount(Account a);
	/*public List<Account> getAllAccount();
	public void deleteAccount(int CustomerId);
	public Customer getAccount(int CustomerId);
	public Customer updateAccount(Customer c);*/
	
	public int addSavingAccount(Saving_Account sac);
	/*public List<Saving_Account> getAllSavingAccount();
	public void deleteSavingAccount(int CustomerId);
	public Customer getSaving_Account(int CustomerId);
	public Customer updateSaving_Account(Saving_Account sac);*/
	
	public int addCurrentAccount(Current_Account cac);
	/*public List<Current_Account> getAllCurrentAccount();
	public void deleteCurrentAccount(int CustomerId);
	public Customer getCurrentAccount(int CustomerId);
	public Customer updateCurrentAccount(Current_Account cac);*/

	public boolean isMobileAvailable(String Mobile);
	public boolean isEmailAvailable(String Email);
	public boolean isUsernameAvailable(String Username);
	public boolean isAccountNoAvailable(long AcNo);
	
}
