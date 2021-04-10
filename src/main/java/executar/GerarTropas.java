package executar;

import java.util.Iterator;

import org.openqa.selenium.By;

import ambiente.Selenium;
import util.Tempo;

public class GerarTropas {

	public static void loopParaCriarTropas(String totalTropas, String linkQuartel, long intervaloMinutos, int repetir,String aldeia) {

		for (int i = 1; i < repetir; i++) {
			Login.executarLogin();
			Selenium.driver.get(aldeia);
			Tempo.aguardarEmSegundos(false, 5, aldeia);
			Selenium.driver.get(linkQuartel);
			criarTropasT1T2(totalTropas, intervaloMinutos);
		}
	}

	private static void criarTropasT1(String totalTropas, long intervaloMinutos) {
		Selenium.driver.findElement(By.xpath("//input[@name='t1']")).sendKeys(totalTropas);
		Selenium.driver.findElement(By.id("s1")).click();
		Selenium.driver.quit();
		Tempo.aguardarEmMinutos(true, intervaloMinutos, "aguardando para criar tropas t1");
		
	
	}
	
	private static void criarTropasT2(String totalTropas, long intervaloMinutos) {
		Selenium.driver.findElement(By.xpath("//input[@name='t2']")).sendKeys(totalTropas);
		Selenium.driver.findElement(By.id("s1")).click();
		Selenium.driver.quit();
		Tempo.aguardarEmMinutos(true, intervaloMinutos, "aguardando para criar tropas t1");
		
	
	}
	
	private static void criarTropasT1T2(String totalTropas, long intervaloMinutos) {
		Selenium.driver.findElement(By.xpath("//input[@name='t1']")).sendKeys(totalTropas);
		Selenium.driver.findElement(By.xpath("//input[@name='t2']")).sendKeys(totalTropas);
		Selenium.driver.findElement(By.id("s1")).click();
		Selenium.driver.quit();
		Tempo.aguardarEmMinutos(true, intervaloMinutos, "aguardando para criar tropas t1");
		
	
	}
	
	
	

}
