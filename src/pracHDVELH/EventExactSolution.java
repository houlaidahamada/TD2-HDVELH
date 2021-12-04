package pracHDVELH;

import java.util.Scanner;

public class EventExactSolution extends Event {
	
	private GUIManager guigui;
	private String reponse;


	public EventExactSolution(GUIManager guigui, String data, String reponse) {
		super(guigui,data);
		this.guigui = guigui;
		this.reponse = reponse;
	}
	
	
	public Event run() {
		guigui.outputln(getData() + " " + reponse + "\n");
		return getDaughter(0);
	}
	
	

}
