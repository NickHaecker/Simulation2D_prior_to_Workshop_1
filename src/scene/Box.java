package scene;

import java.awt.Graphics;

import app.Constants;

public class Box extends GameObject {
	public double width;
	public double height;

	@Override
	public void update(double dt) {
		super.update(dt);

		if (positionX + width >= Constants.WINDOW_WIDTH || positionX <= 0) {
			velocityX *= -1;
		}

		if (positionY + height >= Constants.WINDOW_HEIGHT || positionY <= 0) {
			velocityY *= -1;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect((int) positionX, (int) positionY, (int) width, (int) height);
	}
}
