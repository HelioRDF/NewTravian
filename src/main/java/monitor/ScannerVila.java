package monitor;

import executar.GerarTropas;
import executar.MelhorarCamposV2;

public class ScannerVila {

	public static void iniciarScan() {
		String vila01 = "https://ts100.x10.international.travian.com/dorf1.php?newdid=22116&";
		String vila02 = "https://ts100.x10.international.travian.com/dorf1.php?newdid=30354&";
		String vila03 = "https://ts100.x10.international.travian.com/dorf1.php?newdid=32635&";
		String vila04 = "https://ts100.x10.international.travian.com/dorf1.php?newdid=34823&";
		String vila05 = "	https://ts100.x10.international.travian.com/dorf1.php?newdid=36987&";

		
		GerarTropas.loopParaCriarTropas("25", "https://ts100.x10.international.travian.com/build.php?id=30&gid=19", vila02);
		MelhorarCamposV2.recurso(vila01);
		MelhorarCamposV2.recurso(vila03);
		MelhorarCamposV2.recurso(vila04);
		MelhorarCamposV2.recurso(vila05);

	}

}
