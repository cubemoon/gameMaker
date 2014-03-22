package gameMaker.helper;

import gameMaker.main.GameMaker;
import gameMaker.view.ControlPanelView;
import gameMaker.view.EventActionView;
import gameMaker.view.GamePanelView;
import gameMaker.view.SpritePanelView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class ImportGameState {
 
	private SpritePanelView sprite;
	private EventActionView event;
	private GamePanelView game;
	ControlPanelView control;
	String JsonString =null;
	private GameMaker gameMaker;
	
	JSONObject gameJSON =new JSONObject();
	
	public ImportGameState(GameMaker gameMaker){
		this.gameMaker=gameMaker;
	}
	
	public void importSpriteState(){
		sprite=gameMaker.getSpritePanelView();
		/*sprite.getSelectSprite().setText((String)((JSONObject)gameJSON.get("sprite")).get("selectSprite"));
        //sprite.getSelectfileField().setText((String)((JSONObject)gameJSON.get("sprite")).get("selectFile"));
        sprite.getXpositionField().setText((String)((JSONObject)gameJSON.get("sprite")).get("xPosition"));
        sprite.getYpositioinField().setText((String)((JSONObject)gameJSON.get("sprite")).get("yPosition"));
        sprite.getHeightField().setText((String)((JSONObject)gameJSON.get("sprite")).get("height"));
        sprite.getWidthField().setText((String)((JSONObject)gameJSON.get("sprite")).get("width"));*/
		gameMaker.getGameMakerController().getGameMakerBean().getSpriteList().clear();
		JSONArray jsonSpriteListArray = (JSONArray) JSONSerializer.toJSON(gameJSON.get("SpriteList").toString());
		Iterator spriteIterator = jsonSpriteListArray.iterator();
		while(spriteIterator.hasNext()){			
			JSONArray jsonSpritedArray = (JSONArray) spriteIterator.next();
			
		
		}
	
	}
	/*public void importEventState(){
		event=gameMaker.getEventActionView();
		
		event.getEventBox().setSelectedItem((String)((JSONObject)gameJSON.get("event")).get("selectEvent"));
		event.getKeyField().setText((String)((JSONObject)gameJSON.get("event")).get("keyField"));
		event.getActionBox().setSelectedItem((String)((JSONObject)gameJSON.get("event")).get("selectAction"));
		
	}*/
	public void ReadFromFile(){
		try{
			FileReader fileReader = new FileReader("breakout.json");
			BufferedReader bufferReader = new BufferedReader(fileReader);
			JsonString=bufferReader.readLine();
			bufferReader.close();
			gameJSON =(JSONObject) JSONSerializer.toJSON(JsonString);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
