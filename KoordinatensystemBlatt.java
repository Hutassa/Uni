package zeichenBlattErweiterung;

import java.awt.*;
import javax.swing.*;

public class KoordinatensystemBlatt extends Zeichenblatt{

	public KoordinatensystemBlatt(int breite, int hoehe) {
		super(breite, hoehe);
	}
	
	public void zeichneKoordinatenSystem(int xLaenge, int yLaenge, int xSkalierung, int ySkalierung) {
		int xProportion;
		int yProportion;
		int x;
		int y;
		int verhaeltnis;
		
		xProportion = frame.getWidth() / 20;
		yProportion = frame.getHeight() / 20;
		x = xProportion;
		y = yProportion;
		verhaeltnis = (int) ((this.xmax - this.xmin) / (this.ymax - this.xmin));
		System.out.println(verhaeltnis);
		
		this.gehe(xProportion,  yProportion);
		while (x < (xProportion + xLaenge)) {
			x = x + xSkalierung;
			this.linie(x, yProportion);
			this.linie(x, yProportion + (xProportion / 6));
			this.gehe(x, yProportion);
		}
		
		
		this.gehe(xProportion, yProportion);
		while (y < (yProportion + yLaenge)) {
			y = y + ySkalierung;
			this.linie(xProportion, y);
			this.linie(xProportion + (yProportion * verhaeltnis / 6), y);
			this.gehe(xProportion, y);
		}
		
		this.anzeigen();
	}
}
