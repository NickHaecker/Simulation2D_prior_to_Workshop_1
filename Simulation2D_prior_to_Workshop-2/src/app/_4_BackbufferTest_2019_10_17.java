package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class _4_BackbufferTest_2019_10_17 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage backBuffer;

	public _4_BackbufferTest_2019_10_17() {
		setTitle("2D-Demo der Wirkung von Zwischenpuffern");
		setSize(_0_Constants.WINDOW_WIDTH, _0_Constants.WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		backBuffer = new BufferedImage(_0_Constants.WINDOW_WIDTH, _0_Constants.WINDOW_HEIGHT,
				BufferedImage.TYPE_INT_RGB);

		// Denkbar ist die Verwendung von RGBA-Bildern
	}

	public static void main(String[] args) {
		_4_BackbufferTest_2019_10_17 testObjekt = new _4_BackbufferTest_2019_10_17();

		testObjekt.setVisible(true);
		double absT = 0;
		while (true) {
			testObjekt.draw(absT);
			try {
				Thread.sleep((int) (_0_Constants.TPF * 1000));
				absT += _0_Constants.TPF;
			} catch (InterruptedException e) {
			}
		}

	}

	void draw(double absT) {
		Graphics g = getGraphics();
		Graphics bbg = backBuffer.getGraphics();

		int vx = 100; // Pixel je Sekunde bei der obigen Wahl Thread.sleep(Constants.TPF * 1000); absT
		// += Constants.TPF;
		int vy = 50;

		bbg.setColor(Color.LIGHT_GRAY);
		bbg.fillRect(0, 0, _0_Constants.WINDOW_WIDTH, _0_Constants.WINDOW_HEIGHT);
		bbg.setColor(Color.RED);
		for (int i = 0; i < 30; i++) {
			bbg.fillOval((int) (i * 30 + absT * vx), (int) (i * 20 + absT * vy), 50, 30);
		}
		g.drawImage(backBuffer, 0, 0, null);

	}

}
