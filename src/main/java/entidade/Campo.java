package entidade;

public class Campo {

	private int id;
	private int nivel;
	private String link;
	private String nomeCampo;
	private long tempoMelhoriaHora;
	private long tempoMelhoriaMinuto;
	
	public Campo() {
		super();
	}

	public Campo(int id, int nivel, String link, String nomeCampo, long tempoMelhoriaHora, long tempoMelhoriaMinuto) {
		super();
		this.id = id;
		this.nivel = nivel;
		this.link = link;
		this.nomeCampo = nomeCampo;
		this.tempoMelhoriaHora = tempoMelhoriaHora;
		this.tempoMelhoriaMinuto = tempoMelhoriaMinuto;

	}

	@Override
	public String toString() {
		return "Campo [id=" + id + ", nivel=" + nivel + ", nomeCampo=" + nomeCampo + ", tempoMelhoriaHora="
				+ tempoMelhoriaHora + ", tempoMelhoriaMinuto=" + tempoMelhoriaMinuto + ", link=" + link
				+ ", botaoConfirmarMelhoria=" + "]";
	}

	public String toStringResumido() {
		return "Campo [id=" + id + ", nivel=" + nivel + ", nomeCampo=" + nomeCampo + ", tempoMelhoriaHora="
				+ tempoMelhoriaHora + ", tempoMelhoriaMinuto=" + tempoMelhoriaMinuto + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campo other = (Campo) obj;
		if (id != other.id)
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (nivel != other.nivel)
			return false;
		if (nomeCampo == null) {
			if (other.nomeCampo != null)
				return false;
		} else if (!nomeCampo.equals(other.nomeCampo))
			return false;
		if (tempoMelhoriaHora != other.tempoMelhoriaHora)
			return false;
		if (tempoMelhoriaMinuto != other.tempoMelhoriaMinuto)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getNomeCampo() {
		return nomeCampo;
	}

	public void setNomeCampo(String nomeCampo) {
		this.nomeCampo = nomeCampo;
	}

	public long getTempoMelhoriaHora() {
		return tempoMelhoriaHora;
	}

	public void setTempoMelhoriaHora(long tempoMelhoriaHora) {
		this.tempoMelhoriaHora = tempoMelhoriaHora;
	}

	public long getTempoMelhoriaMinuto() {
		return tempoMelhoriaMinuto;
	}

	public void setTempoMelhoriaMinuto(long tempoMelhoriaMinuto) {
		this.tempoMelhoriaMinuto = tempoMelhoriaMinuto;
	}

	public long retornaTempoTotalEmMinutos() {
		long tempoTotal = ((getTempoMelhoriaMinuto()) + (60 * getTempoMelhoriaHora()));
		return tempoTotal;
	}

}
