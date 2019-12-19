package scene;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

public class GameObject {

	public GameObject() {
		children = new ArrayList<>();
	}

	public double positionX;
	public double positionY;
	public double rotation;

	public ArrayList<GameObject> children;
	public Color color;

	// Physics
	public double velocityX;
	public double velocityY;
	public double velotityRotation;

	public void AddGameObject(GameObject go) {
		children.add(go);
	}

	public LinkedList<GameObject> FlattenScreneTree() {
		LinkedList<GameObject> ll = new LinkedList<>();
		ll.add(this);
		for (GameObject go : children)
			ll.addAll(go.FlattenScreneTree());
		return ll;
	}

	public void update(double dt) {
		positionX += velocityX * dt;
		positionY += velocityY * dt;
		rotation += velotityRotation * dt;

		if (children != null)
			for (GameObject go : children)
				go.update(dt);
	}

	public void draw(Graphics g) {
		if (children != null)
			for (GameObject go : children)
				go.draw(g);
	}
}
