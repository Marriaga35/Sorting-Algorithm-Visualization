package InventoryTrackingSytem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HelpMenu extends WindowObject{


	public HelpMenu(int x, int y, ID id) {
		super(x, y, id);		
	}

	public void tick() {

	}

	public void render(Graphics g) {

		Font fnt2 = new Font("arial", 1, Menu.fntSize2);
		Font fnt3 = new Font("arial", 1, Menu.fntSize3);

		g.setFont(fnt2);
		g.setColor(Color.black);
		g.drawString("HELP MENU", 65, 144);

		g.setFont(fnt3);
		g.drawString("There are currently several functions.", 65, 200);
		g.drawString("Below is an explanation of each function:", 65, 230);
		g.fillRect(82, 258, 6, 6);
		g.drawString("Auto-Label: Automatically creates a Label within the system for packages.", 95, 270);
		g.fillRect(82, 298, 6, 6);
		g.drawString("Auto-Store: Automatically assigns a package a storage location.", 95, 310);
		g.fillRect(82, 338, 6, 6);
		g.drawString("Create Item: Adds one Package into the system.", 95, 350);
		g.fillRect(82, 378, 6, 6);
		g.drawString("Remove Item: Removes one Package from the system by first clicking package.", 95, 390);
		g.fillRect(82, 418, 6, 6);
		g.drawString("ESC Key: Alternative Key Press to Terminate Program.", 95, 430);

		//Back/Quit Button
		g.drawRect(65, 510, 100, 40); //box2
		g.drawString("BACK", 73, 538);

		g.drawRect(65, 560, 100, 40); //box3
		g.drawString("QUIT", 73, 588);

	}

}



