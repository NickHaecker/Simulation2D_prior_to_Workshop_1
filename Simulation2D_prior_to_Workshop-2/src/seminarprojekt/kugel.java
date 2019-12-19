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
	private double rest;

	public kugel(double xPosition, double yPosition, double Radius, double Speed, Color Farbe, double Resti) {
		x = xPosition;
		y = yPosition;
		radius = Radius;
		speed = Speed;
		c = Farbe;
		masse = ((4 / 3) * (this.getRadius() * this.getRadius() * this.getRadius()) * Math.PI);
		rest = Resti;
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

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void move() {

		if (this.x <= 0) {
			this.x = 0;

			this.speed *= -Math.round(this.getRest());

		} else if ((this.x >= konstanten.WINDOW_WIDTH - (2 * this.radius))) {

			this.speed *= -Math.round(this.getRest());
		}
	}

	public void zeichne(Graphics g) {
		this.move();
		x = Math.round(this.getX()) + Math.round(this.getSpeed());
		g.setColor(c);
		g.fillOval((int) Math.round(x), (int) (Math.round(y)), (int) Math.round(radius) * 2,
				(int) Math.round(radius) * 2);

	}

	public double getRest() {
		return rest;
	}

	public void setRest(double rest) {
		this.rest = rest;
	}

	public void zeichneSchwerpunkt(Graphics g, kugel b) {
		g.setColor(Color.BLACK);
		g.fillOval((int) (((this.x * this.radius) + ((b.getX() * b.getRadius()))) / (this.radius + b.getRadius())), 295,
				10, 10);
	}

	public boolean collides(kugel o) {

		boolean collision = false;
		if (Math.sqrt((o.getX() - this.x) * (o.getX() - this.x)) <= (this.radius + o.getRadius())) {
			collision = true;
		}

		return collision;
	}
}
