package gameMaker.command;

public interface Command {
	/*
	 * Executes update method of a component
	 */
	public void execute();

	/*
	 * Reverts the changes made in the execute method of a component
	 */
	public void undo();

}
