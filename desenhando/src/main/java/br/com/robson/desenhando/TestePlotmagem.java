package br.com.robson.desenhando;

import java.io.IOException;
import java.util.List;

import br.com.robson.desenhando.util.ImagemFactory;
import static br.com.robson.desenhando.util.PlotarImageUtil.criarCirculo;

public class TestePlotmagem {

	public static void main(String[] args) throws IOException {
		ImagemFactory imgfctr = new ImagemFactory(args[0]);
		
		int xDoRaio = 300;
		int yDoRaio = 300;
		int tamRaio = 100;
		int espesuraLinha = 2;
		int espesuraPonto = 20;
		List<Integer[]> pontos = criarCirculo(xDoRaio, yDoRaio, tamRaio, espesuraLinha, true);

		imgfctr.setCorPontoXY(pontos);
		
		imgfctr.finalizar();
	}

}
