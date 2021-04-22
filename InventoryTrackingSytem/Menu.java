package InventoryTrackingSytem;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import InventoryTrackingSytem.InventoryTrackingSystem.STATE;

public class Menu extends MouseAdapter{

	public static int fntSize2 = 46;
	public static int fntSize3 = 24;
	public static int buttonTrigger = 0;
	public static int slots =  0;
	public static int boxSelected = -1; //location of box that is located

	public static int count3 = 1;

	static Handler handler;
	public static boolean filled[];
	public static String label[];
	public static String tempName;

	@SuppressWarnings("static-access")
	public Menu(InventoryTrackingSystem its, Handler handler) {
		this.handler = handler;
		filled = new boolean[16];
		label = new String[16];

	}

	public void mousePressed(MouseEvent e) {
		int mX = e.getX();
		int mY = e.getY();

		if (InventoryTrackingSystem.itsSTATE == STATE.Menu) {

			if (mouseOver(mX, mY, 700, 150, 100, 100)) action0();
			if (mouseOver(mX, mY, 800, 150, 100, 100)) action1();
			if (mouseOver(mX, mY, 900, 150, 100, 100)) action2();
			if (mouseOver(mX, mY, 1000, 150, 100, 100)) action3();
			if (mouseOver(mX, mY, 700, 250, 100, 100)) action4();
			if (mouseOver(mX, mY, 800, 250, 100, 100)) action5();
			if (mouseOver(mX, mY, 900, 250, 100, 100)) action6();
			if (mouseOver(mX, mY, 1000, 250, 100, 100)) action7();
			if (mouseOver(mX, mY, 700, 400, 100, 100)) action8();
			if (mouseOver(mX, mY, 800, 400, 100, 100)) action9();
			if (mouseOver(mX, mY, 900, 400, 100, 100)) action10();
			if (mouseOver(mX, mY, 1000, 400, 100, 100)) action11();
			if (mouseOver(mX, mY, 700, 500, 100, 100)) action12();
			if (mouseOver(mX, mY, 800, 500, 100, 100)) action13();
			if (mouseOver(mX, mY, 900, 500, 100, 100)) action14();
			if (mouseOver(mX, mY, 1000, 500, 100, 100)) action15();

			//Create Item Button
			if (mouseOver(mX, mY, 65, 215, 185, 40)) {
				System.out.println("Mouse Event: Create Button Clicked");
				buttonTrigger = 3;

				if (boxSelected != -1) {
					if (filled[boxSelected] == false) {
						filled[boxSelected] = true;
						System.out.println("Item Created Successfully");
						slots += 1;
						count3 += 1;
					}
				}
				else if (boxSelected == -1){
					for (int i = 0; i < filled.length; i++) {
						if (filled[i] == false) {
							filled[i] = true;
							
							if (i == 0) {
								if (count3 < 10) label[0] = "No. #01-01-0" + count3;
								else label[0] = "No. #01-01-" + count3;
								tempName = label[0];
							}
							if (i == 1) {
								if (count3 < 10) label[1] = "No. #01-02-0" + count3;
								else label[1] = "No. #01-02-" + count3;
								tempName = label[1];
							}
							if (i == 2) {
								if (count3 < 10) label[2] = "No. #01-03-0" + count3;
								else label[2] = "No. #01-03-" + count3;
								tempName = label[2];
							}
							if (i == 3) {
								if (count3 < 10) label[3] = "No. #01-04-0" + count3;
								else label[3] = "No. #01-04-" + count3;
								tempName = label[3];
							}
							if (i == 4) {
								if (count3 < 10) label[4] = "No. #02-01-0" + count3;
								else label[4] = "No. #02-01-" + count3;
								tempName = label[4];
							}
							if (i == 5) {
								if (count3 < 10) label[5] = "No. #02-02-0" + count3;
								else label[5] = "No. #02-02-" + count3;
								tempName = label[5];
							}
							if (i == 6) {
								if (count3 < 10) label[6] = "No. #02-03-0" + count3;
								else label[6] = "No. #02-03-" + count3;
								tempName = label[6];
							}
							if (i == 7) {
								if (count3 < 10) label[7] = "No. #02-04-0" + count3;
								else label[7] = "No. #02-04-" + count3;
								tempName = label[7];
							}
							if (i == 8) {
								if (count3 < 10) label[8] = "No. #03-01-0" + count3;
								else label[8] = "No. #03-01-" + count3;
								tempName = label[8];
							}
							if (i == 9) {
								if (count3 < 10) label[9] = "No. #03-02-0" + count3;
								else label[9] = "No. #03-02-" + count3;
								tempName = label[9];
							}
							if (i == 10) {
								if (count3 < 10) label[10] = "No. #03-03-0" + count3;
								else label[10] = "No. #03-03-" + count3;
								tempName = label[10];
							}
							if (i == 11) {
								if (count3 < 10) label[11] = "No. #03-04-0" + count3;
								else label[11] = "No. #03-04-" + count3;
								tempName = label[11];
							}
							if (i == 12) {
								if (count3 < 10) label[12] = "No. #04-01-0" + count3;
								else label[12] = "No. #04-01-" + count3;
								tempName = label[12];
							}
							if (i == 13) {
								if (count3 < 10) label[13] = "No. #04-02-0" + count3;
								else label[13] = "No. #04-02-" + count3;
								tempName = label[13];
							}
							if (i == 14) {
								if (count3 < 10) label[14] = "No. #04-03-0" + count3;
								else label[14] = "No. #04-03-" + count3;
								tempName = label[14];
							}
							if (i == 15) {
								if (count3 < 10) label[15] = "No. #04-04-0" + count3;
								else label[15] = "No. #04-04-" + count3;
								tempName = label[15];
							}
							i = filled.length;
							slots += 1;
							count3 += 1;
						}
					}
				}
			}

			//Remove Item Button
			if (mouseOver(mX, mY, 65, 460, 300, 40)) {
				System.out.println("Mouse Event: Remove Button Clicked");
				buttonTrigger = 4;

				if (boxSelected != -1) {
					if (filled[boxSelected] == true) {
						filled[boxSelected] = false;
						System.out.println("Item Removed Successfully");
						slots -= 1;
						label[boxSelected] = null;
						tempName = label[boxSelected];
					}
				}
			}

			//Help Button
			if (mouseOver(mX, mY, 65, 510, 100, 40)) {
				buttonTrigger = 5;
				System.out.println("Mouse Event: Help Button Clicked - Switched States to Help");
				InventoryTrackingSystem.itsSTATE = STATE.Help;
			}

			//Quit Button
			if (mouseOver(mX, mY, 65, 560, 100, 40)) {
				System.out.println("Mouse Event: Quit Button Clicked - Switched States to Terminate");
				System.exit(1);
			}
		}

		else if (InventoryTrackingSystem.itsSTATE == STATE.Help) {

			//Back Button
			if (mouseOver(mX, mY, 65, 510, 100, 40)) {
				buttonTrigger = 5;
				System.out.println("Mouse Event: Back Button Clicked - Switched States to Menu");
				InventoryTrackingSystem.itsSTATE = STATE.Menu;
			}

			//Quit Button
			if (mouseOver(mX, mY, 65, 560, 100, 40)) {
				System.out.println("Mouse Event: Quit Button Clicked - Switched States to Terminate");
				System.exit(1);
			}

		}
	}

	public void action0() {
		System.out.println("Mouse Event: A1 - Clicked");
		if (boxSelected == 0) boxSelected = -1;
		else if (boxSelected != 0 )boxSelected = 0;
		if (filled[0] == true) tempName = label[0];
		else if (filled[0] == false) {
			if (count3 < 10) label[0] = "No. #01-01-0" + count3;
			else label[0] = "No. #01-01-" + count3;
			tempName = label[0];
		}
	}
	public void action1() {
		System.out.println("Mouse Event: A2 - Clicked");
		if (boxSelected == 1) boxSelected = -1;
		else boxSelected = 1;
		if (filled[1] == true) tempName = label[1];
		else if (filled[1] == false){
			if (count3 < 10) label[1] = "No. #01-02-0" + count3;
			else label[1] = "No. #01-02-" + count3;
			tempName = label[1];
		}
	}			
	public void action2() {
		System.out.println("Mouse Event: A3 - Clicked");
		if (boxSelected == 2) boxSelected = -1;
		else boxSelected = 2;
		if (filled[2] == true) tempName = label[2];
		else if (filled[2] == false) {
			if (count3 < 10) label[2] = "No. #01-03-0" + count3;
			else label[2] = "No. #01-03-" + count3;
			tempName = label[2];
		}
	}
	public void action3() {
		System.out.println("Mouse Event: A4 - Clicked");
		if (boxSelected == 3) boxSelected = -1;
		else boxSelected = 3;
		if (filled[3] == true) tempName = label[3];
		else if (filled[3] == false) {
			if (count3 < 10) label[3] = "No. #01-04-0" + count3;
			else label[3] = "No. #01-04-" + count3;
			tempName = label[3];
		}
	}
	public void action4() {
		System.out.println("Mouse Event: B1 - Clicked");
		if (boxSelected == 4) boxSelected = -1;
		else boxSelected = 4;
		if (filled[4] == true) tempName = label[4];
		else if (filled[4] == false) {
			if (count3 < 10) label[4] = "No. #02-01-0" + count3;
			else label[4] = "No. #02-01-" + count3;
			tempName = label[4];
		}
	}
	public void action5() {
		System.out.println("Mouse Event: B2 - Clicked");
		if (boxSelected == 5) boxSelected = -1;
		else boxSelected = 5;
		if (filled[5] == true) tempName = label[5];
		else if (filled[5] == false) {
			if (count3 < 10) label[5] = "No. #02-02-0" + count3;
			else label[5] = "No. #02-02-" + count3;
			tempName = label[5];
		}
	}
	public void action6() {
		if (boxSelected == 6) boxSelected = -1;
		else boxSelected = 6;
		if (filled[6] == true) tempName = label[6];
		else if (filled[6] == false) {
			if (count3 < 10) label[6] = "No. #02-03-0" + count3;
			else label[6] = "No. #02-03-" + count3;
			tempName = label[6];
		}
	}
	public void action7() {
		System.out.println("Mouse Event: B4 - Clicked");
		if (boxSelected == 7) boxSelected = -1;
		else boxSelected = 7;
		if (filled[7] == true) tempName = label[7];
		else if (filled[7] == false) {
			if (count3 < 10) label[7] = "No. #02-04-0" + count3;
			else label[7] = "No. #02-04-" + count3;
			tempName = label[7];
		}
	}
	public void action8() {
		System.out.println("Mouse Event: C1 - Clicked");
		if (boxSelected == 8) boxSelected = -1;
		else boxSelected = 8;
		if (filled[8] == true) tempName = label[8];
		else if (filled[8] == false) {
			if (count3 < 10) label[8] = "No. #03-01-0" + count3;
			else label[8] = "No. #03-01-" + count3;
			tempName = label[8];
		}
	}
	public void action9() {
		System.out.println("Mouse Event: C2 - Clicked");
		if (boxSelected == 9) boxSelected = -1;
		else boxSelected = 9;
		if (filled[9] == true) tempName = label[9];
		else if (filled[9] == false) {
			if (count3 < 10) label[9] = "No. #03-02-0" + count3;
			else label[9] = "No. #03-02-" + count3;
			tempName = label[9];
		}
	}
	public void action10() {
		System.out.println("Mouse Event: C3 - Clicked");
		if (boxSelected == 10) boxSelected = -1;
		else boxSelected = 10;
		if (filled[10] == true) tempName = label[10];
		else if (filled[10] == false) {
			if (count3 < 10) label[10] = "No. #03-03-0" + count3;
			else label[10] = "No. #03-03-" + count3;
			tempName = label[10];
		}
	}
	public void action11() {
		System.out.println("Mouse Event: C4 - Clicked");
		if (boxSelected == 11) boxSelected = -1;
		else boxSelected = 11;
		if (filled[11] == true) tempName = label[11];
		else if (filled[11] == false) {
			if (count3 < 11) label[11] = "No. #03-04-0" + count3;
			else label[11] = "No. #03-04-" + count3;
			tempName = label[11];
		}
	}
	public void action12() {
		System.out.println("Mouse Event: D1 - Clicked");
		if (boxSelected == 12) boxSelected = -1;
		else boxSelected = 12;
		if (filled[12] == true) tempName = label[12];
		else if (filled[12] == false) {
			if (count3 < 10) label[12] = "No. #04-01-0" + count3;
			else label[12] = "No. #04-01-" + count3;
			tempName = label[12];
		}
	}
	public void action13() {
		System.out.println("Mouse Event: D2 - Clicked");
		if (boxSelected == 13) boxSelected = -1;
		else boxSelected = 13;
		if (filled[13] == true) tempName = label[13];
		else if (filled[13] == false) {
			if (count3 < 10) label[13] = "No. #04-02-0" + count3;
			else label[13] = "No. #04-02-" + count3;
			tempName = label[13];
		}
	}
	public void action14() {
		System.out.println("Mouse Event: D3 - Clicked");
		if (boxSelected == 14) boxSelected = -1;
		else boxSelected = 14;
		if (filled[14] == true) tempName = label[14];
		else if (filled[14] == false) {
			if (count3 < 10) label[14] = "No. #04-03-0" + count3;
			else label[14] = "No. #04-03-" + count3;
			tempName = label[14];
		}
	}
	public void action15() {
		System.out.println("Mouse Event: D4 - Clicked");
		if (boxSelected == 15) boxSelected = -1;
		else boxSelected = 15;
		if (filled[15] == true) tempName = label[15];
		else if (filled[15] == false) {
			if (count3 < 10) label[15] = "No. #04-04-0" + count3;
			else label[15] = "No. #04-04-" + count3;
			tempName = label[15];
		}
	}
	/*------------------------------------------------------------------------------------------------------*/


	public void mouseReleased(MouseEvent e) {

	}

	private boolean mouseOver(int mX, int mY, int x, int y, int width, int height) {
		if (mX > x && mX < x + width) {
			if (mY > y && mY < y + height) {
				return true;
			}
			else return false;
		}
		else return false;
	}

	public void tick() {

	}

	public void render(Graphics g) {

		if (InventoryTrackingSystem.itsSTATE == STATE.Menu)	{

			handler.addObject(new Table(700, 150, ID.Table)); //Table 1
			handler.addObject(new Table(700, 400, ID.Table)); //Table 2
			handler.addObject(new MainMenu(0, 0, ID.MainMenu)); //Menu/Command List

		}
		else if (InventoryTrackingSystem.itsSTATE == STATE.Help) {
			handler.addObject(new HelpMenu(0, 0, ID.HelpMenu));
		}

	}


}




