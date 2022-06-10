package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.democart.utils.Constants;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.AccountsPage;


public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void loginPageUrlTest() {
		String actualUrl = loginPage.getLoginPageURL();
		Assert.assertTrue(actualUrl.contains(Constants.LOGIN_PAGE_URL_FRACTION));
	}

	@Test(priority = 3)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@Test(priority = 4)
	public void registerLinkExistTest() {
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}

	@Test(priority = 5)
	public void loginTest() {
		AccountsPage accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		String accPageTitle = accPage.getAccPageTitle();
		System.out.println(accPageTitle);
		Assert.assertEquals(accPageTitle, Constants.ACCOUNTS_PAGE_TITLE);
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}

}
