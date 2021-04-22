package InventoryTrackingSytem;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList <WindowObject> object = new LinkedList <WindowObject>(); //We don't know how many objects we'll have so a LinkList is best

	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			WindowObject tempObject = object.get(i); //LinkList command
			tempObject.tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			WindowObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}

	public void addObject(WindowObject object) { //adds an object
		this.object.add(object); 
	}

	public void removeObject(WindowObject object) { //removes an object
		this.object.remove(object);
	}

	public void clearElements() {
		for (int i = 0; i < object.size(); i++) {
			WindowObject obj = object.get(i);
			if (obj.getId() == ID.Select || obj.getId() == ID.Table )//|| obj.getId() == ID.HelpMenu) 
			{
				object.clear();
				/*
				if (InventoryTrackingSystem.itsSTATE == InventoryTrackingSystem.STATE.Menu)
				{
					addObject(new Package((int)obj.getX(), (int)obj.getY(), ID.Package)); //returns package to original spot
				}
				*/
			}
		}
	}
}
