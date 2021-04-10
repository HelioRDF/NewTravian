package executar;

import org.openqa.selenium.By;

import ambiente.SeleniumTest;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;

public class AnaliseCamposTest {
	String url = "https://ts5.lusobrasileiro.travian.com/build.php?id=";

	boolean imprimir = false;

	@Dado("loguei na conta")
	public void loguei_na_conta() {
		System.out.println("----------------------Inicio-----------------------");
	}

	@Dado("cliquei no campo {int}")
	public void cliquei_no_campo(Integer aldeia) {
		SeleniumTest.driver.get(url + aldeia);
		System.out.println("link: " + url + aldeia);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (aldeia == 3) {
			imprimir = true;
		}
	}

	@Entao("valido")
	public void valido() {
		String campo = SeleniumTest.driver.findElement(By.className("titleInHeader")).getText();
		String nivel = SeleniumTest.driver.findElement(By.className("level")).getText();
		String tempoConstrucao= SeleniumTest.driver.findElement(By.className("urlCampo")).getText();
		String botaoConfirmarMelhoria = SeleniumTest.driver.findElement(By.xpath("//button[@class='section1']/button")).getText();

		System.out.println("--" + campo + "---" + nivel);
		System.out.println("Tempo" + tempoConstrucao );
		System.out.println("Botao" + botaoConfirmarMelhoria );
		System.out.println("-----------------------------");

	}
}
