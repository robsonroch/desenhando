package br.com.robson.desenhando;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.font.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.imageio.ImageIO;

public class Draw2D_v1 {
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
		
		Boolean linhaImpar ;
		Boolean colunaImpar;
			
		for (int index = 0; index < w*h; index++) {
			int linha = index/(w)+1;
			int coluna= index%(w)+1;
			
			linhaImpar = ((coluna%10)==1 || (coluna%10)==2 || (coluna%10)==3 || (coluna%10)==4 || (coluna%10)==5);
			colunaImpar = ((linha%10)==1|| (linha%10)==2 || (linha%10)==3 || (linha%10)==4 || (linha%10)==5);
			System.out.println(linha);
			
			if((linhaImpar && !colunaImpar) || (!linhaImpar && colunaImpar)){
				pixels[index] = new Color(0, 0, 0).getRGB();
			}
		}

		imagem.setRGB(0, 0, w, h, pixels, 0, w);
		ImageIO.write(imagem, "PNG", creaNovo);

	}
	
	public static HashSet<Integer> drawCircle( int posicaoX, int posicaoY, int raio, int quantidadeDePontos, int[] pixels, int h) {

		HashSet<Integer> ponto = new HashSet<Integer>();
		
		double distanciaEntrePontos = 2 * Math.PI / quantidadeDePontos;
	
		for (int i = 0; i < quantidadeDePontos; i++) {
			double cos = Math.cos(i * distanciaEntrePontos);
			double sin = Math.sin(i * distanciaEntrePontos);
			
			int x = (int) ( cos * raio + posicaoX );
			int y = (int) ( sin * raio + posicaoY );
		
			ponto.add(x*y);
		}
		
		return ponto;
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
 
        g2d.dispose();
 
        // Save as PNG
        File file = new File(nameFile + ".png");
        ImageIO.write(bufferedImage, "png", file);
 
        // Save as JPEG
       /* file2 = new File(nameFile + ".jpg");
        ImageIO.write(bufferedImage, "jpg", file);*/
        
        return file;
 
    }


}
