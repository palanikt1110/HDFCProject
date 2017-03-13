package testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.VeryFirstPage;
import wrappers.HdfcWrappers;

public class TestCase2 extends HdfcWrappers{
	@BeforeClass
	public void setData() {
		testCaseName="Homepage";
		testDescription="Evaluating the Bene Name and Adding Beneficiary Details";
		browserName="chrome";
		dataSheetName="TC001";
		category="Smoke";
		
	}
	@Test(dataProvider="fetchData")
	public void entercustomerID(String userName,String Password,String Accbalance,String accno,String repeatno,String typeofacc,String ifsccode,String benename,String beneemail){

		new VeryFirstPage(driver,test)
		.enterUserId(userName)
		.clickContinue()
		.enterPassword(Password)
		.clickCheckBoxoption()
		.clickLoginContinue()
		.goToFundsTransfer()
		.clickEnquire()
		.clickViewBeneficiary()
		.clickRTGS()
		.listAndVerifyBeneficiary()
		.clickRequset()
		.clickAddBeneficary()
		.clickRTGS()
		.enterAccountNo(accno)
		.enterAccountduplicate(repeatno)
		.selectAccountType(typeofacc)
		.clickToSearchforIFSCCode()
		.enterIfsccode(ifsccode)
		.clickSearch()
		.clickToAcceptIFSCCode()
		.enterBeneficiaryName(benename)
		.enterEmailid(beneemail);
		
		
	}


}
