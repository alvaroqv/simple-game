package com.simplegame.fastone;

import java.util.Scanner;

import com.simplegame.fastone.command.CommandHandler;
import com.simplegame.fastone.controller.GameStageFactory;
import com.simplegame.fastone.controller.IStage;
import com.simplegame.fastone.controller.StagesEnun;
import com.simplegame.fastone.model.CharacterBase;
import com.simplegame.fastone.model.CharacterFriendsGame;
import com.simplegame.fastone.utils.ContantsMsg;
import com.simplegame.fastone.utils.MsgLoader;

/**
 * Main class response for start the Game Controllers
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	 // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);
        
        //initial messages
        MsgLoader.printMsgKey("initial.welcome");
        System.out.println(ContantsMsg.LOGO);
        MsgLoader.printMsgKey("initial.title");
        MsgLoader.printMsgKey("initial.goal");
        MsgLoader.printMsgKey("initial.comands");
        MsgLoader.printMsgKey("menu.help");
        MsgLoader.printMsgKey("game.create");
        
        //Singleton Context to share data with diferent context
        AppContext context = AppContext.getInstance();
        
        //CharacterStage characterCreateEvent = new CharacterStage();
        CharacterBase player = new CharacterFriendsGame();
        IStage stage = null;
        context.setPlayer(player);
        context.setStage(stage);
        

        //main loop to wait for user type
        while(!context.quit()) {
        	String command = scanner.next();
        	
        	if(context.getStage() != null) {
        		stage.action(command, player, context);
        	}else {
        		stage = stageVerification(command);	
        		context.setStage(stage);
        	}
        	
        	CommandHandler.getInstance().execute(command, context);
        }
    }

	private static IStage stageVerification( String command) {
		if(StagesEnun.APARTMENT.getStage().equals(command)) {
			MsgLoader.printMsgKey("game.level.apart");
			return  GameStageFactory.getStageApartament();
		}
		if(StagesEnun.COFFEESHOP.getStage().equals(command)) {
			MsgLoader.printMsgKey("game.level.coffeeshop");
			return  GameStageFactory.getStageCoffeeShop();
		}
		if(StagesEnun.START.getStage().equals(command)) {
			MsgLoader.printMsgKey("game.createnew");
			return  GameStageFactory.getStageStart();
		}
		return null;
	}
}
