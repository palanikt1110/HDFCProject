package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.HdfcWrappers;

public class LoginPage extends HdfcWrappers{

	public LoginPage(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
	
		if(!verifyTitle("Welcome to HDFC Bank NetBanking")){
			reportStep("This is not HDFC NetBanking Page", "FAIL");
		}
	}
	
	public LoginPage enterPassword(String data)
	{
		enterByXpath("(//input[@class='input_password'])[2]", data);
		return this;
	}
	public LoginPage clickCheckBoxoption()
	{
		clickById("chkrsastu");
		return this;
	}
	
	public HomePage clickLoginContinue()
	{
		clickByXpath("//*[@alt='Login']");
		return new HomePage(driver,test);
	}
}
