/**
 * Main view class
 */

package gameMaker.main;

import gameMaker.controller.GameMakerController;
import gameMaker.model.Sprite;
import gameMaker.view.ControlPanelView;
import gameMaker.view.EventActionView;
import gameMaker.view.GamePanelView;
import gameMaker.view.SpritePanelView;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.awt.GridLayout;
import java.util.ArrayList;

public class GameMaker extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final Logger logger = Logger.getLogger(GameMaker.class);
	private JPanel contentPanel;
	private JPanel leftPanel;
	private JLayeredPane layeredPane;
	private SpritePanelView spritePanelView;
	private EventActionView eventActionView;
	private ControlPanelView controlPanelView;
	private GamePanelView gamePanelView;
	private GameMakerController gameMakerController;
	private int index;
	private int x;

	private ArrayList<Sprite> AutomoveList;
	private ArrayList<Sprite> CollisionList;

	public ArrayList<Sprite> getCollisionList() {
		return CollisionList;
	}

	public void setCollisionList(ArrayList<Sprite> collisionList) {
		CollisionList = collisionList;
	}

	public ArrayList<Sprite> getAutomoveList() {
		return AutomoveList;
	}

	public void setAutomoveList(ArrayList<Sprite> automoveList) {
		AutomoveList = automoveList;
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

	private int y;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public GamePanelView getGamePanelView() {
		return gamePanelView;
	}

	public void setGamePanelView(GamePanelView gamePanelView) {
		this.gamePanelView = gamePanelView;
	}

	public GameMakerController getGameMakerController() {
		return gameMakerController;
	}

	public void setGameMakerController(GameMakerController gameMakerController) {
		this.gameMakerController = gameMakerController;
	}

	public SpritePanelView getSpritePanelView() {
		return spritePanelView;
	}

	public void setSpritePanelView(SpritePanelView spritePanelView) {
		this.spritePanelView = spritePanelView;
	}

	public EventActionView getEventActionView() {
		return eventActionView;
	}

	public void setEventActionView(EventActionView eventActionView) {
		this.eventActionView = eventActionView;
	}

	public ControlPanelView getControlPanelView() {
		return controlPanelView;
	}

	public void setControlPanelView(ControlPanelView controlPanelView) {
		this.controlPanelView = controlPanelView;
	}

	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}

	public void setLayeredPane(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public void setContentPanel(JPanel contentPanel) {
		this.contentPanel = contentPanel;
	}

	public JPanel getLeftPanel() {
		return leftPanel;
	}

	public void setLeftPanel(JPanel leftPanel) {
		this.leftPanel = leftPanel;
	}

	public GameMaker() {
		/*
		 * have used arraylists to store sprites
		 */

		AutomoveList = new ArrayList<Sprite>();
		CollisionList = new ArrayList<Sprite>();

		gameMakerController = new GameMakerController(this);
		setTitle("Game Maker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 661);

		// Add content panel
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));

		// Add layered pane to Content Panel
		layeredPane = new JLayeredPane();
		contentPanel.add(layeredPane);
		layeredPane.setLayout(new GridLayout(0, 2, 0, 0));

		// Add left Panel for GameMaker Menu
		leftPanel = new JPanel();
		layeredPane.add(leftPanel);
		leftPanel.setLayout(new GridLayout(0, 1, 0, 0));

		// Add Sprite Panel to Left Panel
		spritePanelView = new SpritePanelView(this);
		spritePanelView.CreateSpritePanelView();
		// leftPanel.add();

		// Add Event Panel to Left Panel
		eventActionView = new EventActionView(this);
		eventActionView.CreateEventActionView();
		// leftPanel.add(eventActionView.CreateEventActionView());

		// Add Control Panel to leftPanel
		controlPanelView = new ControlPanelView(this);
		controlPanelView.createControlPanelView();
		

		// Add Game Panel to layered Pane

		gamePanelView = new GamePanelView(this);
		layeredPane.add(gamePanelView.CreateGamePanel());

	}

	public static void main(String args[]) {
		GameMaker board = new GameMaker();
		board.setVisible(true);
		PropertyConfigurator.configure("config/log4j.properties");
		logger.debug("Enter main method");
	}

}
