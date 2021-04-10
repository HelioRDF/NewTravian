package entidade;

public class AldeiaFarme {

	String nomeAldeia;
	String jogador;
	String link;
	String habitantes;
	double distancia;
	String tropas;

	public String getTropas() {
		return tropas;
	}

	public void setTropas(String tropas) {
		this.tropas = tropas;
	}

	public String getJogador() {
		return jogador;
	}

	public void setJogador(String jogador) {
		this.jogador = jogador;
	}

	public AldeiaFarme() {
		super();

	}

	public AldeiaFarme(String nomeAldeia, String jogador, String link, String habitantes, double distancia,
			String tropas) {
		super();
		this.nomeAldeia = nomeAldeia;
		this.jogador = jogador;
		this.link = link;
		this.habitantes = habitantes;
		this.distancia = distancia;
		this.tropas = tropas;
	}

	public String getNomeAldeia() {
		return nomeAldeia;
	}

	public void setNomeAldeia(String nomeAldeia) {
		this.nomeAldeia = nomeAldeia;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(String habitantes) {
		this.habitantes = habitantes;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	@Override
	public String toString() {
		return "[nomeAldeia=" + nomeAldeia + ", jogador=" + jogador + ", habitantes=" + habitantes + ", distancia="
				+ distancia + ", tropas=" + tropas + ", link=" + link + "]";
	}

}
