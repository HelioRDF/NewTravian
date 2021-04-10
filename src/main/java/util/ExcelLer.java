package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entidade.AldeiaFarme;
import entidade.Campo;

public class ExcelLer {

	private static final String fileName = "C:\\travian\\";

	public static void lerDadosCampos() {
		List<Campo> listaCampos = new ArrayList<Campo>();
		try {
			FileInputStream arquivo = new FileInputStream(new File(ExcelLer.fileName + "Campos.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
			XSSFSheet sheetcampos = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheetcampos.iterator();
			DataFormatter formatter = new DataFormatter();
			String info = "";

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<org.apache.poi.ss.usermodel.Cell> cellIterator = row.cellIterator();

				Campo campo = new Campo();
				listaCampos.add(campo);
				while (cellIterator.hasNext()) {
					Cell cell = (Cell) cellIterator.next();
					switch (((org.apache.poi.ss.usermodel.Cell) cell).getColumnIndex()) {
					case 0:
						String retornoId = formatter.formatCellValue(cell);
						info = "|\t" + retornoId + "\t-\t";
						if (!compararDados(retornoId, "id")) {
							int id = Integer.parseInt(retornoId);
							campo.setId(id);
						}
						break;
					case 1:
						String retornoNvl = formatter.formatCellValue(cell);
						info = info + retornoNvl + "\t-\t";
						if (!compararDados(retornoNvl, "nivel")) {
							int nvl = Integer.parseInt(retornoNvl);
							campo.setNivel(nvl);
						}
						break;

					case 2:
						String link = ((org.apache.poi.ss.usermodel.Cell) cell).getStringCellValue();
						info = info + link + "\t-\t";
						if (!compararDados(link, "link")) {
							campo.setLink(link);
						}
						break;

					case 3:
						String nomeCampo = ((org.apache.poi.ss.usermodel.Cell) cell).getStringCellValue();
						info = info + nomeCampo + "\t-\t";
						if (!compararDados(nomeCampo, "nome aldeia")) {
							campo.setNomeCampo(nomeCampo);
						}
						break;
					case 4:
						String tempoMinuto = formatter.formatCellValue(cell);
						info = info + tempoMinuto + "\t-\t";
						if (!compararDados(tempoMinuto, "tempoMinutos")) {
							campo.setTempoMelhoriaMinuto(Long.parseLong(tempoMinuto));
						}
						break;

					case 5:
						String tempoHora = formatter.formatCellValue(cell);
						if (!compararDados(tempoHora, "tempoHoras")) {
							campo.setTempoMelhoriaHora(Long.parseLong(tempoHora));
							info = info + "\t" + tempoHora + "\t\t-|";
						} else {
							info = info + tempoHora + "\t-|";
						}
						break;
					}
				}
				System.out.println(info);
			}
			arquivo.close();
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo Excel não encontrado!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean compararDados(String texto, String comparar) {
		boolean info = false;
		if (texto.trim().equalsIgnoreCase(comparar) || texto.equalsIgnoreCase("")) {
			info = true;
		}
		return info;
	}

	public static List<AldeiaFarme> lerDadosFarmes() {
		List<AldeiaFarme> listaAldeiaFarme = new ArrayList<AldeiaFarme>();
		try {
			FileInputStream arquivo = new FileInputStream(new File(fileName + "Farmes.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
			XSSFSheet sheetFarmes = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheetFarmes.iterator();
			DataFormatter formatter = new DataFormatter();

			String info = "";

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<org.apache.poi.ss.usermodel.Cell> cellIterator = row.cellIterator();
				AldeiaFarme aldeiaFarme = new AldeiaFarme();

				while (cellIterator.hasNext()) {
					Cell cell = (Cell) cellIterator.next();
					switch (((org.apache.poi.ss.usermodel.Cell) cell).getColumnIndex()) {
					case 0:
						String retornoNomeAldeia = formatter.formatCellValue(cell);
						if (!compararDados(retornoNomeAldeia, "NomeAldeia")) {
							aldeiaFarme.setNomeAldeia(retornoNomeAldeia);
						}
						break;
					case 1:
						String retornoJogador = formatter.formatCellValue(cell);
						if (!compararDados(retornoJogador, "Jogador")) {
							aldeiaFarme.setJogador(retornoJogador);
						}
						break;

					case 2:
						String link = ((org.apache.poi.ss.usermodel.Cell) cell).getStringCellValue();
						info = info + link + "\t-\t";
						if (!compararDados(link, "Link")) {
							aldeiaFarme.setLink(link);
						}
						break;

					case 3:
						String nomeHabitantes = ((org.apache.poi.ss.usermodel.Cell) cell).getStringCellValue();
						if (!compararDados(nomeHabitantes, "Habitantes")) {
							aldeiaFarme.setHabitantes(nomeHabitantes);
						}
						break;
					case 4:
						String Distancia = formatter.formatCellValue(cell);

						if (!compararDados(Distancia, "Distancia")) {
							aldeiaFarme.setDistancia(Double.parseDouble(Distancia.replace(",", ".")));
						}
						break;
					case 5:
						String tropas = formatter.formatCellValue(cell);
						if (!compararDados(tropas, "tropas")) {
							aldeiaFarme.setTropas(tropas);
						}
						break;
					}

				}
				if (aldeiaFarme.getNomeAldeia() != null) {
					listaAldeiaFarme.add(aldeiaFarme);
					System.out.println(aldeiaFarme.toString());
				}

			}
			
			//listaAldeiaFarme.toString();
			arquivo.close();
			workbook.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo Excel não encontrado!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaAldeiaFarme;
	}
}
