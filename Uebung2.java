
import java.awt.*;

public class Uebung2 {

	public static void main(String[] args) {

		KoordinatensystemBlatt zb = new KoordinatensystemBlatt(600, 600);
		zb.benutzerkoordinaten(0.0, 0.0, 400.0, 400.0);
		zb.anzeigen();
		zb.zeichneKoordinatenSystem(400, 400, 20, 20);
		zb.setVordergrundFarbe(Color.BLACK);

		int zaehler = 0;
		double v = 80.0;
		final double G = 9.8;
		final double C = 0.002;
		double teta = (60.0 / 180.0) * Math.PI;
		double t = 0.0;
		double x = 0;
		double y = 0;

		double vx = v * Math.cos(teta);
		double vy = v * Math.sin(teta);
		double ax = -C * v * vx;
		double ay = -G - C * v * vy;

		do {
			zaehler++;
			t = 0.01;

			// Punkt berechnen
			x = x + (vx * t); 
			y = y + (vy * t);
			zb.punkt(x + 30, y + 32, 5.0);

			// neues vx und neues vy berechnen
			vx = vx + (ax * t);
			vy = vy + (ay * t);

			// neues v berechnen
			v = Math.sqrt((vx * vx) + (vy));

			// neues ax und neues ay berechnen
			ax = -C * v * vx;
			ay = -G + (-C * v * vy);

			System.out.println("t = " + (int) (t * zaehler) + "." + (int) (t * zaehler * 10 % 10) + "  |  " + "(" + x
					+ "," + y + ")");

		} while (y > 0);
		zb.anzeigen();
	}
}
