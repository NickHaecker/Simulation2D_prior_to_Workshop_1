package app;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class DrawTest_2019_10_10 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DrawTest_2019_10_10() {
		setTitle("Herzlich willkommen zum ersten Workshop (2D-Grafiken)");
		setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		DrawTest_2019_10_10 testObjekt = new DrawTest_2019_10_10();

		testObjekt.setVisible(true);
		while (true) {
			testObjekt.draw();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}

	}

	void draw() {
		Graphics g = getGraphics();

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

	}

}
