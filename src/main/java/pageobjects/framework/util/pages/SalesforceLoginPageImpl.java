package pageobjects.framework.util.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.framework.util.api.SalesforceLoginPage;

public class SalesforceLoginPageImpl extends SalesforceLoginPage{
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(id = "username")
	private WebElement userNameTextField;
	
	@FindBy(id = "password")
	private WebElement passwordTextField;
	
	@FindBy(id = "Login")
	private WebElement loginButton;
	
	public SalesforceLoginPageImpl(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 30);
	}
	
	@Override
	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(passwordTextField));
		passwordTextField.click();
		passwordTextField.sendKeys(password);
	}
	
	@Override
	public void enterUserName(String userName) {
		wait.until(ExpectedConditions.visibilityOf(userNameTextField));
		userNameTextField.click();
		userNameTextField.sendKeys(userName);
	}
	
	@Override
	public void clickLoginButton() {
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		loginButton.click();
	}
}
