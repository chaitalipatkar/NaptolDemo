package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import pojo.Browser;
import pom.NaptolHomePage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class ProductSearchTest extends BaseTest {
	
	@BeforeTest
	public void configureReporting() {
		reports = Reports.ConfigureReports();
	}

	@BeforeMethod
	public void openApplication() {
		driver = Browser.launchApplication();
	}

	@Test
	public void verifyIfuserabletoSearchProduct() {
		test = reports.createTest("verifyIfuserabletoSearchProduct");
		naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProducttoSearch("fruit juicer");
		naptolHomePage.clickonSearchButton();
		Assert.assertTrue(driver.getTitle().contains("fruit juicer"));
		Assert.assertTrue(naptolHomePage.getNumberOfProductDisplayed() > 0);
	}

	@Test
	public void verifyAfterclickonLoginPopupShouldDisplay() {
		test = reports.createTest("verifyAfterclickonLoginPopupShouldDisplay");
		naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.clickOnLoginOrRegister();
		Assert.assertTrue(naptolHomePage.popupIsDisplayed());

	}

	@Test
	public void verifyAfterclickonTrackOrderpageshouldBeREDIRECT() {
		test = reports.createTest("verifyAfterclickonTrackOrderpageshouldBeREDIRECT");
		naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.clickOnTrackOrder();
		Assert.assertTrue(naptolHomePage.trackorderPageisDisplayed());
	}

	@Test
	public void verifyShoppingCategoriesShouldDisplay() {
		test = reports.createTest("verifyShoppingCategoriesShouldDisplay");
		naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.viewShoppingCategories(driver);
		Assert.assertTrue(naptolHomePage.listItemDisplayed());

	}

	

	@AfterTest
	public void publishReport() {
		reports.flush();

	}

}

