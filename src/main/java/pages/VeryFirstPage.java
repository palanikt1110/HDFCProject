package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.HdfcWrappers;

public class VeryFirstPage extends HdfcWrappers{

	public VeryFirstPage(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
	
		if(!verifyTitle("Welcome to HDFC Bank NetBanking")){
			reportStep("This is not HDFC NetBanking Page", "FAIL");
		}
	}
	public VeryFirstPage enterUserId(String data){
		firstFrame(0);
		enterByName("fldLoginUserId", data);
		return this;
	}
	public LoginPage clickContinue(){
		clickByXpath("//img[@alt='continue']");
		return new LoginPage(driver,test);
	}
}
