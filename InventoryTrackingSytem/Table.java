package InventoryTrackingSytem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Table extends WindowObject{

	private int fntSize1 = 20;

	public Table(int x, int y, ID id) {
		super(x, y, id);

	}

	public void tick() {

	}

	public void render(Graphics g) {

		g.setColor(Color.gray);
		g.fillRect(x, y, 404, 204);

		g.setColor(Color.BLACK);

		Font fnt1 = new Font("arial", 1, fntSize1);
		g.setFont(fnt1);

		//TEXT
		g.drawString("1", x+45, y-5);
		g.drawString("2", x+145, y-5);
		g.drawString("3", x+245, y-5);
		g.drawString("4", x+345, y-5);
		if (y == 150) {
			g.drawString("A", x-30, y+60);
			g.drawString("B", x-30, y+160);
		}
		else if (y == 400){
			g.drawString("C", x-30, y+60);
			g.drawString("D", x-30, y+160);
		}


		//ROWS		
		g.fillRect(x, y+000, 400, 4);
		g.fillRect(x, y+100, 400, 4);
		g.fillRect(x, y+200, 400, 4);


		//COLUMNS
		g.fillRect(x+000, y, 4, 200);
		g.fillRect(x+100, y, 4, 200);
		g.fillRect(x+200, y, 4, 200);
		g.fillRect(x+300, y, 4, 200);
		g.fillRect(x+400, y, 4, 204);

	}

}
