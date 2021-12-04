package pracHDVELH;

import java.util.Random;

public class EventRandomSolution extends Event {
	
	private GUIManager gui;
	private int[] mask;
	private String diceRoll;
	private String answer;

	public EventRandomSolution(GUIManager gui, String data, int[] mask, String diceRoll, String answer) {
		super(gui,data);
		this.gui = gui;
		this.mask = mask;
		this.diceRoll = diceRoll;
		this.answer = answer;
	}
	
	public Event run() {
		gui.outputln(getData() + " " + diceRoll);
		Random rand = new Random();
		int chosenPath = rand.nextInt(mask.length);
		gui.outputln(answer + mask[chosenPath] + "\n"); 
		return getDaughter(chosenPath);
	}

}
