/**
 * Author: Mayank Gupta
 * 
 * Move to the north west of the panel
 */
package gameMaker.actions;

import javax.swing.JLabel;

import gameMaker.interfaces.Actions;
import gameMaker.main.GameMaker;
import gameMaker.model.Constants;
import gameMaker.model.Sprite;

public class MoveNorthWest implements Actions {

	private Sprite model;
	private GameMaker gameMaker;

	public MoveNorthWest(Sprite model) {
		this.model = model;

	}

	@Override
	public Sprite actionPerformed() {
		JLabel spritePicLabel = model.getSpritePicLabel();
		model.setY(model.getY() - Constants.MOVE_INDEX);
		model.setX(model.getX() - Constants.MOVE_INDEX);
		spritePicLabel.setBounds(model.getX(), model.getY(), model.getWidth(),
				model.getHeight());
		model.setSpritePicLabel(spritePicLabel);
		return model;

	}
}
