package main;

import static org.junit.Assert.assertEquals;

import javax.swing.JPanel;
import javax.swing.JTextField;

import gameMaker.main.GameMaker;
import gameMaker.view.SpritePanelView;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSpritePanelView extends TestCase {

	private SpritePanelView spritePanelView;

	public TestSpritePanelView(String args) {
		super(args);
		GameMaker gameMaker = new GameMaker();
		this.spritePanelView = new SpritePanelView(gameMaker);

	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetSpritePanel() {
		JPanel spritePanel = new JPanel();
		spritePanelView.setSpritePanel(spritePanel);
		assertEquals(spritePanelView.getSpritePanel(), spritePanel);
		
	}
	
	

}
