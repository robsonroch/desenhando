package br.com.robson.desenhando;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class PierChart {

	// guarda os valores a serem exibidos no gráfico
	private int[] values;
	// guarda o buffer da imagem desenhada
	private BufferedImage imageBuffer;
	// guarda a cor de fundo
	private Color background;
	// guardam as dimensões da imagem
	private int width, height;
	// cores para os pedaços do gráfico
	private Color[] colors = { Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW, Color.ORANGE, Color.PINK,
			Color.MAGENTA, Color.LIGHT_GRAY, Color.GRAY, Color.BLACK };

	/**
	 * Cria um objeto da classe que gera um gráfico em pizza.
	 * 
	 * @param values     Array de valores inteiros a serem representados.
	 * @param width      Largura da imagem.
	 * @param height     Altura da imagem.
	 * @param background Cor de fundo da imagem.
	 */
	public PierChart(int[] values, int width, int height, Color background) {
		if (values == null || values.length < 1 || width < 0 || height < 0 || background == null)
			throw new IllegalArgumentException();
		this.values = values;
		this.width = width;
		this.height = height;
		this.background = background;
		createChart();
	}

	/**
	 * Cria a imagem internamente.
	 */
	private void createChart() {
		imageBuffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = imageBuffer.createGraphics();
		g.setColor(background);
		g.fillRect(0, 0, width, height);
		int arc = 0;
		int[] sizes = calculateAngles(values);
		for (int i = 0, j = 0; i < sizes.length; i++, j++) {
			if (j == 10)
				j = 0;
			g.setColor(colors[j]);
			g.fillArc(0, 0, width, height, arc, sizes[i]);
			arc += sizes[i];
		}
	}

	/**
	 * Calcula os ângulos para cada valor informado.
	 * 
	 * @param values Valores a terem seus ângulos calculados.
	 * @return Array de int com os ângulos para cada valor.
	 */
	private int[] calculateAngles(int[] values) {
		int[] angles = new int[values.length];
		int total = 0;
		// calcula a somatória total dos valores
		for (int i = 0; i < values.length; i++) {
			total += values[i];
		}
		// calcula os ângulos para cada pedaço
		for (int i = 0; i < values.length; i++) {
			angles[i] = (360 * values[i]) / total;
		}
		return angles;
	}

	/**
	 * Retorna a imagem do gráfico em pizza.
	 * 
	 * @return Retorna um objeto do tipo ImageIcon.
	 */
	public ImageIcon getImageIcon() {
		return new ImageIcon(imageBuffer);
	}

	/**
	 * Retorna o buffer da imagem do gráfico em pizza.
	 * 
	 * @return Retorna um objeto do tipo BufferedImage.
	 */
	public BufferedImage getBufferedImage() {
		return imageBuffer;
	}

}
