package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtocartPage extends BasePage{
	@FindBy(xpath = "//ul[@id='cartData']")private List<WebElement> products;
	@FindBy(xpath = "//a[@title='Buy online']")private WebElement clickToBuy;
	@FindBy(xpath = "(//a[@class='link_Continue'])[2]")private WebElement clcikOnContinueShopping;
	@FindBy(xpath = "//div[@class='cart_info']//h2")private List<WebElement> productNameCart;
	@FindBy (xpath="//li[@class='head_UPrice']")private List<WebElement> productPrice;
	@FindBy(xpath = "//li[@class='head_ship']")private List<WebElement> productShippingPrice;
	@FindBy(xpath = "//a[text()='Remove']")private WebElement remove;
	@FindBy(xpath = "(//span[@class='font-bold'])[3]")private WebElement noProductInCart;
	@FindBy(xpath = "//li[@class='head_Amount']")private List<WebElement> orderAmount;

	public AddtocartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public int getNumberofProductsInCart() {
		return products.size();
	}

	public void clickHeretoBuy() {
		clickToBuy.click();
	}

	public void clcikonContinueShopping() {
		clcikOnContinueShopping.click();
	}

	public String getProductName(int index) {
		return productNameCart.get(index).getText();
	}

	public double getProductPrice(int index) {
		return Double.parseDouble(removeCommaFromString(productPrice.get(index).getText().substring(3)));
	}

	public double getProductShippingPrice(int index) {
		return Double.parseDouble(removeCommaFromString(productShippingPrice.get(index).getText().substring(3)));
	}

	public double getProductOrderAmount(int index) {
		return Double.parseDouble(removeCommaFromString(orderAmount.get(index).getText()));
	}

	public void removeProductFromCart() {
		remove.click();
	}

	public boolean noProduct() {
		return noProductInCart.isDisplayed();
	}

}
	

