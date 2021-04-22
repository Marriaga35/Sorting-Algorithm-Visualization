package InventoryTrackingSytem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class MainMenu extends WindowObject{

	String location = "";
	public static String name;

	public MainMenu(int x, int y, ID id) {
		super(x, y, id);

		name = Menu.tempName;
		if (Menu.boxSelected == -1) name = "";
		
		if (Menu.boxSelected == 0) location = "A - 1";
		if (Menu.boxSelected == 1) location = "A - 2";
		if (Menu.boxSelected == 2) location = "A - 3";
		if (Menu.boxSelected == 3) location = "A - 4";

		if (Menu.boxSelected == 4) location = "B - 1";
		if (Menu.boxSelected == 5) location = "B - 2";
		if (Menu.boxSelected == 6) location = "B - 3";
		if (Menu.boxSelected == 7) location = "B - 4";

		if (Menu.boxSelected == 8) location = "C - 1";
		if (Menu.boxSelected == 9) location = "C - 2";
		if (Menu.boxSelected == 10) location = "C - 3";
		if (Menu.boxSelected == 11) location = "C - 4";

		if (Menu.boxSelected == 12) location = "D - 1";
		if (Menu.boxSelected == 13) location = "D - 2";
		if (Menu.boxSelected == 14) location = "D - 3";
		if (Menu.boxSelected == 15) location = "D - 4";

	}
	public void tick() {

	}

	public void render(Graphics g) {

		Font fnt2 = new Font("arial", 1, Menu.fntSize2);
		Font fnt3 = new Font("arial", 1, Menu.fntSize3);

		g.setFont(fnt2);
		g.setColor(Color.black);

		g.drawString("MENU/COMMAND LIST:", 65, 80); //(text, x, y)

		g.setFont(fnt3);

		g.drawString("AUTO-LABEL", 73, 143);
		g.drawRect(300, 115, 54, 40); //(x, y, width, height)
		g.drawString("ON", 308, 143);

		g.drawString("AUTO-STORE", 73, 193);
		g.drawRect(300, 165, 54, 40);
		g.drawString("ON", 308, 193);

		g.drawRect(65, 215, 185, 40);
		g.drawString("CREATE ITEM", 73, 243);

		g.drawString("ITEM NAME: " + name, 73, 388);

		//g.drawRect(65, 410, 210, 40);
		g.drawString("LOCATION: " + location, 73, 438);

		g.drawRect(65, 460, 185, 40);
		g.drawString("REMOVE ITEM", 73, 488);

		g.drawRect(65, 510, 100, 40);
		g.drawString("HELP", 73, 538);

		g.drawRect(65, 560, 100, 40);
		g.drawString("QUIT", 73, 588);

		if (Menu.buttonTrigger != 0) {
			if (Menu.buttonTrigger == 3) {
				g.fillRect(65, 215, 185, 40);
				Menu.buttonTrigger = 0;
			}
			if (Menu.buttonTrigger == 4) {
				g.fillRect(65, 460, 185, 40);
				Menu.buttonTrigger = 0;
			}
			if (Menu.buttonTrigger == 5) {
				g.fillRect(65, 510, 100, 40);
				Menu.buttonTrigger = 0;
			}
		}

		g.drawString("FULL SLOTS: " + Menu.slots + " of 16", 700, 100);

		//ROW 1 - SLOT FULL
		if (Menu.filled[0] == true) Menu.handler.addObject(new Package(700, 150, ID.Package));
		if (Menu.filled[1] == true) Menu.handler.addObject(new Package(800, 150, ID.Package));
		if (Menu.filled[2] == true) Menu.handler.addObject(new Package(900, 150, ID.Package));
		if (Menu.filled[3] == true) Menu.handler.addObject(new Package(1000, 150, ID.Package));

		//ROW 2 - SLOT FULL
		if (Menu.filled[4] == true) Menu.handler.addObject(new Package(700, 250, ID.Package));
		if (Menu.filled[5] == true) Menu.handler.addObject(new Package(800, 250, ID.Package));
		if (Menu.filled[6] == true) Menu.handler.addObject(new Package(900, 250, ID.Package));
		if (Menu.filled[7] == true) Menu.handler.addObject(new Package(1000, 250, ID.Package));

		//ROW 3 - SLOT FULL
		if (Menu.filled[8] == true) Menu.handler.addObject(new Package(700, 400, ID.Package));
		if (Menu.filled[9] == true) Menu.handler.addObject(new Package(800, 400, ID.Package));
		if (Menu.filled[10] == true) Menu.handler.addObject(new Package(900, 400, ID.Package));
		if (Menu.filled[11] == true) Menu.handler.addObject(new Package(1000, 400, ID.Package));

		//ROW 4 - SLOT FULL
		if (Menu.filled[12] == true) Menu.handler.addObject(new Package(700, 500, ID.Package));
		if (Menu.filled[13] == true) Menu.handler.addObject(new Package(800, 500, ID.Package));
		if (Menu.filled[14] == true) Menu.handler.addObject(new Package(900, 500, ID.Package));
		if (Menu.filled[15] == true) Menu.handler.addObject(new Package(1000, 500, ID.Package));

		//ROW 1 - Selection Highlight
		if (Menu.boxSelected == 0) Menu.handler.addObject(new Select(700, 150, ID.Select));
		if (Menu.boxSelected == 1) Menu.handler.addObject(new Select(800, 150, ID.Select));
		if (Menu.boxSelected == 2) Menu.handler.addObject(new Select(900, 150, ID.Select));
		if (Menu.boxSelected == 3) Menu.handler.addObject(new Select(1000, 150, ID.Select));

		//ROW 2 - Selection Highlight
		if (Menu.boxSelected == 4) Menu.handler.addObject(new Select(700, 250, ID.Select));
		if (Menu.boxSelected == 5) Menu.handler.addObject(new Select(800, 250, ID.Select));
		if (Menu.boxSelected == 6) Menu.handler.addObject(new Select(900, 250, ID.Select));
		if (Menu.boxSelected == 7) Menu.handler.addObject(new Select(1000, 250, ID.Select));

		//ROW 3 - Selection Highlight
		if (Menu.boxSelected == 8) Menu.handler.addObject(new Select(700, 400, ID.Select));
		if (Menu.boxSelected == 9) Menu.handler.addObject(new Select(800, 400, ID.Select));
		if (Menu.boxSelected == 10) Menu.handler.addObject(new Select(900, 400, ID.Select));
		if (Menu.boxSelected == 11) Menu.handler.addObject(new Select(1000, 400, ID.Select));

		//ROW 4 - Selection Highlight
		if (Menu.boxSelected == 12) Menu.handler.addObject(new Select(700, 500, ID.Select));
		if (Menu.boxSelected == 13) Menu.handler.addObject(new Select(800, 500, ID.Select));
		if (Menu.boxSelected == 14) Menu.handler.addObject(new Select(900, 500, ID.Select));
		if (Menu.boxSelected == 15) Menu.handler.addObject(new Select(1000, 500, ID.Select));

	}
}