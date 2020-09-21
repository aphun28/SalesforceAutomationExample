package sanity.cases;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import framework.util.PropertyManager;
import pageobjects.framework.util.api.CaseRecordHomePage;
import util.base.BaseTest;

public class CaseTest extends BaseTest {
	String baseUrl; 
	String password; 
	String username; 
	String caseId = "5003t00001ANRVQAA5";
	
	@Before
	public void setup() throws Exception {
		baseUrl = PropertyManager.getInstance().getURL();
		password = PropertyManager.getInstance().getPassword();
		username = PropertyManager.getInstance().getUsername();
		login(baseUrl,username,password);
	}
	
	/**
	 * Validate that case fields are populated
	 */
	@Test
	public void testCaseFieldsIsDisplayed() {
		String expectedCasenumber = "";
		CaseRecordHomePage casePage = pageFactory.getCaseRecordHomePage(driver);
		assertNotNull("Case subject line should have a value",casePage.getSubjectLine());
		assertNotNull("Case number line should have a value",casePage.getCasenumber());
		assertNotNull("Case status line should have a value",casePage.getStatus());
		assertEquals(expectedCasenumber,casePage.getCasenumber());
	}
	
	@After
	public void tearDown() {
		cleanUp();
	}
}
