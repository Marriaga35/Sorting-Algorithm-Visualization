package InventoryTrackingSytem;

import java.awt.Color;
import java.awt.Graphics;

public class Select extends WindowObject{

	public Select(int x, int y, ID id) {
		super(x, y, id);

	}

	public void tick() {

	}

	public void render(Graphics g) {

		g.setColor(Color.black);
		g.fillRect((int)x, (int)y, 100, 100);

		for (int i = 0; i < Menu.filled.length; i++) {
			if (Menu.filled[i] == true && Menu.boxSelected == i) {
				g.setColor(Color.yellow);
				g.fillRect((int)x + 34, (int)y + 34, 32, 32);
			}
		}

	}
}

