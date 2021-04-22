package InventoryTrackingSytem;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	@SuppressWarnings("unused")
	private Handler handler;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		
		/*
		
		for(int i = 0; i < handler.object.size(); i++) {
			WindowObject tempObject = handler.object.get(i);

			if(tempObject.getId() == ID.Package) {
				//key events for player

				if(key == KeyEvent.VK_W) tempObject.setVelY(tempObject.getVelY()-5);
			}
		}
		*/

		if (key == KeyEvent.VK_SPACE) 
			System.out.println("Space Key Pressed");
 
		if (key == KeyEvent.VK_ESCAPE) {
			System.out.println("Escaped Key Pressed - Program Terminated");
			System.exit(1);
		}
	}

	public void keyReleased(KeyEvent e){

	}
}
