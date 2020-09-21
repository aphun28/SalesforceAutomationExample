package pageobjects.framework.util.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.framework.util.api.CaseRecordHomePage;

public class CaseRecordHomePageImpl extends CaseRecordHomePage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	String tabXpath = "//*[contains(@text, '%s)]";
	
	@FindBy(css = ".windowViewMode-maximized.active.lafPageHost")
	private WebElement defaultElement;
	
	@FindBy(xpath = "//div[@class='slds-align-middle fade-text']")
	private WebElement subjectLine;
	
	@FindBy(xpath = "//span[contains(@class,'is-read-only')]//span[contains(@class,'uiOutputText')]")
	private WebElement caseNumber;
	
	@FindBy(xpath = "//span[contains(@class,'test-id__field-value slds-form-element__static slds-grow')]")
	private WebElement status;
	
	public CaseRecordHomePageImpl(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(defaultElement));
	}
		
	@Override
	public String getSubjectLine() {
		wait.until(ExpectedConditions.visibilityOf(subjectLine));
		return subjectLine.getText();
	}
	
	@Override
	public String getCasenumber() {
		wait.until(ExpectedConditions.visibilityOf(caseNumber));
		return caseNumber.getText();
	}
	
	@Override
	public String getStatus() {
		wait.until(ExpectedConditions.visibilityOf(status));
		return status.getText();
	}
	
}
