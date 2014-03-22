/**
 * Action class for Rebound action
 */
package gameMaker.actions;

import java.util.ArrayList;

import gameMaker.main.GameMaker;
import gameMaker.model.Sprite;

public class Rebound {

	private GameMaker gameMaker;
	private ArrayList<Sprite> spriteList;

	public Rebound(GameMaker gameMaker) {
		this.gameMaker = gameMaker;
		this.spriteList = gameMaker.getGameMakerController().getGameMakerBean()
				.getSpriteList();
	}

	public void ActionPerformed(Sprite sprite) {

		for (Sprite obj : spriteList) {
		
			if (obj.getName() != sprite.getName()) {

				// Check if the model collides with the right end
				if (sprite.getX() >= gameMaker.getGamePanelView()
						.getGamePanel().getWidth()) {
					//System.out.println(gameMaker.getGamePanelView().getGamePanel().getWidth());
					sprite.setxSpeed(-1);

				}

				// Check if the model collides with the top end
				else if (sprite.getY() <= 0) {
					sprite.setySpeed(-1);
				}

				// Check if the model collides with the left end
				else if (sprite.getX() <= 0) {
					sprite.setxSpeed(-1);
				}

				else if (sprite.getX() >= obj.getX() - obj.getHeight()
						&& sprite.getX() <= obj.getX() + obj.getWidth()
						&& sprite.getY() >= obj.getY() - obj.getHeight()
						&& sprite.getY() <= obj.getY() + obj.getWidth()) {

					sprite.setySpeed(-1);

					
				}

			
				else if (sprite.getX() >= obj.getX()
						&& sprite.getX() <= obj.getX() + obj.getWidth()) {
					sprite.setySpeed(-1);

				}

				sprite.getImagePath();
				gameMaker
						.getGameMakerController()
						.getSpritePicLabel()
						.setBounds(sprite.getX(), sprite.getY(),
								sprite.getWidth(), sprite.getHeight());

			}

		}

	}
}
