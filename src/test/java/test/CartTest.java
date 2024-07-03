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
import pom.AddtocartPage;
import pom.NaptolHomePage;
import pom.ProductResultPage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class CartTest extends BaseTest {

	@BeforeTest
	public void configureReporting() {
		reports = Reports.ConfigureReports();
	}

	@BeforeMethod
	public void openApplication() {
		driver = Browser.launchApplication();
	}

	@Test
	public void verifyAddTocartByAddingProductfromQickView() {
		test = reports.createTest("verifyAddTocartByAddingProductfromQickView");
		naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProducttoSearch("fruit juicer");
		naptolHomePage.clickonSearchButton();

		productResultPage = new ProductResultPage(driver); 
		productResultPage.moveToDesiredProduct(driver, 0);
		productResultPage.clickOnQuickView(0);

		addtoCart = new AddtocartPage(driver);
		addtoCart.clickHeretoBuy();
		addtoCart.clcikonContinueShopping();
		naptolHomePage.clearProduct();

		naptolHomePage.enterProducttoSearch("cooker");
		naptolHomePage.clickonSearchButton();

		productResultPage.moveToDesiredProduct(driver, 0);
		productResultPage.clickOnQuickView(0);
		addtoCart.clickHeretoBuy();
		String ExpectedName = addtoCart.getProductName(0);
		double ExpectedPrice = addtoCart.getProductPrice(1);
		double ExpectedShippingPrice = addtoCart.getProductShippingPrice(1);
		System.out.println(ExpectedName + " " + ExpectedPrice + " " + ExpectedShippingPrice);

		Assert.assertEquals(addtoCart.getNumberofProductsInCart(), 2);
		Assert.assertEquals(addtoCart.getProductName(0), ExpectedName);
		Assert.assertEquals(addtoCart.getProductPrice(1), ExpectedPrice);
		Assert.assertEquals(addtoCart.getProductShippingPrice(1), ExpectedShippingPrice);
	}

	@Test
	public void verifyAddTocartByAddingMultipleProduct() {
		test = reports.createTest("verifyAddTocartByAddingMultipleProduct");
		naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProducttoSearch("fruit juicer");
		naptolHomePage.clickonSearchButton();

		productResultPage = new ProductResultPage(driver);
		productResultPage.selectDesiredProduct(0);

		switchToChildBrowser();

		addtoCart = new AddtocartPage(driver);
		addtoCart.clickHeretoBuy();
		addtoCart.clcikonContinueShopping();

		naptolHomePage.enterProducttoSearch("cooker");
		naptolHomePage.clickonSearchButton();
		productResultPage = new ProductResultPage(driver);
		productResultPage.selectDesiredProduct(0);
		switchToChildBrowser();

		addtoCart.clickHeretoBuy();
		String ExpectedName = addtoCart.getProductName(1);
		double ExpectedPrice = addtoCart.getProductPrice(2);
		double ExpectedShippingPrice = addtoCart.getProductShippingPrice(2);
		System.out.println(ExpectedName + " " + ExpectedPrice + " " + ExpectedShippingPrice);

		Assert.assertEquals(addtoCart.getNumberofProductsInCart(), 2);
		Assert.assertEquals(addtoCart.getProductName(1), ExpectedName);
		Assert.assertEquals(addtoCart.getProductPrice(2), ExpectedPrice);
		Assert.assertEquals(addtoCart.getProductShippingPrice(2), ExpectedShippingPrice);
	}

	@Test
	public void verifyRemoveFunctionalityFromCart() throws InterruptedException {
		test = reports.createTest("verifyRemoveFunctionalityFromCart");
		naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProducttoSearch("fruit juicer");
		naptolHomePage.clickonSearchButton();
		productResultPage = new ProductResultPage(driver);
		productResultPage.moveToDesiredProduct(driver, 0);
		productResultPage.clickOnQuickView(0);

		AddtocartPage addtocart = new AddtocartPage(driver);
		addtocart.clickHeretoBuy();

		addtocart.removeProductFromCart();

		Thread.sleep(2000);
		Assert.assertEquals(addtocart.getNumberofProductsInCart(), 0);

	}

	@Test
	public void verifyOrderAmount() {
		test = reports.createTest("verifyOrderAmount");
		naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProducttoSearch("fruit juicer");
		naptolHomePage.clickonSearchButton();

		productResultPage = new ProductResultPage(driver);
		productResultPage.selectDesiredProduct(0);

		switchToChildBrowser();

		addtoCart = new AddtocartPage(driver);
		addtoCart.clickHeretoBuy();
		Assert.assertEquals(addtoCart.getProductOrderAmount(1),
				(addtoCart.getProductPrice(1) + addtoCart.getProductShippingPrice(1)));
	}

	@AfterMethod
	public void addReportStatus(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
		} else {
			test.log(Status.SKIP, result.getName());
		}
	}

	@AfterTest
	public void publishReport() {
		reports.flush();

	}

}


