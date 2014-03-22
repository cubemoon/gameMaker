/**
 * View class for displaying event and action panel
 */

package gameMaker.view;

import gameMaker.main.GameMaker;
import gameMaker.view.ControlPanelView.AddAdapter;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class EventActionView {

	public JPanel getEventsPanel() {
		return eventsPanel;
	}

	public void setEventsPanel(JPanel eventsPanel) {
		this.eventsPanel = eventsPanel;
	}

	public JLabel getEventsLabel() {
		return eventsLabel;
	}

	public void setEventsLabel(JLabel eventsLabel) {
		this.eventsLabel = eventsLabel;
	}

	public JLabel getLblAssignAKey() {
		return lblAssignAKey;
	}

	public void setLblAssignAKey(JLabel lblAssignAKey) {
		this.lblAssignAKey = lblAssignAKey;
	}

	public JLabel getLblSelectActions() {
		return lblSelectActions;
	}

	public void setLblSelectActions(JLabel lblSelectActions) {
		this.lblSelectActions = lblSelectActions;
	}

	public JButton getBtnAssociate() {
		return btnAssociate;
	}

	public void setBtnAssociate(JButton btnAssociate) {
		this.btnAssociate = btnAssociate;
	}

	public JTextField getKeyField() {
		return keyField;
	}

	public void setKeyField(JTextField keyField) {
		this.keyField = keyField;
	}

	public JComboBox getEventFieldComboBox() {
		return eventFieldComboBox;
	}

	public void setEventFieldComboBox(JComboBox eventFieldComboBox) {
		this.eventFieldComboBox = eventFieldComboBox;
	}

	public JComboBox getActionComboBox() {
		return actionComboBox;
	}

	public void setActionComboBox(JComboBox actionComboBox) {
		this.actionComboBox = actionComboBox;
	}

	public JButton getBtnRemove() {
		return btnRemove;
	}

	public void setBtnRemove(JButton btnRemove) {
		this.btnRemove = btnRemove;
	}

	private JPanel eventsPanel;
	private JLabel eventsLabel;
	private JLabel lblAssignAKey;
	private JLabel lblSelectActions;
	private JButton btnAssociate;
	private JTextField keyField;
	private JComboBox eventFieldComboBox;
	private JComboBox actionComboBox;
	private JButton btnRemove;
	private GameMaker gameMaker;

	public EventActionView(GameMaker gameMaker) {
		this.gameMaker = gameMaker;
	}

	public void CreateEventActionView() {

		eventsPanel = new JPanel();
		eventsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		eventsPanel.setLayout(new GridLayout(4, 2, 15, 15));
		eventsLabel = new JLabel("Select Events");
		eventsPanel.add(eventsLabel);

		String[] events = { "Automove", "keypress", "collision", "mouse move" };
		eventFieldComboBox = new JComboBox(events);
		eventsPanel.add(eventFieldComboBox);
		lblAssignAKey = new JLabel("Assign a Key");
		eventsPanel.add(lblAssignAKey);

		keyField = new JTextField();
		eventsPanel.add(keyField);
		keyField.setColumns(10);

		lblSelectActions = new JLabel("Select Actions");
		eventsPanel.add(lblSelectActions);

		String[] actions = { "bounce", "disappear", "Move", "MoveBottom",
				"sound", "MoveTop", "MoveLeft", "MoveRight", "MoveNorthEast",
				"MoveSouthEast", "MoveSouthWest", "MoveNorthWest" };
		actionComboBox = new JComboBox(actions);
		eventsPanel.add(actionComboBox);

		btnAssociate = new JButton("Associate");
		btnAssociate.addActionListener(new AssociateEventAdapter());
		eventsPanel.add(btnAssociate);

		btnRemove = new JButton("Remove");
		eventsPanel.add(btnRemove);

		gameMaker.getLeftPanel().add(eventsPanel);

	}

	class AssociateEventAdapter implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {

			gameMaker.getGameMakerController().addEventList(gameMaker);
		}

	}
}
