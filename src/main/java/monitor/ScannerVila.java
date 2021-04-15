package monitor;

import executar.EnviarRecursos;
import executar.GerarTropas;
import executar.MelhorarCamposV2;

public class ScannerVila {

	public static void iniciarScan() {
		String vila01 = "https://ts100.x10.international.travian.com/dorf1.php?newdid=22116&";
//		String vila02 = "https://ts100.x10.international.travian.com/dorf1.php?newdid=30354&";
//		String vila03 = "https://ts100.x10.international.travian.com/dorf1.php?newdid=32635&";
//		String vila04 = "https://ts100.x10.international.travian.com/dorf1.php?newdid=34823&";
//		String vila05 = "https://ts100.x10.international.travian.com/dorf1.php?newdid=36987&";
//		String vila06 = "https://ts100.x10.international.travian.com/dorf1.php?newdid=38562&";
//		String recebedora="03-C";
//

//		String mercado01 = "https://ts100.x10.international.travian.com/build.php?newdid=22116&id=32&gid=17";
	//	MelhorarCamposV2.estrutura(vila01, quartel01, 15);
	//	String quartel01 = "https://ts100.x10.international.travian.com/build.php?newdid=22116&id=30&gid=19";
		MelhorarCamposV2.recurso(vila01);
	//	GerarTropas.loopParaCriarTropas("15", quartel01, vila01);
//		EnviarRecursos.iniciarEnvio(vila01, recebedora, mercado01);
//
//		String quartel02 = "https://ts100.x10.international.travian.com/build.php?newdid=30354&id=30&gid=19";
//		String mercado02 = "https://ts100.x10.international.travian.com/build.php?newdid=30354&id=32&gid=17";
//		GerarTropas.loopParaCriarTropas("30", quartel02, vila02);
// 		EnviarRecursos.iniciarEnvio(vila02, recebedora, mercado02);
//
//		String quartel03 = "https://ts100.x10.international.travian.com/build.php?newdid=32635&id=30&gid=19";
//		MelhorarCamposV2.recurso(vila03);
//		GerarTropas.loopParaCriarTropas("20", quartel03, vila03);

//		String quartel04 = "https://ts100.x10.international.travian.com/build.php?newdid=34823&id=30&gid=19";
//		String mercado04 = "https://ts100.x10.international.travian.com/build.php?newdid=34823&id=32&gid=17";
//		EnviarRecursos.iniciarEnvio(vila04, recebedora, mercado04);
//		GerarTropas.loopParaCriarTropas("20", quartel04, vila04);
//
//		MelhorarCamposV2.recurso(vila05);
//		MelhorarCamposV2.recurso(vila06);

	}

}
