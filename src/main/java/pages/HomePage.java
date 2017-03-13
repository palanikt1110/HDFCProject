package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

import junit.framework.Assert;
import wrappers.HdfcWrappers;

public class HomePage extends HdfcWrappers{

	public HomePage(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
	
		if(!verifyTitle("Welcome to HDFC Bank NetBanking")){
			reportStep("This is not HDFC NetBanking Page", "FAIL");
		}
	}
	public HomePage validatingtheaccountBalance(String data){
		
		findByXpathFrame("//frame[@name='main_part']");
		String actual=getTextByXpath("//span[contains(text(),'Total')]");
		System.out.println(actual.replaceAll("\\D",""));
		Assert.assertEquals("Amount Verified", data, actual.replaceAll("\\D",""));
		return this;
	}
	public HomePage goToFundsTransfer()
	{
		findByXpathFrame("//frame[@name='common_menu1']");
		clickByXpath("//img[@alt='Funds Transfer']");
		switchDefaultConten();
		return this;
	}
	public HomePage clickEnquire()
	{
		findByXpathFrame("//frame[@name='left_menu']");
		clickByXpath("//strong[text()='Enquire']");
		return this;
	}
	public HomePage clickViewBeneficiary()
	{
		clickByXpath("//span[contains(text(),'View/Delete List of Beneficiaries')]");
		switchDefaultConten();
		return this;
	}
	public HomePage clickRTGS()
	{
		findByXpathFrame("//frame[@name='main_part']");
		clickByXpath("(//img[@alt='Go'])[2]");
		return this;
	}
	public HomePage listAndVerifyBeneficiary()
	{
		List<WebElement> wb=driver.findElementsByXPath("//table[@class='datatable']//tr");
		List<String> whj=new ArrayList<String>();
		for(int i=1;i<=wb.size();i++)
		{
			WebElement r=driver.findElementByXPath("//table[@class='datatable']//tr["+i+"]//following::td[5]");
			System.out.println(r.getText());
			whj.add(r.getText());
			
		}
		
			if(whj.contains("Palaniappan".toUpperCase()))
					{
				System.out.println("String is present");
					}
			else
			{
				System.out.println("string is not present");
			}
		switchDefaultConten();
		return this;
	}
	public HomePage clickRequset()
	{
		findByXpathFrame("//frame[@name='left_menu']");
		clickByXpath("//strong[text()='Request']");
		return this;
	}
	public HomePage clickAddBeneficary()
	{
		clickByXpath("//span[contains(text(),'Add a Beneficiary')]");
		switchDefaultConten();
		return this;
	}
	public HomePage enterAccountNo(String data)
	{
		enterByName("fldAcctNo",data);
		return this;
	}
	public HomePage enterAccountduplicate(String data)
	{
		enterByName("fldAcctNo2",data);
		return this;
	}
	public HomePage selectAccountType(String data)
	{
		selectVisibileTextByTagName(data);
		return this;
	}
	public IFSCCodePage clickToSearchforIFSCCode()
	{
		clickByLinkWithout("Click here");
		switchToLastWindow();
		return new IFSCCodePage(driver,test);
	}
	public HomePage enterBeneficiaryName(String data)
	{
		enterByName("fldNamBenef",data);
		return this;
	}
	public HomePage enterEmailid(String data)
	{
		enterByName("fldEmail",data);
		return this;
	}
}
