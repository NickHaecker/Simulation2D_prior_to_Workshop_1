package seminarprojekt;

import java.awt.Color;
import java.awt.Graphics;

public class kugel {

	private double x;
	private double y;
	private double radius;
	private double speed;
	private Color c;
	private double masse;
	private double epsilon;

	public kugel(double xPosition, double yPosition, double Radius, double Speed, Color Farbe, double Epsilon,
			double Masse) {
		x = xPosition;
		y = yPosition;
		radius = Radius;
		speed = Speed;
		c = Farbe;
		masse = Masse;
		epsilon = Epsilon;
	}

	public double getMasse() {
		return masse;
	}

	public void setMasse(double masse) {
		this.masse = masse;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public double getEpsilon() {
		return epsilon;
	}

	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void move() {

		if ((this.getX() - this.getRadius()) <= (0)) {
			this.x += 1;

			this.speed *= -1;
			System.out.println("Geschwindigkeit der Kugel " + this.getC() + " bei x("
					+ (konstanten.WINDOW_WIDTH - konstanten.WINDOW_WIDTH) + "): " + this.speed + "px/s");

		} else if ((this.getX() + this.getRadius()) >= (konstanten.WINDOW_WIDTH)) {

			this.x += -1;

			this.speed *= -1;
			System.out.println("Geschwindigkeit der Kugel " + this.getC() + " bei x(" + konstanten.WINDOW_WIDTH + "): "
					+ this.speed + "px/s");
		}
	}

	public void zeichne(Graphics g) {
		this.move();
		x = this.x + this.speed;
		g.setColor(c);
		Math.round(this.x);
		g.fillOval((int) (this.getX() - this.getRadius()), (int) (this.getY() - this.getRadius()),
				(int) this.getRadius() * 2, (int) this.getRadius() * 2);

	}

	public void zeichneSchwerpunkt(Graphics g, kugel b) {
		g.setColor(Color.BLACK);
		Math.round(this.x);
		Math.round(b.getX());
		g.fillOval((int) ((((this.getX() - 5) * this.getMasse()) + (((b.getX() - 5) * b.getMasse())))
				/ (this.getMasse() + b.getMasse())), 295, 10, 10);
	}

	public boolean collides(kugel o) {

		boolean collision = false;
		if (Math.sqrt(
				((o.getX()) - (this.getX())) * ((o.getX()) - (this.getX()))) <= (this.getRadius() + o.getRadius())) {
			collision = true;
		}

		return collision;
	}
}
