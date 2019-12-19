package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import scene.Circle;
import scene.GameObject;

public class JumpingBallsBackBuffertest extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isRunning;
	private double counter = 5000;
	private int ObjectListSize = 15;
	private BufferedImage backBuffer;
	protected GameObject object;

	public JumpingBallsBackBuffertest() {
		object = new GameObject();
		isRunning = true;
		setTitle("Verwaltung mehrerer Objekte vom gleichen Typ");
		setSize(_0_Constants.WINDOW_WIDTH, _0_Constants.WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		backBuffer = new BufferedImage(_0_Constants.WINDOW_WIDTH, _0_Constants.WINDOW_HEIGHT,
				BufferedImage.TYPE_INT_RGB);
	}

	public void run() {

		Time.DeltaTime = 1000.0 * (double) _0_Constants.TPF; // Time per Frame in ms
		while (isRunning) {

			object.update(Time.DeltaTime);
			draw(Time.DeltaTime);

			Time.TimeSinceStart += Time.DeltaTime;
			try {
				Thread.sleep((long) Time.DeltaTime);
			} catch (Exception e) {
			}
		}

		setVisible(false);
	}

	void draw(double absT) {
		Graphics g = getGraphics();
		Graphics bbg = backBuffer.getGraphics();

		bbg.setColor(Color.LIGHT_GRAY);
		bbg.fillRect(0, 0, _0_Constants.WINDOW_WIDTH, _0_Constants.WINDOW_HEIGHT);

		for (int i = 0; i < ObjectListSize; i++) {
			if (object.children.size() <= ObjectListSize) {
				Circle circle = new Circle();
				circle.color = Color.RED;
				circle.diameter = 36;
				circle.positionX = (int) (Math.random() * ((_0_Constants.WINDOW_WIDTH - circle.diameter)));
				circle.positionY = (int) (Math.random() * ((_0_Constants.WINDOW_HEIGHT - circle.diameter)));
				circle.velocityY = 0.4;
				object.AddGameObject(circle);

			}
		}

		if (Time.TimeSinceStart >= counter && object.children.size() >= 1) {
			object.children.remove((int) (Math.random() * ((object.children.size())) + 0));
			ObjectListSize = ObjectListSize + 0;
			counter = counter + (5 * 1000);
			System.out.println(Time.TimeSinceStart);
			System.out.println(object.children.size());
		}

		object.draw(bbg);
		g.drawImage(backBuffer, 0, 0, null);
	}

}
