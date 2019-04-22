package br.com.robson.desenhando.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import br.com.robson.modelo.Ponto;

public class PontoUtil {

	public static Map<Integer, List<Ponto>> generateMapPontosByCoordenates(List<Integer[]> coordenadas) {

		Map<Integer, List<Ponto>> pontoMap = new HashMap<Integer, List<Ponto>>();

		for (Integer[] ponto : coordenadas) {

			Integer x = ponto[0];
			Integer y = ponto[0];
			Ponto point = new Ponto(x, y);

			List<Ponto> list = pontoMap.get(point.getZoneKey());

			if (list == null || list.isEmpty()) {
				List<Ponto> novaLista = new ArrayList<Ponto>();
				novaLista.add(point);
				pontoMap.put(point.getZoneKey(), novaLista);
			} else {
				list.add(point);
			}
		}

		return pontoMap;
	}

	public static List<Ponto> generateListPontosByCoordenates(List<Integer[]> coordenadas) {

		List<Ponto> pontoList = new ArrayList<Ponto>();

		for (Integer[] ponto : coordenadas) {

			Integer x = ponto[0];
			Integer y = ponto[0];
			Ponto point = new Ponto(x, y);
			pontoList.add(point);
		}
		return pontoList;
	}

	public static Ponto getPontoMaisProximoMap(HashMap<Integer, List<Ponto>> pontosMap, Ponto ponto) {
		List<Ponto> list = pontosMap.get(ponto.getZoneKey());

		return getPontoMaisProximoList(list, ponto);
	}

	public static Ponto getPontoMaisProximoList(List<Ponto> pontos, Ponto ponto) {

		double distanciaAtual = 1000000000000000000000.00;

		System.out.println("tamanho da lista " + pontos.size());

		Ponto result = null;

		for (Ponto pontoAtual : pontos) {
			double calcularDistancia = calcularDistancia(pontoAtual, ponto);
			if (distanciaAtual > calcularDistancia) {
				distanciaAtual = calcularDistancia;
				result = pontoAtual;
			}
		}

		return result;
	}

	private static double calcularDistancia(Ponto pontoAtual, Ponto ponto) {

		return Math.sqrt(
				Math.pow(pontoAtual.getLat() - ponto.getLat(), 2) + Math.pow(pontoAtual.getLng() - ponto.getLng(), 2));

	}
}
