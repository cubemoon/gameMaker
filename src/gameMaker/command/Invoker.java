/**
 * This class holds the command and asks the command to carry out request by calling
 * its execute method
 */

package gameMaker.command;

import java.util.ArrayList;
import java.util.LinkedList;

import gameMaker.command.Command;

public class Invoker {

	private Command cmd;
	private ArrayList<Command> commandHistory;

	public Invoker() {

		commandHistory = new ArrayList<Command>();
	}

	public ArrayList<Command> getCommandHistory() {
		return commandHistory;
	}

	public void setCommandHistory(ArrayList<Command> commandHistory) {
		this.commandHistory = commandHistory;
	}

	/*
	 * Setting the commond
	 */
	public void setCommand(Command cmd) {
		this.cmd = cmd;
	}

	/*
	 * Calling the execute method of the command set
	 */
	public void invoke() {
		cmd.execute();
	}

	/*
	 * Calling the undo method of the command set
	 */
	public void revoke() {
		cmd.undo();
	}

	public void AddToCommnadHistory() {
		System.out.println(this.cmd);
		commandHistory.add(this.cmd);
		System.out.println(commandHistory);
	}

	public void RemoveFromCommnadHistory() {

		commandHistory.remove(commandHistory.size());

	}

}
