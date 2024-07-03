package test;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.AddtocartPage;
import pom.NaptolHomePage;
import pom.Proceedtocheckout;
import pom.ProductResultPage;
import pom.ShippingAddress;
import utility.Reports;

@Listeners(test.Listeners.class)
public class Checkout extends BaseTest {
	@BeforeTest
	public void configureReporting() {
		reports = Reports.ConfigureReports();
	}

	@BeforeMethod
	public void openApplication() {
		driver = Browser.launchApplication();
	}

	@Test
	public void verifyProceedToCheckout() throws InterruptedException, EncryptedDocumentException, IOException {
		test = reports.createTest("verifyProceedToCheckout");
		naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProducttoSearch("cooker");
		naptolHomePage.clickonSearchButton();

		productResultPage = new ProductResultPage(driver);
		productResultPage.moveToDesiredProduct(driver, 0);
		productResultPage.clickOnQuickView(0);

		addtoCart = new AddtocartPage(driver);
		addtoCart.clickHeretoBuy();
		proceedToCheckout = new Proceedtocheckout(driver);
		proceedToCheckout.clickonProceedtoCheckOut();
		proceedToCheckout.enterMobileNumber("8055486002");
		proceedToCheckout.clickonContinueButton();
		proceedToCheckout.enterOtp("");
		Thread.sleep(20000);
		proceedToCheckout.clickonSubmitButtonAfterOtp();
		ShippingAddress shippingaddress = new ShippingAddress(driver);
		shippingaddress.selectTitle();
		shippingaddress.enterFirstName();
		shippingaddress.enterLastName();
		shippingaddress.enterAddress();
		shippingaddress.enterLandMark();
		shippingaddress.enterPincode();
		shippingaddress.selectState();
		shippingaddress.selectCity();
		shippingaddress.enterMobileNoinShippingAddrees();
		shippingaddress.enterLandLine();
		shippingaddress.clickOnShipptothisAddress();

	}

	

	@AfterTest
	public void publishReport() {
		reports.flush();

	}


}
