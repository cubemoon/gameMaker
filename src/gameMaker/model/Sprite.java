/**
 * Author: Pankaj Channe.
 * Bean for holding sprite object parameters.  
 */

package gameMaker.model;

import gameMaker.actions.EventAction;
import gameMaker.events.Keyboard;

import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JLabel;

public class Sprite {
	public LinkedList<Keyboard> getKeyBoardEventList() {
		return keyBoardEventList;
	}

	public void setKeyBoardEventList(LinkedList<Keyboard> keyBoardEventList) {
		this.keyBoardEventList = keyBoardEventList;
	}

	public JLabel getSpritePicLabel() {
		return spritePicLabel;
	}

	public void setSpritePicLabel(JLabel spritePicLabel) {
		this.spritePicLabel = spritePicLabel;
	}

	private String name;
	private int x;
	private int y;
	private int xSpeed;
	private int ySpeed;
	private int height;
	private int width;
	private String imagePath;
	private JLabel spritePicLabel;
	private HashMap<String, EventAction> EventActionMap = new HashMap<String, EventAction>();
	private LinkedList<Keyboard> keyBoardEventList = new LinkedList<Keyboard>();

	public int getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	public int getySpeed() {
		return ySpeed;
	}

	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}

	public HashMap<String, EventAction> getEventActionMap() {
		return EventActionMap;
	}

	public void setEventActionMap(HashMap<String, EventAction> eventActionMap) {
		EventActionMap = eventActionMap;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
