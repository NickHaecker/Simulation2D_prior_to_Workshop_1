package app;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class _1_AnimationTest_2019_10_17 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public _1_AnimationTest_2019_10_17() {
		setTitle("2D-Beispielanimation Nr. 1: sprunghafte Bewegung");
		setSize(_0_Constants.WINDOW_WIDTH, _0_Constants.WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		_1_AnimationTest_2019_10_17 testObjekt = new _1_AnimationTest_2019_10_17();

		testObjekt.setVisible(true);
		double absT = 0;
		while (true) {
			testObjekt.draw(absT);
			try {
				Thread.sleep(1000); // in Millisekunden
				absT += 1;
			} catch (InterruptedException e) {
			}
		}

	}

	void draw(double absT) {
		Graphics g = getGraphics();
		int vx = 100; // Pixel je Sekunde bei der obigen Wahl Thread.sleep(1000); absT += 1;
		int vy = 50;
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, _0_Constants.WINDOW_WIDTH, _0_Constants.WINDOW_HEIGHT);
		g.setColor(Color.RED);
		g.fillOval((int) (100 + absT * vx), (int) (100 + absT * vy), 50, 50);
		g.drawLine(0, , x2, y2);
	}

}
