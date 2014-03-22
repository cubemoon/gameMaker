/**
 * Model class which holds business logic for performing actions on model data
 */

package gameMaker.model;

/*
 * unnecessary print stmts commented and not removed
 * 
 * used array list spriteList
 */

import gameMaker.actions.EventAction;
import gameMaker.actions.Move;
import gameMaker.actions.Rebound;
import gameMaker.command.AddEventActionCommand;
import gameMaker.events.Keyboard;
import gameMaker.main.GameMaker;
import gameMaker.view.GamePanelView;
import gameMaker.view.SpritePanelView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameMakerBean {

	private ArrayList<Sprite> spriteList;
	private Sprite sprite;
	private GameMaker gameMaker;
	private Timer t;
	private ArrayList<Sprite> AutoMoveList;
	private ArrayList<Sprite> CollisionList;
	private JLabel spritePicLabel;

	public ArrayList<Sprite> getCollisionList() {
		return CollisionList;
	}

	public void setCollisionList(ArrayList<Sprite> collisionList) {
		CollisionList = collisionList;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public GameMakerBean() {
		spriteList = new ArrayList<Sprite>();
	}

	public ArrayList<Sprite> getSpriteList() {
		return spriteList;
	}

	public void setSpriteList(ArrayList<Sprite> spriteList) {
		spriteList = spriteList;
	}

	public void addToSpriteList(Sprite sprite) {
		spriteList.add(sprite);
		GameMaker.logger.debug(spriteList);
	}

	public void removeFromSpriteList(int index) {

		spriteList.remove(index);
		GameMaker.logger.debug("removefromspritelist"+spriteList);
	}

	public void addToEventlist(String EventString, String ActionString,
			char ActionKey, int index) {
		Sprite sprite = new Sprite();
		sprite = spriteList.get(index);
		
		GameMaker.logger.debug(index);
		GameMaker.logger.debug(ActionKey);
		
		Keyboard keyboard = new Keyboard();
		keyboard.setAction(ActionString);
		keyboard.setKey(ActionKey);

		EventAction eventAction = new EventAction(ActionString, ActionKey);

		//added
		System.out.println(spriteList.get(index));
		
		(spriteList.get(index)).getEventActionMap().put(EventString,
				eventAction);
		(spriteList.get(index)).getKeyBoardEventList().add(keyboard);
	}

	public Sprite constructSprite(SpritePanelView spritePanelView) {

		sprite = new Sprite();
		sprite.setHeight(Integer.parseInt(spritePanelView.getHeightField()
				.getText()));
		sprite.setWidth(Integer.parseInt(spritePanelView.getWidthField()
				.getText()));
		sprite.setImagePath(spritePanelView.getImageSprite().getName());
		sprite.setName(spritePanelView.getSpriteLabel().getText());
		sprite.setX(Integer.parseInt(spritePanelView.getXpositionField()
				.getText()));
		sprite.setY(Integer.parseInt(spritePanelView.getYpositioinField()
				.getText()));
		sprite.setxSpeed(Integer
				.parseInt(spritePanelView.getxSpeed().getText()));
		sprite.setySpeed(Integer
				.parseInt(spritePanelView.getySpeed().getText()));
		spritePicLabel = new JLabel();
		
		//get selected file
		File ImageFile = spritePanelView.getImageSprite().getSelectedFile();

		ImageIcon spriteImg = new ImageIcon(ImageFile.getPath());
		spritePicLabel.setIcon(spriteImg);
		spritePicLabel.setBounds(this.getSprite().getX(), this.getSprite()
				.getY(), this.getSprite().getWidth(), this.getSprite()
				.getHeight());
		sprite.setSpritePicLabel(spritePicLabel);
		this.setSprite(sprite);
		return sprite;
	}

	public void createGame(GameMaker gameMaker) {
		GameMaker.logger.debug("inside model create");
		
		this.gameMaker = gameMaker;
		for (Sprite obj : spriteList) {

			if (obj.getEventActionMap().containsKey("Automove")) {
				gameMaker.getAutomoveList().add(obj);
			}
			if (obj.getEventActionMap().containsKey("collision")) {
				gameMaker.getCollisionList().add(obj);
			}
			GameMaker.logger.debug(gameMaker.getAutomoveList());
		}
		

	}

	public void startGame(GameMaker gameMaker) {
		this.gameMaker = gameMaker;
		this.AutoMoveList = gameMaker.getAutomoveList();
		this.CollisionList = gameMaker.getCollisionList();

		gameMaker.getGamePanelView().getGamePanel().requestFocus();
		gameMaker.getGamePanelView().getGamePanel().setFocusable(true);
		JPanel gamePanel = gameMaker.getGamePanelView().getGamePanel();
		GamePanelView gamePanelView = gameMaker.getGamePanelView();
		gamePanel.addKeyListener(gamePanelView.new KeyListenerAdapter());
		t = new Timer(10, new TimerTaskListener());
		t.start();

	}

	class TimerTaskListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			for (Sprite obj : GameMakerBean.this.AutoMoveList) {

				if (((EventAction) obj.getEventActionMap().get("Automove"))
						.getActionString().equals("Move")) {

					Move move = new Move();
					move.ActionPerformed(obj);
					obj.getSpritePicLabel().setBounds(obj.getX(), obj.getY(),
							obj.getWidth(), obj.getHeight());

				}
			}

			for (Sprite obj : GameMakerBean.this.CollisionList) {

				if (((EventAction) obj.getEventActionMap().get("collision"))
						.getActionString().equals("bounce")) {

					Rebound rebound = new Rebound(GameMakerBean.this.gameMaker);
					rebound.ActionPerformed(obj);
					 if (obj.getX() >=
					 gameMaker.getGamePanelView().getGamePanel().getWidth())
					 {
					
					 obj.setxSpeed(-1);
					
					 }
					
					 else if (obj.getY() <= 0)
					 {
					 obj.setySpeed(-1);
					 }
					
					 // Check if the model collides with the left end
					 else if (obj.getX() <= 0)
					 {
					 obj.setxSpeed(-1);
					 }
					
					 // Check if the model collides with the bottom end
					 else if (obj.getY() >=
					 gameMaker.getGamePanelView().getGamePanel().getHeight())
					 {
					
					 obj.setySpeed(-1);
					 }
					 else if (obj.getX() >= obj.getX() - obj.getHeight()
					 && obj.getX() <= obj.getX() + obj.getWidth()
					 && obj.getY() >= obj.getY() - obj.getHeight()
					 && obj.getY() <= obj.getY() + obj.getWidth()) {
					
					 sprite.setySpeed(-1);
					
					 
					 }
					
					 obj.getImagePath();
					
					 obj.getSpritePicLabel().setBounds(obj.getX(), obj.getY(),
					 obj.getWidth(), obj.getHeight());
					
					
				}

			}

			GameMakerBean.this.gameMaker.getGameMakerController()
					.updateGamePanel();
		}

	}

}
