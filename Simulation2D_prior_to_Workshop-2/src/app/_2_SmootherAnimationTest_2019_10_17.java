package app;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class _2_SmootherAnimationTest_2019_10_17 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public _2_SmootherAnimationTest_2019_10_17() {
		setTitle("2D-Beispielanimation Nr. 2: glattere Bewegung");
		setSize(_0_Constants.WINDOW_WIDTH, _0_Constants.WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		_2_SmootherAnimationTest_2019_10_17 testObjekt = new _2_SmootherAnimationTest_2019_10_17();

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
		int vx = 100; // Pixel je Sekunde bei der obigen Wahl Thread.sleep(Constants.TPF * 1000); absT
						// += Constants.TPF;
		int vy = 50;
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, _0_Constants.WINDOW_WIDTH, _0_Constants.WINDOW_HEIGHT);
		g.setColor(Color.RED);
		g.fillOval((int) (100 + absT * vx), (int) (100 + absT * vy), 50, 50);

	}

}
