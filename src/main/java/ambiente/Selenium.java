package ambiente;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
	public static WebDriver driver;
	// public static String travianUrl = "https://tx3.travian.com/";
	// public static String travianUrl = "https://ts4.travian.com/";
	public static String travianUrl = "https://ts100.x10.international.travian.com/";
	// public static String travianUrl =
	// "https://my.jive.com/domain/05a7d5ed-a6ec-423c-bbb5-675ea582e427/user/a46b4814-3612-4132-8218-adda64115a3c/main";

	public static void travianConfig() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().window().setPosition(new Point(200, 200));
		// driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get(travianUrl);
	}
	
	public static void fecharSessao() {
		driver.quit();
	}

}
