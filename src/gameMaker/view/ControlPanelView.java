/**
 * View class for displaying control button on view
 */
package gameMaker.view;

import gameMaker.main.GameMaker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ControlPanelView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel controlPanel;
	private JPanel innerControlPanel1;
	private JButton btnStart;
	private JButton btnUpdate;
	private JButton btnAddSprite;
	private JList list;
	private JPanel panel;
	private JPanel innerControlPanel2;
	private JButton btnSave;
	private JButton btnLoad;
	private JButton btnCreate;
	private GameMaker gameMaker;
	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public JPanel getControlPanel() {
		return controlPanel;
	}

	public void setControlPanel(JPanel controlPanel) {
		this.controlPanel = controlPanel;
	}

	public JPanel getInnerControlPanel1() {
		return innerControlPanel1;
	}

	public void setInnerControlPanel1(JPanel innerControlPanel1) {
		this.innerControlPanel1 = innerControlPanel1;
	}

	public JButton getBtnStart() {
		return btnStart;
	}

	public void setBtnStart(JButton btnStart) {
		this.btnStart = btnStart;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	public JButton getBtnAddSprite() {
		return btnAddSprite;
	}

	public void setBtnAddSprite(JButton btnAddSprite) {
		this.btnAddSprite = btnAddSprite;
	}

	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getInnerControlPanel2() {
		return innerControlPanel2;
	}

	public void setInnerControlPanel2(JPanel innerControlPanel2) {
		this.innerControlPanel2 = innerControlPanel2;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	public JButton getBtnLoad() {
		return btnLoad;
	}

	public void setBtnLoad(JButton btnLoad) {
		this.btnLoad = btnLoad;
	}

	// constructor
	public ControlPanelView(GameMaker gameMaker) {
		this.gameMaker = gameMaker;

	}

	public void createControlPanelView() {

		controlPanel = new JPanel();
		controlPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		controlPanel.setLayout(new GridLayout(0, 1, 0, 0));

		list = new JList();
		controlPanel.add(list);
		list.setVisibleRowCount(5);

		panel = new JPanel();
		controlPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		innerControlPanel1 = new JPanel();
		panel.add(innerControlPanel1, BorderLayout.NORTH);
		innerControlPanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnAddSprite = new JButton("Add");
		innerControlPanel1.add(btnAddSprite);
		btnAddSprite.addActionListener(new AddAdapter());

		JButton btnRemoveSprite = new JButton("Remove");
		innerControlPanel1.add(btnRemoveSprite);
		btnRemoveSprite.addActionListener(new RemoveAdapter());

		btnUpdate = new JButton("Update");
		innerControlPanel1.add(btnUpdate);

		btnStart = new JButton("Start");
		innerControlPanel1.add(btnStart);
		btnStart.addActionListener(new StartAdapter());

		innerControlPanel2 = new JPanel();
		panel.add(innerControlPanel2, BorderLayout.CENTER);

		btnSave = new JButton("Save");
		innerControlPanel2.add(btnSave);

		btnLoad = new JButton("Load");
		innerControlPanel2.add(btnLoad);

		btnCreate = new JButton("Create");
		innerControlPanel2.add(btnCreate);
		btnCreate.addActionListener(new CreateAdapter());

		gameMaker.getLeftPanel().add(controlPanel);

	}

	// Add adapter for adding sprite
	class AddAdapter implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {

			gameMaker.getGameMakerController().addSprite(gameMaker);

		}

	}

	// Add adapter for removing sprite
	class RemoveAdapter implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {

			gameMaker.getGameMakerController().removeSprite(gameMaker);

		}

	}

	class CreateAdapter implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {

			gameMaker.getGameMakerController().createGame(gameMaker);

		}

	}

	class StartAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			gameMaker.getGameMakerController().startGame(gameMaker);
		}

	}

}
