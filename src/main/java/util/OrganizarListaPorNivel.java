package util;

import java.util.Comparator;

import entidade.Campo;

public class OrganizarListaPorNivel implements Comparator<Campo> {

	public int compare(Campo o1, Campo o2) {
		return (int) (o1.getNivel() - o2.getNivel());
	}

}
