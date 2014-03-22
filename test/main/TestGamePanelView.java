/**
 * 
 */
package main;

import gameMaker.main.GameMaker;
import gameMaker.view.GamePanelView;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestGamePanelView extends TestCase {

	/**
	 * @throws java.lang.Exception
	 */
	private GamePanelView obj;
	public TestGamePanelView(String args) {
		super(args);
		GameMaker gameMaker = new GameMaker();
		obj = new GamePanelView(gameMaker);
		

	}
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link gameMaker.view.GamePanelView#CreateGamePanel()}.
	 */
	@Test
	public void testCreateGamePanel() {
		assertNotNull(obj.CreateGamePanel());
		
	}

}
