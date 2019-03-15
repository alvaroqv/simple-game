package com.simplegame.fastone.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.simplegame.fastone.exception.BaseGameException;
import com.simplegame.fastone.utils.MsgLoader;

/**
 * CommandoEvent Factory. Load CommandoEvent from XML commandconfig.xml
 * @author alvaro.silva
 *
 */
public class CommandFactory {
	
	private static volatile Map<String, CommandEvent> commandCache;
	

	
	/*
	 * Get By CommandEvent ID
	 */
	public static CommandEvent getById(String id) throws BaseGameException {
		buildMap();
		return commandCache.get(id);
	}
	
	public static List<CommandEvent> getCommandList() throws BaseGameException {
		buildMap();
		return commandCache.values().stream().collect(Collectors.toList());
	}
	
	public static  Map<String, CommandEvent> getCommandMap() throws BaseGameException {
		buildMap();
		return commandCache;
	}

	private static void buildMap() throws BaseGameException {
		if(commandCache == null) {
			commandCache = CommandFactory.parseConfigXML();
		}
	}
	
	
	
	
	/**
	 * Load CommandEvent configuration from XML commandconfig.xml 
	 * @return  Map<String, CommandEvent> 
	 * @throws BaseGameException 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private static Map<String, CommandEvent> parseConfigXML() throws BaseGameException {
	      //Initialize a list of commandevents
	      Map<String, CommandEvent> eventList = new HashMap<String,CommandEvent>();
	       
	      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	      DocumentBuilder builder;
	      Document document;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(CommandFactory.class.getClassLoader().getResourceAsStream("commandConfig.xml"));
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new BaseGameException(MsgLoader.getMsgByKey("erro.configload"), e.fillInStackTrace());
			
		}
	      
	      document.getDocumentElement().normalize();
	      NodeList nList = document.getElementsByTagName("commandEvent");
	      
	      for (int temp = 0; temp < nList.getLength(); temp++)
	      {
	         Node node = nList.item(temp);
	         if (node.getNodeType() == Node.ELEMENT_NODE)
	         {
	            Element eElement = (Element) node;
	            //Create new CommandoEvent Object
	            String id = eElement.getAttribute("id");
	            String name = eElement.getAttribute("name");
	            String description = eElement.getAttribute("description");
	            
	            CommandEventBase event  = new CommandEventBase(id, name, description );
	            
	            //load CommandEventListeners
	            int totalListeners = eElement.getElementsByTagName("listener").getLength();
	            for(int i=0; i< totalListeners; i++) {
	            	String className = eElement.getElementsByTagName("listener").item(i).getTextContent();
	            	CommandListener listener;
					try {
						listener = (CommandListener) Class.forName(className).newInstance();
						event.addCommandListener(listener);
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
						throw new BaseGameException("erro.loadlistener", e.fillInStackTrace());
					}
	            	
	            }
	             
	            //Add CommandEvent to list
	            eventList.put(id, event);
	         }
	      }
	      return eventList;
	   }

}
