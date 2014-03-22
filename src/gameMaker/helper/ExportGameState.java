package gameMaker.helper;

import gameMaker.main.GameMaker;
import gameMaker.model.GameMakerBean;
import gameMaker.model.Sprite;
import gameMaker.view.ControlPanelView;
import gameMaker.view.EventActionView;
import gameMaker.view.GamePanelView;
import gameMaker.view.SpritePanelView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class ExportGameState {

	//private SpritePanelView sprite;
	private EventActionView event;
	private GamePanelView game;
	ControlPanelView control;
	JSONObject gameJSON = new JSONObject();
	private GameMaker gameMaker;
	private GameMakerBean gameMakerBean;
	private ArrayList<Sprite> spriteList;

	public ExportGameState(GameMaker gameMaker) {
		this.gameMaker = gameMaker;
		
	}

	public void exportSpriteState() {
		
		spriteList = gameMaker.getGameMakerController().getGameMakerBean().getSpriteList();
		JSONArray jsonSpriteList = (JSONArray) JSONSerializer.toJSON( spriteList );  
		gameJSON.put("SpriteList", jsonSpriteList);
GameMaker.logger.debug("json:" + jsonSpriteList);
		//System.out.println("json: "+jsonSpriteList);
		
	}

	public void WriteToFile() {
		try {
			File jsonFile = new File("breakout.json");
			FileWriter filewriter = new FileWriter(jsonFile.getAbsoluteFile());
			BufferedWriter bufferwriter = new BufferedWriter(filewriter);
			bufferwriter.write(gameJSON.toString());
			bufferwriter.close();
			//System.out.println("write to file");
			GameMaker.logger.debug("write to file");
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
}
