/**
 * File: NodeMultipleEvents.java
 * Creation: 7 nov. 2020, Jean-Philippe.Prost@univ-amu.fr
 * Template étudiants
 */
package pracHDVELH;

import java.util.Scanner;

import myUtils.ErrorNaiveHandler;

/**
 * @author prost
 *
 */
public class Event extends NodeMultiple {
	public static final String ERROR_MSG_UNEXPECTED_END = "Sorry, for some unexpected reason the story ends here...";
	public static final String PROMPT_ANSWER = "Answer: ";
	public static final String WARNING_MSG_INTEGER_EXPECTED = "Please input a integer within range!";
	
	private static int lastID = 0;
	private GUIManager gui;
	private String data;
	private String playerAnswer;
	private Scanner inputReader;
	private int chosenPath;
	private int id;
	
	public Event(GUIManager gui, String string) {
		super(string);
		this.gui = gui;
		this.data = string;
		this.inputReader = gui.getInputReader();
		id = ++lastID;
	}
	
	public Event() {
		this(new GUIManager(), null);
	}

	/**
	 * @return the playerAnswer
	 */
	public String getPlayerAnswer() {
		return playerAnswer;
	}

	/**
	 * @param playerAnswer the playerAnswer to set
	 */
	public void setPlayerAnswer(String playerAnswer) {
		this.playerAnswer = playerAnswer;
	}

	/**
	 * @return the reader
	 */
	public Scanner getReader() {
		return inputReader;
		}

	/**
	 * @param reader the reader to set
	 */
	public void setReader(Scanner reader) {
		inputReader = reader;
	}

	/**
	 * @return the chosenPath
	 */
	public int getChosenPath() {
		return chosenPath;
	}

	/**
	 * @param chosenPath the chosenPath to set
	 */
	public void setChosenPath(int chosenPath) {
		this.chosenPath = chosenPath;
	}

	/* Methods */
	/**
	 * @see pracHDVELH.NodeMultiple#getData()
	 */
	public String getData() {
		return this.data;
	}

	/**
	 * @see pracHDVELH.NodeMultiple#setData(Object)
	 * @param data
	 */
	public void setData(String data) {
		this.data = data;
	}
	
	public int interpretAnswer() {
		chosenPath = Integer.parseInt(playerAnswer) - 1;
		return chosenPath;
	}

	/**
	 * @see pracHDVELH.NodeMultiple#getDaughter(int)
	 */
	@Override
	public Event getDaughter(int i) {
		return (Event)getDaughters()[i];
	}

	/**
	 * @see pracHDVELH.NodeMultiple#setDaughter(NodeMultiple, int)
	 * @param daughter
	 * @param i
	 */
	public void setDaughter(Event daughter, int i) {
		NodeMultiple[] daughters = getDaughters();
		if(daughters == null) {return;}
		if(daughter == null) {return;}
		if(i < daughters.length) {
			daughters[i] = daughter;
		}
		setDaughters(daughters);
	}

	/**
	 * @return the gui
	 */
	public GUIManager getGui() {
		return gui;
	}

	/**
	 * @param gui the gui to set
	 */
	public void setGui(GUIManager gui) {
		this.gui = gui;
	}

	/** 
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	public Event run() {
		gui.outputln(this.getData());
		gui.outputln(PROMPT_ANSWER);
		playerAnswer = inputReader.next();
		chosenPath = interpretAnswer();
		return getDaughter(chosenPath);
	}
	
	

}

// eof

