package Com.Bank.Register.Model;

public class MEST
{
	private String mobile;
	private String email;
	private String otp;
	
	public MEST(String mobile, String email, String otp)
	{
		this.mobile = mobile;
		this.email = email;
		this.otp = otp;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public String getOtp() {
		return otp;
	}
	
	
	
	
}
