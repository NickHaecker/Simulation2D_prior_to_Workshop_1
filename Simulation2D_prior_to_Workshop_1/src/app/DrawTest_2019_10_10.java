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
		g.setColor(Color.BLACK);
		g.drawLine(1, Constants.WINDOW_HEIGHT / 2, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT / 2);
		g.drawLine(Constants.WINDOW_WIDTH / 2, 1, Constants.WINDOW_WIDTH / 2, Constants.WINDOW_HEIGHT);
		g.drawLine(Constants.WINDOW_WIDTH - 500, Constants.WINDOW_HEIGHT / 2, Constants.WINDOW_WIDTH / 2,
				Constants.WINDOW_HEIGHT - 500);
		g.drawLine(Constants.WINDOW_WIDTH - 300, Constants.WINDOW_HEIGHT / 2, Constants.WINDOW_WIDTH / 2,
				Constants.WINDOW_HEIGHT - 500);
		g.setColor(Color.RED);
		g.fillOval(Constants.WINDOW_WIDTH - 510, Constants.WINDOW_HEIGHT - 310, 20, 20);
		g.fillOval(Constants.WINDOW_WIDTH - 310, Constants.WINDOW_HEIGHT - 310, 20, 20);
		g.fillOval(Constants.WINDOW_WIDTH - 410, Constants.WINDOW_HEIGHT - 510, 20, 20);
		g.setColor(Color.YELLOW);
		g.fillOval(Constants.WINDOW_WIDTH - 410, Constants.WINDOW_HEIGHT - 310, 20, 20);
		g.fillOval(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, 20, 20);
		g.fillOval(Constants.WINDOW_WIDTH - 360, Constants.WINDOW_HEIGHT - 400, 20, 20);

	}

}
