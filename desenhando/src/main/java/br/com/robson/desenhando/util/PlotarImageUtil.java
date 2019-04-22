package br.com.robson.desenhando.util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class PlotarImageUtil {

	public static List<Integer[]> criarCirculo(int centroX, int centroY, int raio, int espesuraLinha, boolean marcarOcentro) {
		List<Integer[]> pontos = new ArrayList<Integer[]>();

		if (marcarOcentro) {			
			pontos.add(new Integer[]{centroX - 1, centroY});
			pontos.add(new Integer[]{centroX, centroY - 1});
			pontos.add(new Integer[]{centroX, centroY});
			pontos.add(new Integer[]{centroX,centroY + 1});
			pontos.add(new Integer[]{centroX + 1, centroY});
		}
		for (int i = espesuraLinha; i > 0; i--) {
			drawCircle(centroX, centroY, raio - i, 5000, pontos);
		}
		
		return pontos;
	}
	
	public static void drawCircle(int posicaoX, int posicaoY, int raio, int quantidadeDePontos,
			List<Integer[]> pontos) {

		double distanciaEntrePontos = 2 * Math.PI / quantidadeDePontos;

		for (int i = 0; i < quantidadeDePontos; i++) {
			double cos = Math.cos(i * distanciaEntrePontos);
			double sin = Math.sin(i * distanciaEntrePontos);

			int x = (int) (cos * raio + posicaoX);
			int y = (int) (sin * raio + posicaoY);
			Integer[] pair = { x, y };
			pontos.add(pair);
		}

	}
}
