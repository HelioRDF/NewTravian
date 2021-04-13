package executar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ambiente.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import entidade.Campo;
import util.ExcelSalvar;
import util.OrganizarListaPorNivel;

public class AnaliseCamposRecursos {

	boolean imprimir = false;

	public static ArrayList<Campo> criarListaCampos() {
		List<WebElement> links = Selenium.driver.findElements(By.xpath("//div[@id='resourceFieldContainer']/a[@class!='villageCenter']"));
		ArrayList<Campo> campos = new ArrayList<Campo>();
		for (WebElement webElement : links) {
			String link = webElement.getAttribute("href");
			String testarNvl = webElement.getText();
			int nivel = 0;
			if (testarNvl.length()>0) {
				nivel = Integer.parseInt(webElement.getText());
			}
			int id = retornaId(link);
			Campo campo = new Campo(id, nivel, link, "N/A", 0, 0);
			campos.add(campo);
		}
		Collections.sort(campos, new OrganizarListaPorNivel());
		//ExcelSalvar.salvarDadosCampos(campos);
		for (Campo campo : campos) {
			System.out.println("\t| Nivel: " + campo.getNivel() + "\t| Tempo:" + campo.retornaTempoTotalEmMinutos()
					+ "\t|" + campo.getLink());
		}
		return campos;
	}

	public static int retornaId(String link) {
		String partesLink[] = link.split("=", 2);
		return Integer.parseInt(partesLink[1]);
	}
}