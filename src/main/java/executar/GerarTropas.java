package executar;

import org.openqa.selenium.By;

import ambiente.Selenium;
import util.Tempo;

public class GerarTropas {

	public static void loopParaCriarTropas(String totalTropas, String linkQuartel, String aldeia) {

		Selenium.driver.get(aldeia);
		Tempo.aguardarEmSegundos(false, 5, aldeia);
		Selenium.driver.get(linkQuartel);
		criarTropasT2T4(totalTropas);

	}

	private static void criarTropasT1(String totalTropas) {
		Selenium.driver.findElement(By.xpath("//input[@name='t1']")).sendKeys(totalTropas);
		Selenium.driver.findElement(By.id("s1")).click();

	}

	private static void criarTropasT2(String totalTropas) {
		Selenium.driver.findElement(By.xpath("//input[@name='t2']")).sendKeys(totalTropas);
		Selenium.driver.findElement(By.id("s1")).click();

	}

	private static void criarTropasT1T2(String totalTropas) {
		Selenium.driver.findElement(By.xpath("//input[@name='t1']")).sendKeys(totalTropas);
		Selenium.driver.findElement(By.xpath("//input[@name='t2']")).sendKeys(totalTropas);
		Selenium.driver.findElement(By.id("s1")).click();

	}

	private static void criarTropasT2T4(String totalTropas) {
		Selenium.driver.findElement(By.xpath("//input[@name='t2']")).sendKeys(totalTropas);
		Selenium.driver.findElement(By.xpath("//input[@name='t4']")).sendKeys(totalTropas);
		Selenium.driver.findElement(By.id("s1")).click();
		Tempo.aguardarEmSegundos(false, 30, "");

	}

}
