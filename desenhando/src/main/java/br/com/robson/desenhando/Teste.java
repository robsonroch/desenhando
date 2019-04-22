package br.com.robson.desenhando;

import javax.swing.*;
import java.awt.*;

class Teste extends JFrame {
    private static int POINT_SIZE = 1;

    @Override public void paint(Graphics g) {
        super.paint(g);
        drawCircle(g, 200, 200, 100, 1000, Color.RED);
    }

    public void drawCircle(Graphics g, int posicaoX, int posicaoY,
                           int raio, int quantidadeDePontos, Color cor) {

        double distanciaEntrePontos = 2 * Math.PI / quantidadeDePontos;

        for (int i = 0; i < quantidadeDePontos; i++) {
            double cos = Math.cos(i * distanciaEntrePontos);
            double sin = Math.sin(i * distanciaEntrePontos);

            int x = (int) ( cos * raio + posicaoX );
            int y = (int) ( sin * raio + posicaoY );

            g.setColor(cor);
            g.fillRect(x, y, POINT_SIZE, POINT_SIZE);
        }
    }

    public static void main(String... args) {
        JFrame frame = new Teste();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}