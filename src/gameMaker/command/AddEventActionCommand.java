/**
 * Command class for adding events and actions to sprites 
 */

package gameMaker.command;

import java.util.HashMap;

import gameMaker.actions.EventAction;
import gameMaker.model.GameMakerBean;
import gameMaker.model.Sprite;

public class AddEventActionCommand implements Command {

	private GameMakerBean gameMakerBean;
	private Sprite sprite;
	// private HashMap<String,EventAction>EventActionMap;
	private String EventString;
	private String ActionString;
	private char ActionKey;
	private int index;

	public AddEventActionCommand(GameMakerBean gameMakerBean,
			String EventString, String ActionString, char ActionKey, int index) {
		this.gameMakerBean = gameMakerBean;
		this.sprite = gameMakerBean.getSprite();
		this.EventString = EventString;
		this.ActionString = ActionString;
		this.ActionKey = ActionKey;
		this.index = index;
	}

	public GameMakerBean getGameMakerBean() {
		return gameMakerBean;
	}

	public void setGameMakerBean(GameMakerBean gameMakerBean) {
		this.gameMakerBean = gameMakerBean;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		gameMakerBean.addToEventlist(EventString, ActionString, ActionKey,
				index);
	}

	@Override
	public void undo() {
		

	}

}
