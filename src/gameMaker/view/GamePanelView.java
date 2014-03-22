/**
 * view class for displaying game board.
 */

package gameMaker.view;

import gameMaker.actions.MoveBottom;
import gameMaker.controller.GameMakerController;
import gameMaker.events.Keyboard;
import gameMaker.interfaces.Actions;
import gameMaker.main.GameMaker;
import gameMaker.model.Constants;
import gameMaker.model.GameMakerBean;
import gameMaker.model.Sprite;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import gameMaker.actions.*;

public class GamePanelView {

	private JPanel gamePanel;
	private GameMaker gameMaker;
	private ArrayList<Sprite> spriteList;
	private GameMakerBean gameMakerBean;
	private GameMakerController gameMakerController;
	private Sprite sprite;

	public GameMakerController getGameMakerController() {
		return gameMakerController;
	}

	public void setGameMakerController(GameMakerController gameMakerController) {
		this.gameMakerController = gameMakerController;
	}

	public GamePanelView(GameMaker gameMaker) {
		this.gameMaker = gameMaker;
		this.gameMakerController = gameMaker.getGameMakerController();
	}

	public GameMakerBean getGameMakerBean() {
		return gameMakerBean;
	}

	public void setGameMakerBean(GameMakerBean gameMakerBean) {
		this.gameMakerBean = gameMakerBean;
	}

	public ArrayList<Sprite> getSpriteList() {
		return spriteList;
	}

	public void setSpriteList(ArrayList<Sprite> spriteList) {
		this.spriteList = spriteList;
	}

	public JPanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(JPanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	public JPanel CreateGamePanel() {

		gamePanel = new JPanel();
		gamePanel.addMouseListener(new MouseListenerAdapter());
		gamePanel.setBackground(Color.LIGHT_GRAY);
		gamePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		gamePanel.setLayout(null);

		JLabel spriteLabel;
		/*
		 * spriteLabel = new JLabel("Enter Sprite Name");
		 * spriteLabel.setBounds(50, 100, 10, 10); gamePanel.add(spriteLabel);
		 */
		return gamePanel;

	}

	class MouseListenerAdapter implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			//System.out.println("clicked");
			
			GameMaker.logger.debug("clicked");
			
			int index = 0;
			int x = e.getX();
			int y = e.getY();
			//System.out.println("x:" + x + " y:" + y);
			GameMaker.logger.debug("x:" + x + " y:" + y);
			index = GamePanelView.this.getGameMakerController()
					.getSelectedSprite(x, y);
			//System.out.println("index in gamemaker:" + index);
			
			GameMaker.logger.debug("index in gamemaker:" + index);
			
			GamePanelView.this.gameMaker.setIndex(index);

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public class KeyListenerAdapter implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {

			sprite = gameMaker.getGameMakerController().getGameMakerBean()
					.getSprite();
			char key = e.getKeyChar();
			Actions action;
			JLabel spritePicLabel;

			for (Keyboard keyboard : sprite.getKeyBoardEventList()) {
				if (keyboard.getKey() == key) {
					Sprite sprite = new Sprite();
					sprite = gameMaker.getGameMakerController()
							.getGameMakerBean().getSprite();

					String actionName = keyboard.getAction();
					action = this.getInstance(actionName);

					//what does this do??
					sprite = action.actionPerformed();

					spritePicLabel = sprite.getSpritePicLabel();

					sprite.setSpritePicLabel(spritePicLabel);

				}
			}

		}

		public Actions getInstance(String actionName) {
			Actions action = null;
			if (actionName.equals(Constants.MOVE_BOTTOM)) {
				MoveBottom moveBottom = new MoveBottom(sprite);
				action = moveBottom;
			} else if (actionName.equals(Constants.MOVE_TOP)) {
				MoveTop moveTop = new MoveTop(sprite);
				action = moveTop;
			} else if (actionName.equals(Constants.MOVE_LEFT)) {
				MoveLeft moveLeft = new MoveLeft(sprite);
				action = moveLeft;
			} else if (actionName.equals(Constants.MOVE_RIGHT)) {
				MoveRight moveRight = new MoveRight(sprite);
				action = moveRight;
			} else if (actionName.equals(Constants.MOVE_NORTH_EAST)) {
				MoveNorthEast moveNorthEast = new MoveNorthEast(sprite);
				action = moveNorthEast;
			} else if (actionName.equals(Constants.MOVE_NORTH_EAST)) {
				MoveNorthEast moveNorthEast = new MoveNorthEast(sprite);
				action = moveNorthEast;
			} else if (actionName.equals(Constants.MOVE_SOUTH_EAST)) {
				MoveSouthEast moveSouthEast = new MoveSouthEast(sprite);
				action = moveSouthEast;
			} else if (actionName.equals(Constants.MOVE_NORTH_WEST)) {
				MoveNorthWest moveNorthWest = new MoveNorthWest(sprite);
				action = moveNorthWest;
			} else if (actionName.equals(Constants.MOVE_SOUTH_WEST)) {
				MoveSouthWest moveSouthWest = new MoveSouthWest(sprite);
				action = moveSouthWest;
			}

			return action;
		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}

}
