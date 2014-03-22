/**
 * Author: Mayank Gupta
 * 
 * Move to the bottom of panel
 */
package gameMaker.actions;

import javax.swing.JLabel;

import gameMaker.interfaces.Actions;
import gameMaker.model.Constants;
import gameMaker.model.Sprite;

public class MoveBottom implements Actions {

	private Sprite model;
	

	public MoveBottom(Sprite model) {
		this.model = model;
	}

	public Sprite actionPerformed() {
		JLabel spritePicLabel = model.getSpritePicLabel();
		model.setY(model.getY() + Constants.MOVE_INDEX);
		spritePicLabel.setBounds(model.getX(), model.getY(), model.getWidth(),
				model.getHeight());
		model.setSpritePicLabel(spritePicLabel);
		return model;
	}

}
