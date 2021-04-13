package main;

import java.util.Timer;
import java.util.TimerTask;

import executar.Login;
import monitor.ScannerVila;
import util.MensagenConsole;

public class RunnerMonitor extends TimerTask {
	static int contador = 1;

	public static void main(String[] args) {
		Login.executarLogin();
		long intervaloEmMinutos = 13;
		long delayPrimeiraExecucao = 2000;
		long intervalo = (1000 * 60) * intervaloEmMinutos;
		Timer timer = new Timer();
		timer.schedule(new RunnerMonitor(), delayPrimeiraExecucao, intervalo);

	}

	public void run() {
		
		ScannerVila.iniciarScan();
		MensagenConsole.info("Intervalo = " + contador);
		contador++;

	}

}
