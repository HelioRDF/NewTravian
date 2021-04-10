package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelEditar {

	private static final String fileName = "D:\\Desenvolvimento\\travian\\aldeia02";

//	public static void main(String[] args) throws IOException {
//		
//	}

    //Exemplo
	public void editarDadosExcel() {
		try {
			FileInputStream file = new FileInputStream(new File(ExcelEditar.fileName));

			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheetAldeia = workbook.getSheetAt(0);

			for (int i = 0; i < sheetAldeia.getPhysicalNumberOfRows(); i++) {

				Row row = sheetAldeia.getRow(i);
				Cell cellNota1 = row.getCell(2);
				if (cellNota1.getNumericCellValue() < 9) {
					cellNota1.setCellValue(cellNota1.getNumericCellValue() + 1);
				} else {
					cellNota1.setCellValue(10);
				}

				Cell cellNota2 = row.getCell(3);
				Cell cellMedia = row.getCell(4);
				cellMedia.setCellValue((cellNota1.getNumericCellValue() + cellNota2.getNumericCellValue()) / 2);
				Cell cellAprovado = row.getCell(5);
				cellAprovado.setCellValue(cellMedia.getNumericCellValue() >= 6);
			}
			file.close();

			FileOutputStream outFile = new FileOutputStream(new File(ExcelEditar.fileName));
			workbook.write(outFile);
			outFile.close();
			workbook.close();
			System.out.println("Arquivo Excel editado com sucesso!");

		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo Excel não encontrado!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na edição do arquivo!");
		}
	}

	public boolean compararDados(String texto, String comparar) {
		boolean info = false;
		if (texto.trim().equalsIgnoreCase(comparar) || texto.equalsIgnoreCase("")) {
			info = true;
		}
		return info;
	}
}
