package executar;

import ambiente.Selenium;
import util.Tempo;

public class EnviarRecursos {

	public static void iniciarEnvio(String doadora, String recebedora, String mercado) {

		Selenium.pagina(doadora);
		Selenium.pagina(mercado);

		Selenium.webElement("//input[@id='r1']").sendKeys("1600");
		Selenium.webElement("//input[@id='r2']").sendKeys("1200");
		Selenium.webElement("//input[@id='r3']").sendKeys("1200");
		Selenium.webElement("//input[@id='r4']").sendKeys("500");
		Selenium.webElement("//div[@class='destination']//table//input[@id='enterVillageName']").sendKeys(recebedora);

		Selenium.webElement("//button[@id='enabledButton']").click();
		Selenium.webElement("//button[@id='enabledButton']").click();
		Tempo.aguardarEmSegundos(false, 30, "");

	}

}
