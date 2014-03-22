/**
 * Author: Pankaj Channe
 * 
 * Action class for move
 */

package gameMaker.actions;

import gameMaker.interfaces.Actions;
import gameMaker.model.Sprite;

public class Move implements Actions {

	public void ActionPerformed(Sprite sprite) {
		sprite.setX(sprite.getX() + sprite.getxSpeed());
		sprite.setY(sprite.getX() + sprite.getxSpeed());
	}

	@Override
	public Sprite actionPerformed() {
		return null;
		// TODO Auto-generated method stub

	}
}
