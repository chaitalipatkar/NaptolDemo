package pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.Parametrization;

public class ShippingAddress {
	@FindBy  (xpath="//select[@name='fktitle_id']")private WebElement titLe;
	@FindBy  (xpath="//input[@id='firstName']")private WebElement firstname;
	@FindBy  (xpath="//input[@id='lastName']")private WebElement lastname;
	@FindBy  (xpath="//textarea[@id='address']")private WebElement address;
	@FindBy  (xpath="//input[@name='landmark']")private WebElement landmark;
	@FindBy  (xpath="//input[@id='pincode']")private WebElement pincode;
	@FindBy  (xpath="//select[@id='state']")private WebElement state;
	@FindBy  (xpath="//select[@id='city']")private WebElement city;
	@FindBy  (xpath="//input[@id='mobile']")private WebElement mobileNumberInAddress;
	@FindBy  (xpath="//input[@id='landline']")private WebElement landLine;
	@FindBy  (xpath="//a[@class='button_2']")private WebElement shipToThisAddress;

	
	public ShippingAddress(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void selectTitle() {
		Select select = new Select(titLe);
		select.selectByIndex(3);
	}

	public void enterFirstName() throws EncryptedDocumentException, IOException {
		String Name = Parametrization.getTestData(1, 0, "UserDetail");
		firstname.sendKeys(Name);
	}

	public void enterLastName() throws EncryptedDocumentException, IOException {
		String Lastname = Parametrization.getTestData(1, 1, "UserDetail");
		lastname.sendKeys(Lastname);
	}

	public void enterAddress() throws EncryptedDocumentException, IOException {
		String add = Parametrization.getTestData(1, 3, "UserDetail");
		address.sendKeys(add);
	}

	public void enterLandMark() throws EncryptedDocumentException, IOException {
		String mark = Parametrization.getTestData(1, 5, "UserDetail");
		landmark.sendKeys(mark);
	}

	public void enterPincode() throws EncryptedDocumentException, IOException {
		String pin = Parametrization.getTestData(1, 4, "UserDetail");
		pincode.sendKeys(pin);
	}

	public void selectState() {
		state.click();
		Select select = new Select(state);
		select.selectByVisibleText("MAHARASHTRA");
	}

	public void selectCity() {
		city.click();
		Select select = new Select(city);
		select.selectByVisibleText("Thane");
	}

	public void enterMobileNoinShippingAddrees() throws EncryptedDocumentException, IOException {
		String mobileNumber = Parametrization.getTestData(1, 2, "UserDetail");
		mobileNumberInAddress.sendKeys(mobileNumber);
	}

	public void enterLandLine() throws EncryptedDocumentException, IOException {
		String landline = Parametrization.getTestData(1, 6, "UserDetail");
		landLine.sendKeys(landline);
	}

	public void clickOnShipptothisAddress() {
		shipToThisAddress.click();

	}


}
