package scene;

import java.awt.Graphics;

import app.Constants;

public class Circle extends GameObject {

	public double radius;

	@Override
	public void update(double dt) {
		super.update(dt);

		if (positionX + radius >= Constants.WINDOW_WIDTH || positionX <= 0) {
			velocityX *= -1;
		}

		if (positionY + radius >= Constants.WINDOW_HEIGHT || positionY <= 0) {
			velocityY *= -1;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval((int) positionX, (int) positionY, (int) radius, (int) radius);
	}

}
