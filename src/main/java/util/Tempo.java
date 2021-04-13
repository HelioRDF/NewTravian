package util;

public class Tempo {

	public static void aguardarEmSegundos(boolean log, long tempoSegundos, String mensagem) {
		long segundos = tempoSegundos * 1000;
		try {
			if (log) {
				MensagenConsole.info(mensagem);
				MensagenConsole.info("Aguardando: " + tempoSegundos + " segundos.");
			}
			Thread.sleep(segundos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void aguardarEmMinutos(boolean log, long tempoMinutos, String mensagem) {
		long minutos = tempoMinutos * 1000 * 60;
		try {
			if (log) {
				MensagenConsole.info(mensagem + "\n Aguardar: " + (tempoMinutos) + " minutos");
			}
			Thread.sleep(minutos);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void aguardarEmHoras(boolean log, long tempoHoras, String mensagem) {
		long horas = tempoHoras * 1000 * 60 * 60;
		try {
			if (log) {
				MensagenConsole.info(mensagem);
				MensagenConsole.info("Aguardando: " + tempoHoras + " Horas.");
			}
			Thread.sleep(horas);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
