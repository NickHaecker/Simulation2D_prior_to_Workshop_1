package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class _5_TemporalFunctionTest_2019_10_17 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage backBuffer;

	public _5_TemporalFunctionTest_2019_10_17() {
		setTitle("2D-Beispielanimation Nr. 5: Verwendung eines Funktionsausdrucks");
		setSize(_0_Constants.WINDOW_WIDTH, _0_Constants.WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		backBuffer = new BufferedImage(_0_Constants.WINDOW_WIDTH, _0_Constants.WINDOW_HEIGHT,
				BufferedImage.TYPE_INT_RGB);
	}

	public static void main(String[] args) {
		_5_TemporalFunctionTest_2019_10_17 testObjekt = new _5_TemporalFunctionTest_2019_10_17();

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

		bbg.setColor(Color.LIGHT_GRAY);
		bbg.fillRect(0, 0, _0_Constants.WINDOW_WIDTH, _0_Constants.WINDOW_HEIGHT);
		double[] posVector = f(absT);
		for (int i = 0; i < 100; i++) {
			bbg.setColor(Color.BLUE);
			bbg.fillOval((int) f(2 * Math.PI * i / 100)[0] + 25, (int) f(2 * Math.PI * i / 100)[1] + 15, 4, 4);
		}

		bbg.setColor(Color.RED);
		bbg.fillOval((int) posVector[0], (int) posVector[1], 50, 30);
		g.drawImage(backBuffer, 0, 0, null);
	}

	double[] f(double t) {
		double[] result = new double[2];
		result[0] = 400 + 100 * Math.cos(t);
		result[1] = 200 + 100 * Math.sin(t);
		return result;
	}

}
