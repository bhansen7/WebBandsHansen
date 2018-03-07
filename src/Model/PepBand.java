package Model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@PrimaryKeyJoinColumn(name = "band_id", referencedColumnName = "band_id")
@DiscriminatorValue(value = "PepBand")
@Table(name = "pep_band")
public class PepBand extends Bands {

	@Column(name = "event_id")
	private int eventId;
	@Column(name = "playing_position")
	private String playingPosition;
	@Transient
	private String event;
	@Transient
	private String eventName;
	@Transient
	private String eventDescription;
	@Transient
	private String eventTypeDescription;

	public PepBand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PepBand(int bandId) {
		super(bandId);
	}

	public PepBand(int numberOfMembers, String nameOfBand, String locationOfBand, int levelBandId, int eventId) {
		super(numberOfMembers, nameOfBand, locationOfBand, levelBandId);
		setEventId(eventId); 
	}


	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
		if (this.event.equalsIgnoreCase("assembly")) {
			this.playingPosition = "standing";
		} else if (this.event.equalsIgnoreCase("sporting")) {
			this.playingPosition = "sitting";
		} else {
			throw new IllegalStateException("Invalid event type");
		}
	}

	public String getEventName() {
		if (this.eventId == 1) {
			this.eventName = "Girls basketball game";
		}else if (this.eventId == 2){
			this.eventName = "Boys basketball game";
		}else if (this.eventId == 3){
			this.eventName = "Football game";
		}else if (this.eventId == 4) {
			this.eventName = "Wrestling meet";
		}else if (this.eventId == 5) {
			this.eventName = "Homecoming pep rally";
		}else if (this.eventId == 6) {
			this.eventName = "District final pep rally";
		}else if (this.eventId == 7) {
			this.eventName = "Red ribbon week pep rally";
		}
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getPlayingPosition() {
		return playingPosition;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
		//making assumption based on current domain table
		if (this.eventId < 5) {
			this.playingPosition = "standing"; 
		} else  {
			this.playingPosition = "sitting"; 
		} 
		
	}

	@Override
	public String toString() {
		return "PepBand [event=" + event + ", eventName=" + eventName + ", playingPosition=" + playingPosition
				+ ", toString()=" + super.toString() + "]";
	}

	@Override
	public String bandReport() {
		
		// TODO Auto-generated method stub
		//what we used before persistence
		//return super.bandReport() + " You will be " + playingPosition + " while playing at the " + eventName + " "
		//		+ event + " event."; 
		
		String eventTypeDescription = "";
		if (eventId < 5) {
			eventTypeDescription = "sporting";
		}else {
			eventTypeDescription = "assembly";
		}
		
		String eventDescription = "";
		switch (eventId) {
		case 1:
			eventDescription = "girls basketball";
			break;
		case 2:
			eventDescription = "boys basketball";
			break;
		case 3:
			eventDescription = "football";
			break;
		case 4:
			eventDescription = "wrestling";
			break;
		case 5:
			eventDescription = "homecoming";
			break;
		case 6:
			eventDescription = "district final";
			break;
		case 7:
			eventDescription = "red ribbon week";
			break;
		default:
			throw new IllegalArgumentException("Unknown" + eventId);
			
		}
		
		return super.bandReport() + " You will be " + playingPosition + " while playing at the " + eventDescription + " "
		+ eventTypeDescription + " event.";

	}

	public String returnPepBandDetails() {
		// TODO Auto-generated method stub
		return "PepBand: " + super.toString() + "event=" + event + ", eventName=" + eventName + ", playingPosition="
				+ playingPosition;
	}

}
