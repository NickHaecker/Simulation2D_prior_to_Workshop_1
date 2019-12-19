package seminarprojekt;

import java.awt.Color;
import java.awt.Graphics;

public class bodenschiene {

	final int x1;
	final int x2;
	final int y1;
	final int y2;
	final Color f;

	public bodenschiene(int X1, int Y1, int X2, int Y2, Color F) {
		x1 = X1;
		x2 = X2;
		y1 = Y1;
		y2 = Y2;
		f = F;
	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getY1() {
		return y1;
	}

	public int getY2() {
		return y2;
	}

	public Color getF() {
		return f;
	}

	public void zeichnebodenschiene(Graphics g) {
		g.setColor(f);
		g.drawLine(x1, y1, x2, y2);
	}
}