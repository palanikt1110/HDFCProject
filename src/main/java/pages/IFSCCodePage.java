package pages;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.HdfcWrappers;

public class IFSCCodePage extends HdfcWrappers{

	public IFSCCodePage(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		if(!verifyTitle("IFSC Code Look Up")){
			reportStep("This is not IFSC Page", "FAIL");
		}
	}
	public IFSCCodePage enterIfsccode(String data)
	{
		pageLoadTime();
		enterById("IdfldCodIFSC", data);
		return this;
	}
	public IFSCCodePage clickSearch()
	{
		driver.findElementByLinkText("Search").click();
		return this;
	}
	public HomePage clickToAcceptIFSCCode()
	{
List<WebElement> wbifsc=driver.findElementsByXPath("//table[@class='datatable']//tr");
		
		for(int i=1;i<wbifsc.size();i++)
		{
			WebElement r=driver.findElementByXPath("//table[@class='datatable']//tr["+i+"]//following::td[6]/a");
			System.out.println(r.getText());
			r.click();
		}
		switchToParentWindow();
		findByXpathFrame("//frame[@name='main_part']");
		return new HomePage(driver,test);
	}
}
