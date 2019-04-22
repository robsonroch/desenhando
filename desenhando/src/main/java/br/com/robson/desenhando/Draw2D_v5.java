package br.com.robson.desenhando;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

public class Draw2D_v5 {
	public static Image img;
	protected static int iii;
	private static int largura = 800;
	private static int altura = 800;
	private static int[] pixels;
	private static BufferedImage imagem;
	private static File arquivo;

	public static void main(String args[]) throws IOException {
		
		setInicial(args);

		int xDoRaio = 300;
		int yDoRaio = 300;
		int tamRaio = 100;
		int espesuraLinha = 2;
		int espesuraPonto = 20;
		criarCirculo(xDoRaio, yDoRaio, tamRaio, espesuraLinha, true);
		setPontosAleatorios(300, espesuraPonto);

		imagem.setRGB(0, 0, largura, altura, pixels, 0, largura);
		ImageIO.write(imagem, "PNG", arquivo);

	}

	private static void criarCirculo(int centroX, int centroY, int raio, int espesuraLinha, boolean marcarOcentro) {
		List<Integer[]> pontos = new ArrayList<Integer[]>();

		if (marcarOcentro) {
			pixels[(centroX - 1) * largura + centroY] = new Color(0, 0, 255).getRGB();
			pixels[(centroX) * largura + centroY - 1] = new Color(0, 0, 255).getRGB();
			pixels[centroX * largura + centroY] = new Color(0, 0, 255).getRGB();
			pixels[(centroX) * largura + centroY + 1] = new Color(0, 0, 255).getRGB();
			pixels[(centroX + 1) * largura + centroY] = new Color(0, 0, 255).getRGB();
		}
		for (int i = espesuraLinha; i > 0; i--) {
			drawCircle(300, 300, raio - i, 5000, pontos);
		}
		for (Integer[] pixel : pontos) {
			pixels[largura * pixel[0] + pixel[1]] = new Color(0, 0, 0).getRGB();
		}
	}

	private static void setInicial(String[] args) throws IOException {
		if(args.length == 0) {
			System.out.println(new Date().getTime());
			arquivo = creaNovo("C:\\Users\\robson.rocha\\Pictures\\imagem" + new Date().getTime());
		}else {
			
			arquivo = creaNovo(args[0]);
		}

		imagem = ImageIO.read(arquivo);
		largura = imagem.getWidth();
		altura = imagem.getHeight();
		pixels = imagem.getRGB(0, 0, largura, altura, null, 0, largura);

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
	
	public static File creaNovo(String nameFile) throws IOException {

		// Constructs a BufferedImage of one of the predefined image types.
		BufferedImage bufferedImage = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

		// Create a graphics which can be used to draw into the buffered image
		Graphics2D g2d = bufferedImage.createGraphics();

		// fill all the image with white
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, largura, altura);

		g2d.dispose();

		// Save as PNG
		File file = new File(nameFile + ".png");
		ImageIO.write(bufferedImage, "png", file);

		// Save as JPEG
		/*
		 * file2 = new File(nameFile + ".jpg"); ImageIO.write(bufferedImage, "jpg",
		 * file);
		 */

		return file;

	}

	public static List<Integer[]> setPontosAleatorios(int quantidadePontos, int espesuraPonto) {
		List<Integer[]> pontos = new ArrayList<Integer[]>();
		Random r = new Random();

		for (int i = 0; i < quantidadePontos; i++) {
			int x = r.nextInt(largura);
			int y = r.nextInt(altura);
			for (int j = 0; j < espesuraPonto; j++) {
				for (int k = 0; k < espesuraPonto; k++) {
					if (((x + j) * largura + (y + k)) < (largura * altura)) {
						pixels[(x + j) * largura + (y + k)] = new Color(255, 0, 0).getRGB();
					}
				}
			}
		}

		return pontos;
	}
	
	public static void setCorPonto(List<Integer> pontos) {
		for(Integer ponto: pontos) {
			pixels[ponto] = new Color(255, 0, 0).getRGB();
		}
	}
	

}
