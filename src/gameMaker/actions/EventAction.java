/**
 * Author: Pankaj Channe
 * 
 * Maintain a list of events and actions
 */

package gameMaker.actions;

public class EventAction {
	private String ActionString;
	private char ActionKey;

	public EventAction(String ActionString, char ActionKey) {

		this.ActionString = ActionString;
		this.ActionKey = ActionKey;
	}
	
	/**
	 * 
	 * 
	 * @return
	 */

	public String getActionString() {
		return ActionString;
	}

	public void setActionString(String actionString) {
		ActionString = actionString;
	}

	public char getActionKey() {
		return ActionKey;
	}

	public void setActionKey(char actionKey) {
		ActionKey = actionKey;
	}

}
