package executar;

import ambiente.Selenium;
import entidade.Campo;
import java.util.ArrayList;
import java.util.Collections;
import org.openqa.selenium.By;
import util.OrganizarListaPorNivel;
import util.Tempo;

public class AnaliseCamposRecursosComLoop {

	boolean imprimir = false;

	public static ArrayList<Campo> criarListaCampos() {
		ArrayList<Campo> campos = new ArrayList<Campo>();
		for (int aldeiaId = 1; aldeiaId <= 18; aldeiaId++) {
			String urlCampo = Selenium.travianUrl + "build.php?id=" + aldeiaId;
			Selenium.driver.get(urlCampo);
			campos.add(capturarInformacoes(urlCampo, aldeiaId));
		}
		imprimirCamposNoConsole(campos);
		return campos;
	}

	private static Campo capturarInformacoes(String urlCampo, int aldeiaId) {
		String campo = Selenium.driver.findElement(By.className("titleInHeader")).getText();
		String nivelInt[] = Selenium.driver.findElement(By.className("level")).getText().split(" ", 2);
		int nivel = Integer.parseInt(nivelInt[1]);
		String tempoConstrucao = Selenium.driver.findElement(By.xpath("//div[@class='inlineIcon duration']/span"))
				.getText();
		String tempoConstrucaoParte[] = tempoConstrucao.split(":", 3);

		if (campo.contains("Campo de Cereais") || campo.contains("Cropland")) {
			nivel += 1;
		}
		Campo campoObj = new Campo(aldeiaId, nivel, urlCampo, campo, Long.parseLong(tempoConstrucaoParte[0]),
				Long.parseLong(tempoConstrucaoParte[1]));
		Tempo.aguardarEmSegundos(false, 3, "\n---------------> " + campoObj.getNomeCampo() + " <----------------");
		return campoObj;
	}

	public static void imprimirCamposNoConsole(ArrayList<Campo> campos) {
		Collections.sort(campos, new OrganizarListaPorNivel());
		System.out.println("\n ------------------------------------------\n");
		for (Campo campo : campos) {
			System.out.println(campo.toString());
		}
		System.out.println("\n ------------------------------------------\n");
	}
}