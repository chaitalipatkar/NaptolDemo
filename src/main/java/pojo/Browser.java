package pojo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	public static WebDriver launchApplication() {
WebDriverManager.chromedriver().setup();
WebDriver driver =  new ChromeDriver();
driver.get("https://www.naaptol.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
return driver;
}
	//public static void main(String[] args) {  // this 2 lines of code to open the Naaptol Homepage
	//	Browser.launchApplication();
	}

	

