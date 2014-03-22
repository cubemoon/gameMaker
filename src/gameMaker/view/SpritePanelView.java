/**
 * view class for displaying sprite panel properties view
 */

package gameMaker.view;

/*
 * all components and action listener of the file chooser are being added
 */

import gameMaker.main.GameMaker;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SpritePanelView {

	private JPanel spritePanel;
	private JLabel spriteLabel;
	private JLabel lblXPosition;
	private JLabel lblYPosition;
	private JLabel lblHeight;
	private JLabel lblWidth;
	private JLabel lblXspeed;
	private JLabel lblYspeed;
	private JButton btnSelectAFile;
	private JFileChooser imageSprite;
	private JTextField xpositionField;
	private JTextField ypositioinField;
	private JTextField heightField;
	private JTextField widthField;
	private JTextField selectSprite;
	private JTextField xSpeed;

	public JLabel getLblXspeed() {
		return lblXspeed;
	}

	public void setLblXspeed(JLabel lblXspeed) {
		this.lblXspeed = lblXspeed;
	}

	public JLabel getLblYspeed() {
		return lblYspeed;
	}

	public void setLblYspeed(JLabel lblYspeed) {
		this.lblYspeed = lblYspeed;
	}

	public JTextField getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(JTextField xSpeed) {
		this.xSpeed = xSpeed;
	}

	public JTextField getySpeed() {
		return ySpeed;
	}

	public void setySpeed(JTextField ySpeed) {
		this.ySpeed = ySpeed;
	}

	private JTextField ySpeed;

	private GameMaker gameMaker;
	BufferedImage buff;

	public JFileChooser getImageSprite() {
		return imageSprite;
	}

	public void setImageSprite(JFileChooser imageSprite) {
		this.imageSprite = imageSprite;
	}

	public SpritePanelView(GameMaker gameMaker) {

		this.gameMaker = gameMaker;
	}

	public JPanel getSpritePanel() {
		return spritePanel;
	}

	public void setSpritePanel(JPanel spritePanel) {
		this.spritePanel = spritePanel;
	}

	public JLabel getSpriteLabel() {
		return spriteLabel;
	}

	public void setSpriteLabel(JLabel spriteLabel) {
		this.spriteLabel = spriteLabel;
	}

	public JLabel getLblXPosition() {
		return lblXPosition;
	}

	public void setLblXPosition(JLabel lblXPosition) {
		this.lblXPosition = lblXPosition;
	}

	public JLabel getLblYPosition() {
		return lblYPosition;
	}

	public void setLblYPosition(JLabel lblYPosition) {
		this.lblYPosition = lblYPosition;
	}

	public JLabel getLblXSpeed() {
		return lblHeight;
	}

	public void setLblXSpeed(JLabel lblXSpeed) {
		this.lblHeight = lblXSpeed;
	}

	public JLabel getLblYSpeed() {
		return lblWidth;
	}

	public void setLblYSpeed(JLabel lblYSpeed) {
		this.lblWidth = lblYSpeed;
	}

	public JButton getBtnSelectAFile() {
		return btnSelectAFile;
	}

	public void setBtnSelectAFile(JButton btnSelectAFile) {
		this.btnSelectAFile = btnSelectAFile;
	}

	public JTextField getXpositionField() {
		return xpositionField;
	}

	public void setXpositionField(JTextField xpositionField) {
		this.xpositionField = xpositionField;
	}

	public JTextField getYpositioinField() {
		return ypositioinField;
	}

	public void setYpositioinField(JTextField ypositioinField) {
		this.ypositioinField = ypositioinField;
	}

	public JTextField getHeightField() {
		return heightField;
	}

	public void setHeightField(JTextField heightField) {
		this.heightField = heightField;
	}

	public JTextField getWidthField() {
		return widthField;
	}

	public void setWidthField(JTextField widthField) {
		this.widthField = widthField;
	}

	public JTextField getSelectSprite() {
		return selectSprite;
	}

	public void setSelectSprite(JTextField selectSprite) {
		this.selectSprite = selectSprite;
	}

	public void CreateSpritePanelView() {
		spritePanel = new JPanel();
		spritePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		spritePanel.setLayout(new GridLayout(0, 2, 0, 0));

		spriteLabel = new JLabel("Enter Sprite Name");
		spritePanel.add(spriteLabel);

		selectSprite = new JTextField();
		spritePanel.add(selectSprite);

		spriteLabel = new JLabel("Upload the sprite image");
		spritePanel.add(spriteLabel);

		btnSelectAFile = new JButton("select an image");
		btnSelectAFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				imageSprite = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"JPG & GIF Images", "jpg", "gif");
				imageSprite.setFileFilter(filter);
				int returnValue = imageSprite.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = imageSprite.getSelectedFile();

					GameMaker.logger.debug(selectedFile.getName());

					try {
						buff = ImageIO.read(selectedFile);
						if (buff != null) {

							GameMaker.logger.debug(buff.getWidth() + " "
									+ buff.getHeight());

							heightField.setText(Integer.toString(buff
									.getHeight()));
							widthField.setText(Integer.toString(buff.getWidth()));
						}
					} catch (IOException e) {

						e.printStackTrace();
					}

				}
			}
		});

		spritePanel.add(btnSelectAFile);

		lblXPosition = new JLabel("X Position");
		spritePanel.add(lblXPosition);

		xpositionField = new JTextField();
		spritePanel.add(xpositionField);
		xpositionField.setColumns(10);

		lblYPosition = new JLabel("Y Position");
		spritePanel.add(lblYPosition);

		ypositioinField = new JTextField();
		spritePanel.add(ypositioinField);
		ypositioinField.setColumns(10);

		lblHeight = new JLabel("Height");
		spritePanel.add(lblHeight);

		heightField = new JTextField();
		spritePanel.add(heightField);
		heightField.setColumns(10);

		lblWidth = new JLabel("Width");
		spritePanel.add(lblWidth);

		widthField = new JTextField();
		spritePanel.add(widthField);
		widthField.setColumns(10);

		lblXspeed = new JLabel("xSpeed");
		spritePanel.add(lblXspeed);

		xSpeed = new JTextField();
		spritePanel.add(xSpeed);
		xSpeed.setColumns(10);

		lblYspeed = new JLabel("ySpeed");
		spritePanel.add(lblYspeed);

		ySpeed = new JTextField();
		spritePanel.add(ySpeed);
		ySpeed.setColumns(10);

		this.setSpritePanel(spritePanel);
		gameMaker.getLeftPanel().add(spritePanel);

	}

}
