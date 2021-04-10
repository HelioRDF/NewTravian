package util;

import java.util.Comparator;

import entidade.AldeiaFarme;

public class OrganizarListaPorDistancia implements Comparator<AldeiaFarme> {

	public int compare(AldeiaFarme o1, AldeiaFarme o2) {
		return (int) (o1.getDistancia() - o2.getDistancia());
	}

}
