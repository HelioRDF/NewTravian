package executar;

import org.junit.Assert;
import org.openqa.selenium.By;

import ambiente.SeleniumTest;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;

public class LoginTest {

	/**
	 * 
	 */

//	public static void main(String[] args) {
//		String login = "furioso";
//		String password = "Killer17";
//		Info.travianConfig();
//		Info.driver.findElement(By.name("name")).sendKeys(login);
//		Info.driver.findElement(By.name("password")).sendKeys(password);
//		Info.driver.findElement(By.name("s1")).click();
//
//	}
//	

	@Dado("Que estou na pagina de login")
	public void que_estou_na_pagina_de_login() {
		SeleniumTest.travianConfig();
	}

	@Dado("Digitei o usuario")
	public void digitei_o_usuario() {
		String login = "Doom";
		SeleniumTest.driver.findElement(By.name("name")).sendKeys(login);
	}

	@Dado("Digitei a senha")
	public void digitei_a_senha() {
		String password = "Killer17";
		SeleniumTest.driver.findElement(By.name("password")).sendKeys(password);
	}

	@Dado("Cliquei em entrar")
	public void cliquei_em_entrar() {
		SeleniumTest.driver.findElement(By.name("s1")).click();
	}

	@Dado("Rejeito termos")
	public void rejeito_termos() {
		SeleniumTest.driver.findElement(By.id("cmpbntnotxt")).click();

	}

	@Entao("Acesso a pagina Principal")
	public void acesso_a_pagina_principal() {
		String playerName = SeleniumTest.driver.findElement(By.className("playerName")).getText();
		Assert.assertEquals(playerName, "furioso");
	}

}
