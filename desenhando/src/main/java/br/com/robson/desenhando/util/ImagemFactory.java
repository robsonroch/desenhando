package br.com.robson.desenhando.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

public class ImagemFactory {
	public static Image img;
	protected static int iii;
	private int largura;
	private int altura;
	private static int[] pixels;
	private BufferedImage imagem;
	private static File arquivo;

	public ImagemFactory(String nomeArquivo, int altura, int largura) throws IOException {
		this.altura = altura;
		this.largura = largura;
		setInicial(nomeArquivo);
	}

	public ImagemFactory(String nomeArquivo) throws IOException {
		ImagemFactory.arquivo = new File(nomeArquivo);
		this.imagem = ImageIO.read(arquivo);
		ImageIO.write(imagem, "PNG", arquivo);

		this.altura = imagem.getHeight();
		this.largura = imagem.getWidth();
		ImagemFactory.pixels = imagem.getRGB(0, 0, largura, altura, null, 0, largura);
	}

	private void setInicial(String nomeArquivo) throws IOException {
		if (nomeArquivo == null && nomeArquivo.isEmpty()) {
			arquivo = creaNovo("C:\\Users\\robson.rocha\\Pictures\\imagem" + new Date().getTime());
		} else {
			arquivo = creaNovo(nomeArquivo);
		}

		this.imagem = ImageIO.read(arquivo);

		pixels = imagem.getRGB(0, 0, this.largura, this.altura, null, 0, this.largura);

	}

	private File creaNovo(String nameFile) throws IOException {

		// Constructs a BufferedImage of one of the predefined image types.
		BufferedImage bufferedImage = new BufferedImage(this.largura, this.altura, BufferedImage.TYPE_INT_RGB);

		// Create a graphics which can be used to draw into the buffered image
		Graphics2D g2d = bufferedImage.createGraphics();

		// fill all the image with white
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, largura, altura);

		g2d.dispose();
		// Save as PNG
		File file = new File(nameFile + ".png");
		ImageIO.write(bufferedImage, "png", file);

		return file;

	}

	public void finalizar() throws IOException {
		imagem.setRGB(0, 0, largura, altura, pixels, 0, largura);
		ImageIO.write(imagem, "PNG", arquivo);
	}

	public static void setCorPonto(List<Integer> pontos) {
		for (Integer ponto : pontos) {
			pixels[ponto] = new Color(255, 0, 0).getRGB();
		}
	}

	public void setCorPontoXY(List<Integer[]> coordenadas) {
		for (Integer[] pixel : coordenadas) {
			ImagemFactory.pixels[(this.largura * pixel[0] + pixel[1])] = new Color(0, 255, 0).getRGB();
		}
	}

}
