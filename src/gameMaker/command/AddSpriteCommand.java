/**
 * Command class for adding sprites to game panel
 */

package gameMaker.command;

import java.util.HashMap;

import gameMaker.model.GameMakerBean;
import gameMaker.model.Sprite;
import gameMaker.actions.EventAction;

public class AddSpriteCommand implements Command {

	private Sprite sprite;
	private GameMakerBean gameMakerBean;
	private HashMap<String, EventAction> EventActionMap;

	public AddSpriteCommand(GameMakerBean gameMakerBean) {
		this.gameMakerBean = gameMakerBean;
		this.sprite = gameMakerBean.getSprite();
		//System.out.println(sprite);

	}

	public GameMakerBean getGameMakerBean() {
		return gameMakerBean;
	}

	public void setGameMakerBean(GameMakerBean gameMakerBean) {
		this.gameMakerBean = gameMakerBean;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	@Override
	public void execute() {

		gameMakerBean.addToSpriteList(sprite);

	}

	@Override
	public void undo() {

	}

}
