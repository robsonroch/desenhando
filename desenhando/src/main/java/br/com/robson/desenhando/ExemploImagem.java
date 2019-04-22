package br.com.robson.desenhando;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExemploImagem {
	 public static void main(String[] args) {
         JFrame frm = new JFrame("Teste Imagem");
         JPanel pan = new JPanel();
         JLabel lbl = new JLabel( criarImagem() );
         //pan.add( lbl );
         
         
          int[ ] valores = { 20, 10, 60, 90, 180 };
          PierChart pie = new PierChart( valores, 200, 200, Color.WHITE );
          JLabel lbl1 = new JLabel( pie.getImageIcon( ) ); 
          pan.add( lbl1 );
          frm.getContentPane().add( pan );
          frm.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
          frm.pack();
          frm.show();
     }
     
     private static ImageIcon criarImagem() {
         int width=200, height=200;
         BufferedImage buffer = new BufferedImage( width, height, BufferedImage.TYPE_INT_RGB );
         Graphics g = buffer.createGraphics();
         g.setColor( Color.WHITE );
         g.fillRect( 0, 0, width, height );
         g.setColor( Color.BLACK );
         g.drawLine( 0, 0, width, height );
         return new ImageIcon( buffer );
     }
}
