package executar;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import ambiente.Selenium;
import entidade.Campo;
import util.MensagenConsole;
import util.Tempo;

public class MelhorarCamposV2 {

	public static void recurso(String aldeia) {
		Selenium.pagina(aldeia);
		ArrayList<Campo> campos = AnaliseCamposRecursos.criarListaCampos();
		if (disponivelParaMelhorar()) {
			Campo campo = campos.get(0);
			LocalTime horaAtual = LocalTime.now();
			MensagenConsole.info("\tAldeia pronta, ID: " + campo.getId() + " Hora: " + horaAtual);
			Selenium.pagina(campo.getLink());
			confirmarMelhoria(campo.getNivel());
		}
	}

	public static void estrutura(String aldeia, String estrutura, int nivelMax) {
		Selenium.pagina(aldeia);
		if (disponivelParaMelhorar()) {
			LocalTime horaAtual = LocalTime.now();
			Selenium.pagina(estrutura);
			String nivelTexto = Selenium.webElement("//h1/span").getText();
			String separadorNivel[] = nivelTexto.split(" ", 2);
			int nivel = Integer.parseInt(separadorNivel[1].trim());
			if (nivel < nivelMax) {
				MensagenConsole.info("\tAldeia pronta, ID: " + estrutura + " Hora: " + horaAtual);
				System.out.println("xxxxxxxx: " + nivel);
				confirmarMelhoria(nivel);
			} else {
				MensagenConsole.info("Estrutura Atingiu o nível programado, Nvl= " + nivel);
			}

		}
	}

	private static boolean disponivelParaMelhorar() {
		List<WebElement> h5 = Selenium.listaWebElement("//h5");
		boolean disponivel = true;
		if (h5.size() > 0) {
			WebElement tempoMelhoria = Selenium.webElement("//div[@class='buildDuration']/span");
			MensagenConsole.info("Melhoria em andamento: " + tempoMelhoria.getText());
		} else {
			//Ativar validação fora do campo
			//disponivel = true;
		}
		return disponivel;
	}

	private static void confirmarMelhoria(int nivel) {
		WebElement botaoConfirmarMelhoria = null;
		WebElement botaoConfirmarMelhoriaRapido = null;
		try {
			botaoConfirmarMelhoria = Selenium.driver.findElement(By.xpath("//div[@class='section1']/button"));
			botaoConfirmarMelhoriaRapido = Selenium.driver.findElement(By.xpath("//div[@class='section2']/button"));
		} catch (NoSuchElementException e) {
			botaoConfirmarMelhoriaRapido = botaoConfirmarMelhoria;
		}
		if (botaoConfirmarMelhoria.getText().contains("Construindo")
				|| botaoConfirmarMelhoria.getText().contains("Construct")) {
			Tempo.aguardarEmSegundos(true, 5, "Ops -> Melhoria indisponível");
		} else {
			if (nivel >= 7 & botaoConfirmarMelhoriaRapido.getText().contains("mais rápido")
					|| botaoConfirmarMelhoriaRapido.getText().contains("faster")) {
				MensagenConsole.info("Melhoria rápida, Nvl: " + nivel);
				botaoConfirmarMelhoriaRapido.click();
			} else {
				botaoConfirmarMelhoria.click();
				MensagenConsole.info("Melhoria Normal, Nvl: " + nivel);
			}
		}
		Tempo.aguardarEmMinutos(false, 2, null);
	}
}
