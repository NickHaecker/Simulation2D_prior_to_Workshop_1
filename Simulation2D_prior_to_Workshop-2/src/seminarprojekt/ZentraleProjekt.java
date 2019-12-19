package seminarprojekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import scene.GameObject;

public class ZentraleProjekt extends JFrame {

	private static final long serialVersionUID = 1L;
	private BufferedImage backBuffer;
	protected GameObject object;

	public ZentraleProjekt() {
		setTitle("Programmier Mathe Projekt");
		setSize(konstanten.WINDOW_WIDTH, konstanten.WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		backBuffer = new BufferedImage(konstanten.WINDOW_WIDTH, konstanten.WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);
	}

	public static void main(String[] args) {

		ZentraleProjekt testObjekt = new ZentraleProjekt();

		testObjekt.setVisible(true);
		double absT = 0;
		while (true) {
			testObjekt.draw(absT);
			try {
				Thread.sleep((int) (konstanten.TPF * 1000));
				absT += konstanten.TPF;
			} catch (InterruptedException e) {
			}
		}

	}

	double rest = 0.8;

	kugel eins = new kugel(700, 265, 35, 3, Color.YELLOW, rest);
	kugel zwei = new kugel(400, 275, 25, 1, Color.RED, rest);
	kugel drei = new kugel(100, 270, 30, -2, Color.WHITE, rest);

	bodenschiene boden = new bodenschiene(1, 300, 800, 300, Color.GREEN);

	void draw(double absT) {

		Graphics g = getGraphics();
		Graphics bbg = backBuffer.getGraphics();

		g.setColor(Color.GRAY);
		g.fillRect(0, 0, konstanten.WINDOW_WIDTH, konstanten.WINDOW_HEIGHT);

		boden.zeichnebodenschiene(g);

		eins.zeichne(g);
		zwei.zeichne(g);
		drei.zeichne(g);
		eins.zeichneSchwerpunkt(g, zwei);

		drei.zeichneSchwerpunkt(g, zwei);

		double v1, v2;

		if (drei.collides(zwei)) {
			if (drei.getSpeed() >= 0 && zwei.getSpeed() >= 0) {

				v1 = ((drei.getMasse() * drei.getSpeed()) + zwei.getMasse() * zwei.getSpeed()
						+ ((rest * zwei.getMasse()) * (zwei.getSpeed() - drei.getSpeed())))
						/ (drei.getMasse() + zwei.getMasse());
				v2 = ((drei.getMasse() * drei.getSpeed()) + zwei.getMasse() * zwei.getSpeed()
						- ((rest * drei.getMasse()) * (zwei.getSpeed() - drei.getSpeed())))
						/ (drei.getMasse() + zwei.getMasse());
				drei.setSpeed(Math.round(v1));
				zwei.setSpeed(Math.round(v2));

			} else if (drei.getSpeed() >= 0 && zwei.getSpeed() <= 0) {

				v1 = ((drei.getMasse() * drei.getSpeed()) + zwei.getMasse() * zwei.getSpeed()
						+ ((rest * zwei.getMasse()) * (zwei.getSpeed() - drei.getSpeed())))
						/ (drei.getMasse() + zwei.getMasse());
				v2 = ((drei.getMasse() * drei.getSpeed()) + zwei.getMasse() * zwei.getSpeed()
						- ((rest * drei.getMasse()) * (zwei.getSpeed() - drei.getSpeed())))
						/ (drei.getMasse() + zwei.getMasse());

				drei.setSpeed(Math.round(v1));
				zwei.setSpeed(Math.round(v2));
			} else {

				v1 = ((drei.getMasse() * drei.getSpeed()) + zwei.getMasse() * zwei.getSpeed()
						+ ((rest * zwei.getMasse()) * (zwei.getSpeed() - drei.getSpeed())))
						/ (drei.getMasse() + zwei.getMasse());
				v2 = ((drei.getMasse() * drei.getSpeed()) + zwei.getMasse() * zwei.getSpeed()
						- ((rest * drei.getMasse()) * (zwei.getSpeed() - drei.getSpeed())))
						/ (drei.getMasse() + zwei.getMasse());

				drei.setSpeed(Math.round(v1));
				zwei.setSpeed(Math.round(v2));
			}
		}

		else if (zwei.collides(eins)) {
			if (zwei.getSpeed() >= 0 && eins.getSpeed() >= 0) {

				v1 = ((zwei.getMasse() * zwei.getSpeed()) + (eins.getMasse() * eins.getSpeed())
						+ ((rest * eins.getMasse()) * (eins.getSpeed() - zwei.getSpeed())))
						/ (zwei.getMasse() + eins.getMasse());
				v2 = ((zwei.getMasse() * zwei.getSpeed()) + (eins.getMasse() * eins.getSpeed())
						- ((rest * zwei.getMasse()) * (eins.getSpeed() - zwei.getSpeed())))
						/ (zwei.getMasse() + eins.getMasse());

				zwei.setSpeed(Math.round(v1));
				eins.setSpeed(Math.round(v2));
			} else if (zwei.getSpeed() >= 0 && eins.getSpeed() <= 0) {

				v1 = ((zwei.getMasse() * zwei.getSpeed()) + (eins.getMasse() * eins.getSpeed())
						+ ((rest * eins.getMasse()) * (eins.getSpeed() - zwei.getSpeed())))
						/ (zwei.getMasse() + eins.getMasse());
				v2 = ((zwei.getMasse() * zwei.getSpeed()) + (eins.getMasse() * eins.getSpeed())
						- ((rest * zwei.getMasse()) * (eins.getSpeed() - zwei.getSpeed())))
						/ (zwei.getMasse() + eins.getMasse());

				zwei.setSpeed(Math.round(v1));
				eins.setSpeed(Math.round(v2));
			} else {

				v1 = ((zwei.getMasse() * zwei.getSpeed()) + (eins.getMasse() * eins.getSpeed())
						+ ((rest * eins.getMasse()) * (eins.getSpeed() - zwei.getSpeed())))
						/ (zwei.getMasse() + eins.getMasse());
				v2 = ((zwei.getMasse() * zwei.getSpeed()) + (eins.getMasse() * eins.getSpeed())
						- ((rest * zwei.getMasse()) * (eins.getSpeed() - zwei.getSpeed())))
						/ (zwei.getMasse() + eins.getMasse());

				zwei.setSpeed(Math.round(v1));
				eins.setSpeed(Math.round(v2));
			}
		}

		bbg.drawImage(backBuffer, 0, 0, null);
	}
}