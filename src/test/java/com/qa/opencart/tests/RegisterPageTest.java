package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ExcelUtil;
import com.qa.opencart.base.BaseTest;

public class RegisterPageTest extends BaseTest {

	@BeforeClass
	public void regSetup() {
		regPage = loginPage.navigateToRegisterPage();
	}
	
	
	public String getRandomEmailId() {
		Random random = new Random();
		String email = "anuautomation"+random.nextInt(1000)+"@gmail.com";
		return email;
	}
	

	@DataProvider
	public Object[][] getRegisterTestData() {
		Object regData[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return regData;
	}

	@Test(dataProvider = "getRegisterTestData")
	public void userRegisterTest(String firstname, String lastname, String email,
			 String telephone, String password,
			String subscribe) {

		Assert.assertTrue(regPage.userRegister(firstname, lastname, 
				getRandomEmailId(), telephone, password, subscribe));

	}
	
	

}