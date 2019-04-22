package br.com.robson.modelo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Ponto {

	private Integer lng;
	private Integer lat;
	private int key;

	public Ponto(Integer lng, Integer lat) {
		this.lng = lng;
		this.lat = lat;
		key = (int) (this.lng * 100 + this.lat);
	}
	
	public Integer getLng() {
		return lng;
	}
	
	public Integer getLat() {
		return lat;
	}
	
	public List<Integer> convertPontoToPixel(int larguraImagem, int alturaImagem, int espesuraPonto) {
		List<Integer> pixels = new ArrayList<Integer>();
		for (int j = 0; j < espesuraPonto; j++) {
			for (int k = 0; k < espesuraPonto; k++) {
				if (((lng + j) * larguraImagem + (lat + k)) <= (larguraImagem * alturaImagem)) {
					pixels.add((int) ((lng + j) * larguraImagem + (lat + k)));
				}
			}
		}
		
		return pixels;
	}
	
	public int getZoneKey(){		
		return this.key;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (lng * 100 + lat);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ponto other = (Ponto) obj;
		if (lat == null) {
			if (other.lat != null)
				return false;
		} else if (!lat.equals(other.lat))
			return false;
		if (lng == null) {
			if (other.lng != null)
				return false;
		} else if (!lng.equals(other.lng))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "lng=" + lng + ", lat=" + lat + ", key=" + getZoneKey();
	}
	
}
