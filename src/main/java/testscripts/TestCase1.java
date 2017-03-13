package testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.VeryFirstPage;
import pages.LoginPage;
import wrappers.HdfcWrappers;

public class TestCase1 extends HdfcWrappers {

	@BeforeClass
	public void setData() {
		testCaseName="VeryFirstpage";
		testDescription="Enter Customer ID";
		browserName="chrome";
		dataSheetName="TC001";
		category="Smoke";
		
	}

	@Test(dataProvider="fetchData")
	public void entercustomerID(String userName,String Password,String Accbalance,String accno,String repeatno,String acctype,String ifsccode,String benename,String beneEmail){

		new VeryFirstPage(driver,test)
		.enterUserId(userName)
		.clickContinue()
		.enterPassword(Password)
		.clickCheckBoxoption()
		.clickLoginContinue()
		.validatingtheaccountBalance(Accbalance);
	}

}
