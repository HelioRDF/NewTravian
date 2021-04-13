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
	static String aldeia04 = "https://ts100.x10.international.travian.com/dorf1.php?newdid=34823&";

	public static void main(String[] args) {
		melhoriaRecursos();
	}

	private static void melhorarConstrucao() {
		String estrutura = "https://ts100.x10.international.travian.com/build.php?id=21&gid=11";
		MelhorarCampos.iniciarMelhoriaConstrucao(8, aldeia04, estrutura);

	}

	private static void melhoriaRecursos() {

		try {
			MelhorarCampos.cicloMelhoriaRecursos(12, 0, 1, aldeia04);
		} catch (Exception e) {
			Selenium.fecharSessao();
			Tempo.aguardarEmMinutos(false, 10, aldeia04);
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
		GerarTropas.loopParaCriarTropas(tropas, quartel,  aldeia);
	}
}