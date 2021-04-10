package executar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ambiente.Selenium;
import util.Tempo;

public class Treinar {

	public static void treinarColonizador() {
		String urlResidencia = "https://ts5.lusobrasileiro.travian.com/build.php?id=33&gid=25";
		Login.executarLogin();
		Selenium.driver.get(urlResidencia);
		Tempo.aguardarEmSegundos(false, 5, "");
		WebElement colonizador = Selenium.driver.findElement(By.xpath("//input[@name='t10']"));
		colonizador.sendKeys("1");
		WebElement submeter = Selenium.driver.findElement(By.id("s1"));
		Tempo.aguardarEmSegundos(false, 5, "");
		submeter.click();

	}

	public static void treinarPretoriano() {
		String urlResidencia = "https://ts5.lusobrasileiro.travian.com/build.php?id=33&gid=25";
		Login.executarLogin();
		Selenium.driver.get(urlResidencia);
		Tempo.aguardarEmSegundos(false, 5, "");

		WebElement colonizador = Selenium.driver.findElement(By.xpath("//input[@name='t10']"));
		colonizador.sendKeys("1");

		WebElement submeter = Selenium.driver.findElement(By.id("s1"));
		Tempo.aguardarEmSegundos(false, 5, "");
		submeter.click();

	}

}
