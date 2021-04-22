package InventoryTrackingSytem;

import java.awt.Color;
import java.awt.Graphics;

public class Package extends WindowObject{

	public Package(int x, int y, ID id) {
		super(x, y, id);
		
		//velX = 0;
	}
	
	public void tick() {
		
		//x += velX;
		//y += velY;
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.orange);
		g.fillRect((int)x + 34, (int)y + 34, 32, 32);
	}
}
