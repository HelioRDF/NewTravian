package executar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import ambiente.Selenium;
import entidade.AldeiaFarme;
import entidade.JogadorFarme;
import util.ExcelLer;
import util.ExcelSalvar;
import util.OrganizarListaPorDistancia;
import util.Tempo;

public class EstatisticasJogadores {

	private static ArrayList<AldeiaFarme> listaDeAldeias = new ArrayList<AldeiaFarme>();
	private static String urlPaginaParaVerificar;
	private static String tropasEnviadas = "2";

	public static void iniciarAnaliseAldeia(int paginas, int paginaInicial) {
		Login.executarLogin();
		// ultimaPaginaEstatisticas();
		PaginaEstatisticas(paginaInicial);
		paginasVerificadas(paginas);
		imprimirCamposNoConsole(listaDeAldeias);
	}

	public static void atacarFarmes(int quantidadeDeAldeias, String aldeia) {
		Login.executarLogin();
		Selenium.driver.get(aldeia);
		List<AldeiaFarme> listaFarmes = ExcelLer.lerDadosFarmes();
		int contador = 1;
		for (AldeiaFarme aldeiaFarme : listaFarmes) {
			Selenium.driver.get(aldeiaFarme.getLink());
			System.out.println(
					"\n------------------------------------------------------------------------------------------------------------------------");
			Tempo.aguardarEmSegundos(true, 2, "\n" + contador + " - Atacando: " + aldeiaFarme.getNomeAldeia()
					+ "\t Tropas: " + aldeiaFarme.getTropas());
			enviarTropasT1(aldeiaFarme.getTropas());
			if (contador > quantidadeDeAldeias) {
				break;
			}
			contador++;
			Tempo.aguardarEmSegundos(false, 2, "");
		}
		Selenium.driver.quit();
	}

	private static void enviarTropasT1(String tropas) {
		try {
			Selenium.driver.findElement(By.linkText("Enviar tropas")).click();
			Selenium.driver.findElement(By.xpath("//input[@name='troops[0][t1]']")).sendKeys(tropas);
			Selenium.driver.findElement(By.xpath("//input[@value='4']")).click();
			Selenium.driver.findElement(By.id("btn_ok")).click();
			String tempoAtk = Selenium.driver.findElement(By.className("in")).getText();
			System.out.println(tempoAtk);

			Selenium.driver.findElement(By.id("btn_ok")).click();
		} catch (NoSuchElementException e) {
			System.out.println("\n\nCom proteção de iniciante");
		}

	}

	private static void paginasVerificadas(int paginas) {
		for (int contador = 1; contador < paginas; contador++) {
			lerTabela();
			Selenium.driver.get(urlPaginaParaVerificar);
			voltarPagina();
		}
	}

//	private static void ultimaPaginaEstatisticas() {
//		Selenium.driver.get(Selenium.travianUrl + "/statistics");
//		WebElement elementoLast;
//		elementoLast = Selenium.driver.findElement(By.xpath("//a[@class='last']"));
//		urlPaginaParaVerificar = elementoLast.getAttribute("href");
//		elementoLast.click();
//	}

	private static void PaginaEstatisticas(int pagina) {
		urlPaginaParaVerificar = Selenium.travianUrl + "/statistics/player?page=" + pagina;
		Selenium.driver.get(urlPaginaParaVerificar);

	}

	private static void voltarPagina() {
		Tempo.aguardarEmSegundos(true, 5, "Voltar uma página");
		WebElement elementoPrevious = Selenium.driver.findElement(By.className("previous"));
		urlPaginaParaVerificar = elementoPrevious.getAttribute("href");
		elementoPrevious.click();
	}

	private static void lerTabela() {

		ArrayList<WebElement> tabela = (ArrayList<WebElement>) Selenium.driver.findElements(By.className("hover"));
		ArrayList<JogadorFarme> listaJogadorFarme = new ArrayList<JogadorFarme>();
		for (WebElement linha : tabela) {

			System.out.println("-------------------------------------------------------------------");
			String posicao = linha.findElement(By.className("ra")).getText();
			String jogador = linha.findElement(By.className("pla")).getText();
			WebElement elementoLink = linha.findElement(By.className("pla"));
			WebElement linkPlayer = elementoLink.findElement(By.tagName("a"));
			String alianca = linha.findElement(By.className("al")).getText();
			String populacao = linha.findElement(By.className("pop")).getText();
			String vilas = linha.findElement(By.className("vil")).getText();
			JogadorFarme jogadorFarme;
			jogadorFarme = new JogadorFarme(posicao, jogador, linkPlayer.getAttribute("href"), alianca, populacao,
					Integer.parseInt(vilas));
			listaJogadorFarme.add(jogadorFarme);
			System.out.println(jogadorFarme.toString());
		}
		for (JogadorFarme obj : listaJogadorFarme) {
			AldeiaFarme aldeiaAnalisada = analisarAldeias(obj);
			if (aldeiaAnalisada.getDistancia() < 55) {
				listaDeAldeias.add(aldeiaAnalisada);
			}
		}
	}

	private static AldeiaFarme analisarAldeias(JogadorFarme jogadorFarme) {
		Selenium.driver.get(jogadorFarme.getLink());
		WebElement tabela = Selenium.driver.findElement(By.xpath("//table[@id='villages']/tbody"));
		String nomeAldeia = tabela.findElement(By.className("name")).getText();
		String linkAldeia = tabela.findElement(By.className("name")).findElement(By.tagName("a")).getAttribute("href");
		String habitantes = tabela.findElement(By.className("inhabitants")).getText();
		Selenium.driver.get(linkAldeia);
		ArrayList<WebElement> colunaTbody = (ArrayList<WebElement>) Selenium.driver
				.findElements(By.xpath("//table[@id='village_info']/tbody/tr/td"));
		String distancia = colunaTbody.get(4).getText().replace(" Campos:", "");
		AldeiaFarme aldeiaFarme = new AldeiaFarme(nomeAldeia, jogadorFarme.getJogador(), linkAldeia, habitantes,
				Double.parseDouble(distancia), tropasEnviadas);
		return aldeiaFarme;
	}

	public static void imprimirCamposNoConsole(ArrayList<AldeiaFarme> aldeiaFarme) {
		Collections.sort(aldeiaFarme, new OrganizarListaPorDistancia());
		ExcelSalvar.salvarDadosFarmes(aldeiaFarme, "Farmes");
		System.out.println("\n ------------------------------------------\n");
		for (AldeiaFarme obj : aldeiaFarme) {
			System.out.println(obj.toString());
		}
		System.out.println("\n ------------------------------------------\n");
	}
}
