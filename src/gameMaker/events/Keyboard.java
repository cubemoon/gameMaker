/**
 * Author: Mayank Gupta
 * 
 * Class to handle all the keyboard events
 */

package gameMaker.events;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import gameMaker.actions.*;
import gameMaker.interfaces.Actions;

import gameMaker.main.GameMaker;
import gameMaker.model.Sprite;

public class Keyboard {

	private final String MOVE_BOTTOM = "MoveBottom";
	private final String MOVE_TOP = "MoveTop";
	private final String MOVE_LEFT = "MoveLeft";
	private final String MOVE_RIGHT = "MoveRIGHT";
	private final String MOVE_NORTH_EAST = "MoveNorthEast";
	private final String MOVE_SOUTH_EAST = "MoveSouthEast";
	private final String MOVE_NORTH_WEST = "MoveNorthWest";
	private final String MOVE_SOUTH_WEST = "MoveSouthWest";

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	private Sprite model;
	private GameMaker gameMaker;
	private char key;
	private String action;

	public char getKey() {
		return key;
	}

	public void setKey(char key) {
		this.key = key;
	}

}
