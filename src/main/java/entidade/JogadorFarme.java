package entidade;

import java.util.ArrayList;

public class JogadorFarme {
	String posicao;
	String jogador;
	String link;
	String alianca;
	String populacao;
	int quantidadeVilas;
	ArrayList<String> linkVilas;

	@Override
	public String toString() {
		return "JogadorFarme [posicao=" + posicao + ", jogador=" + jogador + ", link=" + link + ", alianca=" + alianca
				+ ", populacao=" + populacao + ", quantidadeVilas=" + quantidadeVilas + ", linkVilas=" + linkVilas
				+ "]";
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public String getJogador() {
		return jogador;
	}

	public void setJogador(String jogador) {
		this.jogador = jogador;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAlianca() {
		return alianca;
	}

	public void setAlianca(String alianca) {
		this.alianca = alianca;
	}

	public String getPopulacao() {
		return populacao;
	}

	public void setPopulacao(String populacao) {
		this.populacao = populacao;
	}

	public ArrayList<String> getLinkVilas() {
		return linkVilas;
	}

	public void setLinkVilas(ArrayList<String> linkVilas) {
		this.linkVilas = linkVilas;
	}

	public int getQuantidadeVilas() {
		return quantidadeVilas;
	}

	public void setQuantidadeVilas(int quantidadeVilas) {
		this.quantidadeVilas = quantidadeVilas;
	}

	public JogadorFarme(String posicao, String jogador, String link, String alianca, String populacao,
			int quantidadeVilas) {
		super();
		this.posicao = posicao;
		this.jogador = jogador;
		this.link = link;
		this.alianca = alianca;
		this.populacao = populacao;
		this.quantidadeVilas = quantidadeVilas;
	}

}
