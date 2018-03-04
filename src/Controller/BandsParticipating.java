package Controller;
import java.util.ArrayList;

import Model.Bands;

public class BandsParticipating {
	private String eventName;
	private ArrayList<Bands> bandlist;

	public BandsParticipating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BandsParticipating(String eventName, ArrayList<Bands> bandlist) {
		super();
		this.eventName = eventName;
		this.bandlist = bandlist;
	}

	public BandsParticipating(String eventName) {
		super();
		this.eventName = eventName;
		bandlist = new ArrayList<Bands>();
	}

	public void addToEvent(Bands newBand) {
		bandlist.add(newBand);
	}

	private String event;

	public String displayEvent() {
		event = "Roster for " + eventName + ": " + bandlist;
		return event;
	}

	@Override
	public String toString() {
		return "BandsParticipating [eventName=" + eventName + ", bandlist=" + bandlist + "]";
	}

}
