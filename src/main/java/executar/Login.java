package executar;

import org.openqa.selenium.By;

import ambiente.Selenium;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import util.MensagenConsole;
import util.Tempo;

public class Login {

	public static void executarLogin() {
		que_estou_na_pagina_de_login();
		digitei_o_usuario();
		digitei_a_senha();
		Tempo.aguardarEmSegundos(false, 3, null);
		cliquei_em_entrar();
		rejeito_termos();
		acesso_a_pagina_principal();
	}

	@Dado("Que estou na pagina de login")
	private static void que_estou_na_pagina_de_login() {
		Selenium.travianConfig();
		Tempo.aguardarEmSegundos(false, 4, null);
		rejeito_termos();

	}

	@Dado("Digitei o usuario")
	private static void digitei_o_usuario() {
		String login = "Furioso";
		Selenium.driver.findElement(By.name("name")).sendKeys(login);
	}

	@Dado("Digitei a senha")
	private static void digitei_a_senha() {
		String password = "Killer17";
		Selenium.driver.findElement(By.name("password")).sendKeys(password);
	}

	@Dado("Cliquei em entrar")
	private static void cliquei_em_entrar() {
		Selenium.driver.findElement(By.name("s1")).click();
	}

	@Dado("Rejeito termos")
	private static void rejeito_termos() {
		try {
			Selenium.driver.findElement(By.id("cmpbntnotxt")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Entao("Acesso a pagina Principal")
	private static void acesso_a_pagina_principal() {
		String playerName = Selenium.driver.findElement(By.className("playerName")).getText();
		MensagenConsole.info("Login executado: " + playerName);
		Tempo.aguardarEmSegundos(false, 3, playerName);
	}
}
