package ambiente;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import util.Tempo;

public class CapturaTela {

	public static void screenshot(String nomeArquivo) {
		Tempo.aguardarEmSegundos(false, 6, nomeArquivo);
		File file = ((TakesScreenshot) Selenium.driver).getScreenshotAs(OutputType.FILE);
		String local = "target/screenshot/" + nomeArquivo + ".jpg";
		try {
			FileUtils.copyFile(file, new File(local));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
