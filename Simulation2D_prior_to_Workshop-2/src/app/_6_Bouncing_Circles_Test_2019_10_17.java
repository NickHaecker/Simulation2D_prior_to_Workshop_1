package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class _6_Bouncing_Circles_Test_2019_10_17 extends JFrame {

	private static final long serialVersionUID = 1L;
	private BufferedImage backBuffer;

	public _6_Bouncing_Circles_Test_2019_10_17() {
		setTitle("2D Demo - Hüpfende Bälle");
		setSize(_0_Constants.WINDOW_WIDTH, _0_Constants.WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		backBuffer = new BufferedImage(_0_Constants.WINDOW_WIDTH, _0_Constants.WINDOW_HEIGHT,
				BufferedImage.TYPE_INT_RGB);
	}

	public static void main(String[] args) {
		_6_Bouncing_Circles_Test_2019_10_17 testObjekt = new _6_Bouncing_Circles_Test_2019_10_17();

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

		int vy = 500;
		bbg.setColor(Color.WHITE);
		bbg.fillRect(0, 0, _0_Constants.WINDOW_WIDTH, _0_Constants.WINDOW_HEIGHT);

		bbg.setColor(Color.RED);

		bbg.fillOval((int) (20), (int) (20 + absT * vy), 40, 40);

		g.drawImage(backBuffer, 0, 0, null);

	}

}
