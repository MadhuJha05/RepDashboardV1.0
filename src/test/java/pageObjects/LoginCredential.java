package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;


public class LoginCredential extends BasePage{

	public LoginCredential(WebDriver driver)
	{
		super(driver); //this will call BasePage constructor
	}
	

	
	@FindBy(xpath="//input[@id='Email']")
			WebElement txtUserEmail;
	
	@FindBy(xpath="//button[normalize-space()='Next']")
	 WebElement btnNext;
	
	@FindBy(xpath="//input[@id='__BVID__37']")
	public WebElement txtUserpassword;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement btnLogin;
	
	@FindBy(xpath="//input[@aria-label='OTP digit 1']")
	public WebElement otpDigit1;
	
	@FindBy(xpath="//input[@aria-label='OTP digit 2']")
	WebElement otpDigit2;
	
	@FindBy(xpath="//input[@aria-label='OTP digit 3']")
	WebElement otpDigit3;
	
	@FindBy(xpath="//input[@aria-label='OTP digit 4']")
	WebElement otpDigit4;
	
	@FindBy(xpath="//input[@aria-label='OTP digit 5']")
	WebElement otpDigit5;
	
	@FindBy(xpath="//input[@aria-label='OTP digit 6']")
	WebElement otpDigit6;
	
	public void setUserEmail(String email)
	{
		txtUserEmail.sendKeys(email);	
	}
	
	public void clickNext()
	{
		btnNext.click();
	}
	
	public void setUserPassword(String pwd)
	{
		txtUserpassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public void setOtpDigit1(String otp1)
	{
		otpDigit1.sendKeys(otp1);
	}
	
	public void setOtpDigit2(String otp2)
	{
		otpDigit2.sendKeys(otp2);
	}
	public void setOtpDigit3(String otp3)
	{
		otpDigit3.sendKeys(otp3);
	}
	public void setOtpDigit4(String otp4)
	{
		otpDigit4.sendKeys(otp4);
	}
	public void setOtpDigit5(String otp5)
	{
		otpDigit5.sendKeys(otp5);
	}
	public void setOtpDigit6(String otp6)
	{
		otpDigit6.sendKeys(otp6);
	}
	
	
	
	
	
}
