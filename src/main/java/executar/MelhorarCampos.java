package executar;

import java.time.LocalTime;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import ambiente.CapturaTela;
import ambiente.Selenium;
import entidade.Campo;
import util.Tempo;

public class MelhorarCampos {
	static long tempoTotal;
	static long intevaloMelhorias;

	public static void cicloMelhoriaRecursos(int repetir, long tempo, long intervalo, String aldeia) {
		intevaloMelhorias = intervalo;
		Tempo.aguardarEmMinutos(true, tempo, "Aguardando para iniciar");
		Login.executarLogin();
		Selenium.driver.get(aldeia);
		CapturaTela.screenshot("Aldeia Inicial");
		int loop = 1;
		while (loop <= repetir) {

			ArrayList<Campo> campos = AnaliseCamposRecursos.criarListaCampos();
			System.out.println("----------------> Iniciando Loop " + loop + " <----------------");
			iniciarMelhoriaRecursos(campos, aldeia);
			loop++;
			Tempo.aguardarEmMinutos(true, 1, "\n\n\n----> Aguardando novo ciclo <----\n\n\n");
		}
		Selenium.driver.quit();

	}

	private static void iniciarMelhoriaRecursos(ArrayList<Campo> campos, String aldeia) {
		int contador = 1;
		for (Campo campo : campos) {
			
			Tempo.aguardarEmSegundos(false, 5, aldeia);
			Selenium.driver.get(aldeia);
			confirmarMelhoria(campo, contador);
			if (contador == 6) {
				break;
			}
			Tempo.aguardarEmMinutos(true, intevaloMelhorias, "Intervalo entre melhorias");
		}
	}

	public static void iniciarMelhoriaConstrucao(int repetir, String aldeia, String link) {
		Login.executarLogin();

		for (int num = 0; num <= repetir; num++) {
			Selenium.driver.get(aldeia);
			Tempo.aguardarEmSegundos(false, 55, "\nZzZZzzz");
			Selenium.driver.get(link);
			Tempo.aguardarEmSegundos(false, 15, "\nZzZZzzz");
			System.out.println("\n <--------------------Inicio Ciclo: " + num + "------------------------> ");
			String tempoConstrucao = Selenium.driver.findElement(By.xpath("//div[@class='inlineIcon duration']/span"))
					.getText();
			String tempoConstrucaoParte[] = tempoConstrucao.split(":", 3);
			Campo campoObj = new Campo(1, 1, link, "", Long.parseLong(tempoConstrucaoParte[0]),
					Long.parseLong(tempoConstrucaoParte[1]));
			confirmarMelhoria(campoObj, num);

		}
		Selenium.driver.quit();
	}

	public static void confirmarMelhoria(Campo campo, int contador) {
		LocalTime horaAtual = LocalTime.now();

		Selenium.driver.get(campo.getLink());
		String tempoConstrucao = Selenium.driver.findElement(By.xpath("//div[@class='inlineIcon duration']/span"))
				.getText();
		String tempoConstrucaoParte[] = tempoConstrucao.split(":", 3);
		campo.setTempoMelhoriaHora(Long.parseLong(tempoConstrucaoParte[0]));
		campo.setTempoMelhoriaMinuto(Long.parseLong(tempoConstrucaoParte[1]));
		tempoTotal = campo.retornaTempoTotalEmMinutos();
		System.out.println("\n  ------------> Analisando construção " + campo.getNomeCampo() + " - Loop:" + contador
				+ " <-----------------------");

		System.out.println("Tempo Comun: " + tempoTotal);
		if (validarDisponibilidade()) {
			System.out.println("Tempo Aplicado: " + tempoTotal);
			Tempo.aguardarEmMinutos(true, tempoTotal,
					"\nHora Inicial: " + horaAtual + "\nHora Final: " + horaAtual.plusMinutes(tempoTotal));
		}
		contador++;
	}

	private static boolean validarDisponibilidade() {
		boolean confirmado = false;
		WebElement botaoConfirmarMelhoria = null;
		WebElement botaoConfirmarMelhoriaRapido = null;
		try {
			botaoConfirmarMelhoria = Selenium.driver.findElement(By.xpath("//div[@class='section1']/button"));
			botaoConfirmarMelhoriaRapido = Selenium.driver.findElement(By.xpath("//div[@class='section2']/button"));
		} catch (NoSuchElementException e) {
			botaoConfirmarMelhoriaRapido = botaoConfirmarMelhoria;
		}
		System.out.println("--> " + botaoConfirmarMelhoria.getText());
		System.out.println("--> " + botaoConfirmarMelhoriaRapido.getText());
		if (botaoConfirmarMelhoria.getText().contains("Construindo")
				|| botaoConfirmarMelhoria.getText().contains("Construct")) {
			Tempo.aguardarEmMinutos(true, 5, "\n\n Ops -> Melhoria indisponível");
		} else {
			System.out.println("\n\n---- Texto--------" + botaoConfirmarMelhoriaRapido.getText());
			if (botaoConfirmarMelhoriaRapido.getText().contains("mais rápido")
					|| botaoConfirmarMelhoriaRapido.getText().contains("faster")) {
				tempoTotal = (tempoTotal / 4) * 3;
			}
			botaoConfirmarMelhoriaRapido.click();
			confirmado = true;
			System.out.println("\n - Uauu -> Melhoria confirmada!");
		}
		return confirmado;

	}
}
