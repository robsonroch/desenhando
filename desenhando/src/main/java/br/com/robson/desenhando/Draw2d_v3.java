package br.com.robson.desenhando;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Draw2d_v3 {
	public static Image img;
	public static Graphics2D g2;
	private static javax.swing.JFrame j;
	protected static int iii;

	public static void main(String args[]) throws IOException {
		File creaNovo = creaNovo(args[0]);

		BufferedImage imagem = ImageIO.read(creaNovo);
		int w = imagem.getWidth();
		int h = imagem.getHeight();
		int[] pixels = imagem.getRGB(0, 0, w, h, null, 0, w);
		Random r = new Random();

		for (int col = 0; col < w; col++) {
			
				pixels[col] = new Color(0, 0, 0).getRGB();
			
		}

		imagem.setRGB(0, 0, w, h, pixels, 0, w);
		ImageIO.write(imagem, "PNG", creaNovo);

	}

	public static void desenhaCircurlo(double cento, double raio) {
//	(x - 2)2  + (y + 3)2 = 16
	}

	public static void CarregImg(File creaNovo) {
		try {
			BufferedImage image = ImageIO.read(creaNovo);

		}

		catch (IOException e) {

			System.out.println("Erro:" + e.getMessage());
			iii = iii + 1;
		}
		if (iii > 0) {
			System.out.println("Erro Desconhecido ao carregar Imagem");
		}

	}

	public static void DesenhandoIMG() {

//Criamos uma imagem de 640x480 pixels?
		BufferedImage aceimg = new BufferedImage(640, 480, BufferedImage.TYPE_INT_ARGB);

//Cria o G2D da imagem!
		Graphics2D g2d = aceimg.createGraphics();

//Libera da memória ?
		g2d.dispose();
	}

	public static File creaNovo(String nameFile) throws IOException {

		int width = 250;
		int height = 250;

		// Constructs a BufferedImage of one of the predefined image types.
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// Create a graphics which can be used to draw into the buffered image
		Graphics2D g2d = bufferedImage.createGraphics();

		// fill all the image with white
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, width, height);

		// create a circle with black
		g2d.setColor(Color.black);
		g2d.fillOval(0, 0, width, height);

		// create a string with yellow
		g2d.setColor(Color.yellow);
		g2d.drawString("Java Code Geeks", 50, 120);

		// Disposes of this graphics context and releases any system resources that it
		// is using.
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

}
