package ambiente;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	public static WebDriver driver;

	public static void travianConfig() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Desenvolvimento\\Ambiente Cucumber\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://ts5.lusobrasileiro.travian.com/");
	}
}
