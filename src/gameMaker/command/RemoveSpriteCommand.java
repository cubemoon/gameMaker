/**
 * Command class for removing sprites from game
 */
package gameMaker.command;

import gameMaker.main.GameMaker;
import gameMaker.model.GameMakerBean;

public class RemoveSpriteCommand implements Command {

	private GameMakerBean gameMakerBean;
	private int spriteIndex;

	public RemoveSpriteCommand(GameMakerBean gameMakerBean) {
		//
		this.gameMakerBean = gameMakerBean;
		// this.spriteIndex = index;
	}

	@Override
	public void execute() {
	
		gameMakerBean.removeFromSpriteList(spriteIndex);

	}

	@Override
	public void undo() {

	}

	public void clicked(int index) {
		this.spriteIndex = index;
		System.out.println(index);
	}

}
