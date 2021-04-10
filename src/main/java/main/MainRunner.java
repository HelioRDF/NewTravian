package main;

import ambiente.Selenium;
import executar.EstatisticasJogadores;
import executar.GerarTropas;
import executar.MelhorarCampos;
import util.Tempo;

public class MainRunner {
	static String aldeia01 = "https://ts100.x10.international.travian.com/dorf1.php?newdid=22116&";
	static String aldeia02 = "https://ts100.x10.international.travian.com/dorf1.php?newdid=30354&";
	static String aldeia03 = "https://ts100.x10.international.travian.com/dorf1.php?newdid=32635&";

	public static void main(String[] args) {
		 melhorarConstrucao();
	}

	private static void melhorarConstrucao() {
		String estrutura = "https://ts100.x10.international.travian.com/build.php?id=31&gid=26";
		MelhorarCampos.iniciarMelhoriaConstrucao(8, aldeia03, estrutura);

	}

	private static void melhoriaRecursos() {

		try {
			MelhorarCampos.cicloMelhoriaRecursos(12, 0, 1, aldeia03);
		} catch (Exception e) {
			Selenium.fecharSessao();
			Tempo.aguardarEmMinutos(false, 10, aldeia03);
			melhoriaRecursos();
		}
	}

	private static void atacarFarmes() {
		EstatisticasJogadores.atacarFarmes(50, aldeia01);
	}

	private static void statisticas() {
		int paginas = 30;
		int paginaInicial = 250;
		EstatisticasJogadores.iniciarAnaliseAldeia(paginas, paginaInicial);
	}

	private static void criarTropas(String aldeia) {
		String quartel = "https://ts100.x10.international.travian.com/build.php?id=30&gid=19";
		String tropas = "20";
		int intervaloMinutos = 10;
		int repetir = 200;
		GerarTropas.loopParaCriarTropas(tropas, quartel, intervaloMinutos, repetir, aldeia);
	}
}