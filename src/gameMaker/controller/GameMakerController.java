/**
 * Controller class responsible for dispatching requests from view to model 
 */

package gameMaker.controller;

/*
 * have used hashmaps to store event action pairs
 */

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gameMaker.actions.EventAction;
import gameMaker.command.AddEventActionCommand;
import gameMaker.command.AddSpriteCommand;
import gameMaker.command.Invoker;
import gameMaker.command.RemoveSpriteCommand;
import gameMaker.main.GameMaker;
import gameMaker.model.Constants;
import gameMaker.model.GameMakerBean;
import gameMaker.model.Sprite;

public class GameMakerController {

	private Invoker invoker;
	private AddSpriteCommand addSpriteCommand;
	private RemoveSpriteCommand removeSpriteCommand;
	private GameMaker gameMaker;
	private GameMakerBean gameMakerBean;
	private ArrayList<Sprite> spriteList;

	private String EventString;
	private String ActionString;
	private EventAction eventAction;
	private char ActionKey;
	private int s;
	private HashMap<String, EventAction> EventActionMap;
	private JLabel spritePicLabel;
	private Sprite sprite;

	public JLabel getSpritePicLabel() {
		return spritePicLabel;
	}

	public void setSpritePicLabel(JLabel spritePicLabel) {
		this.spritePicLabel = spritePicLabel;
	}

	public GameMakerController(GameMaker gameMaker) {
		this.gameMaker = gameMaker;
		invoker = new Invoker();
		gameMakerBean = new GameMakerBean();
		EventActionMap = new HashMap<String, EventAction>();
		s = 0;

	}

	public String getActionString() {
		return ActionString;
	}

	public void setActionString(String actionString) {
		ActionString = actionString;
	}

	public GameMakerBean getGameMakerBean() {
		return gameMakerBean;
	}

	public void setGameMakerBean(GameMakerBean gameMakerBean) {
		this.gameMakerBean = gameMakerBean;
	}

	public Invoker getInvoker() {
		return invoker;
	}

	public void setInvoker(Invoker invoker) {
		this.invoker = invoker;
	}

	public void addSprite(GameMaker gameMaker) {

		sprite = gameMakerBean.constructSprite(gameMaker.getSpritePanelView());
		addSpriteCommand = new AddSpriteCommand(gameMakerBean);
		invoker.setCommand(addSpriteCommand);
		invoker.invoke();
		invoker.AddToCommnadHistory();
		updateGamePanel();

	}

	public void updateGamePanel() {

		JLabel spritePicLabel = gameMaker.getGameMakerController()
				.getGameMakerBean().getSprite().getSpritePicLabel();

		// refresh panel
		gameMaker.getGamePanelView().getGamePanel().add(spritePicLabel);
		gameMaker.getGamePanelView().getGamePanel().revalidate();
		gameMaker.getGamePanelView().getGamePanel().repaint();

	}

	public void removeSprite(GameMaker gameMaker) {
		removeSpriteCommand = new RemoveSpriteCommand(gameMakerBean);
		removeSpriteCommand.clicked(s);
		invoker.setCommand(removeSpriteCommand);
		invoker.invoke();
		invoker.RemoveFromCommnadHistory();
	}

	public int getSelectedSprite(int x, int y) {

		spriteList = gameMakerBean.getSpriteList();
		//System.out.println("from selected:" + spriteList);

		Iterator<Sprite> SpriteIterator = spriteList.iterator();
		Sprite sprite;
		int index = 0;
		int count = 0;
		while (SpriteIterator.hasNext()) {

			sprite = SpriteIterator.next();
			count++;

			if (x >= sprite.getX() && x <= (sprite.getX() + sprite.getWidth())
					&& y >= sprite.getY()
					&& y <= (sprite.getY() + sprite.getHeight())) {
				index = count;
			}

		}
		//System.out.println("index:" + index);
		s = index;
		//System.out.println(s);

		return index - 1;
	}

	public void addEventList(GameMaker gameMaker) {

		EventString = gameMaker.getEventActionView().getEventFieldComboBox()
				.getSelectedItem().toString();
		ActionString = gameMaker.getEventActionView().getActionComboBox()
				.getSelectedItem().toString();
		ActionKey = gameMaker.getEventActionView().getKeyField().getText()
				.charAt(Constants.ZERO_INDEX);

		int spriteIndex = gameMaker.getIndex();

		AddEventActionCommand addEventActionCommand = new AddEventActionCommand(
				gameMakerBean, EventString, ActionString, ActionKey,
				spriteIndex);

		invoker.setCommand(addEventActionCommand);
		invoker.invoke();
		invoker.AddToCommnadHistory();
	}

	public void createGame(GameMaker gameMaker) {

		gameMaker.getGameMakerController().getGameMakerBean()
				.createGame(gameMaker);

	}

	public void startGame(GameMaker gameMaker) {

		gameMaker.getGameMakerController().getGameMakerBean()
				.startGame(gameMaker);

	}

}
