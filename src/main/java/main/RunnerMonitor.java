package main;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

import executar.Login;
import monitor.ScannerVila;
import util.MensagenConsole;

public class RunnerMonitor extends TimerTask {
	static int contador = 1;

	public static void main(String[] args) {
		iniciarLoop();

	}

	public static void iniciarLoop() {
		Login.executarLogin();
		long intervaloEmMinutos =3;
		long delayPrimeiraExecucao = 5000;
		long intervalo = (1000 * 60) * intervaloEmMinutos;
		Timer timer = new Timer();
		timer.schedule(new RunnerMonitor(), delayPrimeiraExecucao, intervalo);

	}

	public void run() {
		LocalTime horaAtual = LocalTime.now();
		MensagenConsole.info("Intervalo = " + contador + " -> Horário: " + horaAtual);
		ScannerVila.iniciarScan();
		contador++;
	}
}
