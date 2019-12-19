package seminarprojekt;

import java.awt.Color;

public class wand {

	final int x1;
	final int x2;
	final int y1;
	final int y2;
	final Color f;

	public wand(int X1, int Y1, int X2, int Y2, Color farbe) {
		x1 = X1;
		x2 = X2;
		y1 = Y1;
		y2 = Y2;
		f = farbe;
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

	/*
	 * private final LinkedList<wand> waende = new LinkedList<wand>();
	 * 
	 * public void addwand(int x1, int x2, int x3, int x4) { addwand(x1, x2, x3, x4,
	 * Color.black); }
	 * 
	 * public void addwand(int x1, int x2, int x3, int x4, Color color) {
	 * waende.add(new wand(x1, x2, x3, x4, color)); // repaint(); }
	 * 
	 * public void clearLines() { waende.clear(); // repaint(); }/*
	 * 
	 * /* public void zeichnewand(Graphics g) { g.setColor(f); g.drawLine(x1, y1,
	 * x2, y2);
	 * 
	 * }
	 */
}
