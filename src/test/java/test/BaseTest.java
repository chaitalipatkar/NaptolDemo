package test;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import pom.AddtocartPage;
import pom.NaptolHomePage;
import pom.Proceedtocheckout;
import pom.ProductResultPage;

public class BaseTest {
	public static WebDriver driver;
	public NaptolHomePage naptolHomePage;
	public ProductResultPage productResultPage;
	public AddtocartPage addtoCart;
	public Proceedtocheckout proceedToCheckout;
	public ExtentReports reports;
	public ExtentTest test;
	public void switchToChildBrowser() {

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> i = handles.iterator();

		while (i.hasNext()) {
			driver.switchTo().window(i.next());

		}

	}


}
