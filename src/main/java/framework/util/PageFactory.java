package framework.util;

import org.openqa.selenium.WebDriver;

import pageobjects.framework.util.api.CaseRecordHomePage;
import pageobjects.framework.util.api.SalesforceLoginPage;
import pageobjects.framework.util.pages.CaseRecordHomePageImpl;
import pageobjects.framework.util.pages.SalesforceLoginPageImpl;


public class PageFactory {
	public SalesforceLoginPage getSalesforceLoginPage(WebDriver driver) {
		return new SalesforceLoginPageImpl(driver);
	}

	public CaseRecordHomePage getCaseRecordHomePage(WebDriver driver) {
		return new CaseRecordHomePageImpl(driver);
	}
}
