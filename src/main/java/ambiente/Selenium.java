package ambiente;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import util.Tempo;

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
		driver.manage().window().setSize(new Dimension(1700, 990));
		driver.get(travianUrl);
	}

	public static void pagina(String url) {
		driver.get(url);
		Tempo.aguardarEmSegundos(false, 5, "Abrindo página" + url );
	}

	public static List<WebElement> listaWebElement(String xpath) {
		return (List<WebElement>) driver.findElements(By.xpath(xpath));
	}

	public static WebElement webElement(String xpath) {
		Tempo.aguardarEmSegundos(false, 3, xpath);
		return driver.findElement(By.xpath(xpath));
	}

	public static void fecharSessao() {
		driver.quit();
	}

}
