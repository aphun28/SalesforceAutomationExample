package util.base;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import framework.util.PageFactory;
import pageobjects.framework.util.api.SalesforceLoginPage;

public class BaseTest {
	protected PageFactory pageFactory = new PageFactory();
	protected WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver","D:\\Desktop\\eclipse-workspace\\TestSalesforce\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MINUTES);
	}
	
	/**
	 * login into the salesforce org
	 * @param baseUrl
	 * @param username
	 * @param password
	 */
	public void login(String baseUrl, String username, String password) {
		driver.get(baseUrl);
		SalesforceLoginPage loginPage = pageFactory.getSalesforceLoginPage(driver);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
	}
	
	public void navigateToPage(String baseUrl) {
		driver.get(baseUrl);
	}
	
	/**
	 * clean up logic
	 */
	public void cleanUp() {
		driver.quit();
	}
}
