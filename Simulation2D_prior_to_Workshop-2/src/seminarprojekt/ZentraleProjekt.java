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

	double epsilon = 1;

	kugel eins = new kugel(750, 300, 35, 2, Color.YELLOW, epsilon, 5);
	kugel zwei = new kugel(400, 300, 25, -1, Color.RED, epsilon, 2);
	kugel drei = new kugel(50, 300, 30, 1, Color.WHITE, epsilon, 3);

	bodenschiene boden = new bodenschiene(1, 300, konstanten.WINDOW_WIDTH, 300, Color.GREEN);

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

				v1 = ((drei.getMasse() * drei.getSpeed()) + (zwei.getMasse() * zwei.getSpeed())
						+ ((epsilon * zwei.getMasse()) * (zwei.getSpeed() - drei.getSpeed())))
						/ (drei.getMasse() + zwei.getMasse());

				v2 = ((drei.getMasse() * drei.getSpeed()) + (zwei.getMasse() * zwei.getSpeed())
						- ((epsilon * drei.getMasse()) * (zwei.getSpeed() - drei.getSpeed())))
						/ (drei.getMasse() + zwei.getMasse());
				System.out.println("Geschwinidgkeit weiße Kugel : " + v1 + "px/s");
				drei.setSpeed(v1);
				System.out.println("Geschwinidgkeit rote Kugel : " + v2 + "px/s");
				zwei.setSpeed(v2);

			} else if (drei.getSpeed() >= 0 && zwei.getSpeed() <= 0) {

				v1 = ((drei.getMasse() * drei.getSpeed()) + (zwei.getMasse() * zwei.getSpeed())
						+ ((epsilon * zwei.getMasse()) * (zwei.getSpeed() - drei.getSpeed())))
						/ (drei.getMasse() + zwei.getMasse());
				v2 = ((drei.getMasse() * drei.getSpeed()) + (zwei.getMasse() * zwei.getSpeed())
						- ((epsilon * drei.getMasse()) * (zwei.getSpeed() - drei.getSpeed())))
						/ (drei.getMasse() + zwei.getMasse());

				System.out.println("Geschwinidgkeit weiße Kugel : " + v1 + "px/s");
				drei.setSpeed(v1);
				System.out.println("Geschwinidgkeit rote Kugel : " + v2 + "px/s");
				zwei.setSpeed(v2);
			} else {

				v1 = ((drei.getMasse() * drei.getSpeed()) + (zwei.getMasse() * zwei.getSpeed())
						+ ((epsilon * zwei.getMasse()) * (zwei.getSpeed() - drei.getSpeed())))
						/ (drei.getMasse() + zwei.getMasse());
				v2 = ((drei.getMasse() * drei.getSpeed()) + (zwei.getMasse() * zwei.getSpeed())
						- ((epsilon * drei.getMasse()) * (zwei.getSpeed() - drei.getSpeed())))
						/ (drei.getMasse() + zwei.getMasse());

				System.out.println("Geschwinidgkeit weiße Kugel : " + v1 + "px/s");
				drei.setSpeed(v1);
				System.out.println("Geschwinidgkeit rote Kugel : " + v2 + "px/s");
				zwei.setSpeed(v2);
			}
		}

		else if (zwei.collides(eins)) {
			if (zwei.getSpeed() >= 0 && eins.getSpeed() >= 0) {

				v1 = ((zwei.getMasse() * zwei.getSpeed()) + (eins.getMasse() * eins.getSpeed())
						+ ((epsilon * eins.getMasse()) * (eins.getSpeed() - zwei.getSpeed())))
						/ (zwei.getMasse() + eins.getMasse());
				v2 = ((zwei.getMasse() * zwei.getSpeed()) + (eins.getMasse() * eins.getSpeed())
						- ((epsilon * zwei.getMasse()) * (eins.getSpeed() - zwei.getSpeed())))
						/ (zwei.getMasse() + eins.getMasse());

				System.out.println("Geschwinidgkeit rote Kugel : " + v1 + "px/s");
				zwei.setSpeed(v1);
				System.out.println("Geschwinidgkeit gelbe Kugel : " + v2 + "px/s");
				eins.setSpeed(v2);
			} else if (zwei.getSpeed() >= 0 && eins.getSpeed() <= 0) {

				v1 = ((zwei.getMasse() * zwei.getSpeed()) + (eins.getMasse() * eins.getSpeed())
						+ ((epsilon * eins.getMasse()) * (eins.getSpeed() - zwei.getSpeed())))
						/ (zwei.getMasse() + eins.getMasse());
				v2 = ((zwei.getMasse() * zwei.getSpeed()) + (eins.getMasse() * eins.getSpeed())
						- ((epsilon * zwei.getMasse()) * (eins.getSpeed() - zwei.getSpeed())))
						/ (zwei.getMasse() + eins.getMasse());

				System.out.println("Geschwinidgkeit rote Kugel: " + v1 + "px/s");
				zwei.setSpeed(v1);
				System.out.println("Geschwinidgkeit gelbe Kugel: " + v2 + "px/s");
				eins.setSpeed(v2);
			} else {

				v1 = ((zwei.getMasse() * zwei.getSpeed()) + (eins.getMasse() * eins.getSpeed())
						+ ((epsilon * eins.getMasse()) * (eins.getSpeed() - zwei.getSpeed())))
						/ (zwei.getMasse() + eins.getMasse());
				v2 = ((zwei.getMasse() * zwei.getSpeed()) + (eins.getMasse() * eins.getSpeed())
						- ((epsilon * zwei.getMasse()) * (eins.getSpeed() - zwei.getSpeed())))
						/ (zwei.getMasse() + eins.getMasse());

				System.out.println("Geschwinidgkeit rote Kugel : " + v1 + "px/s");
				zwei.setSpeed(v1);
				System.out.println("Geschwinidgkeit gelbe Kugel: " + v2 + "px/s");
				eins.setSpeed(v2);
			}
		}

		bbg.drawImage(backBuffer, 0, 0, null);
	}
}