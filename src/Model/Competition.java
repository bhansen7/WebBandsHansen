package Model;

import java.util.List;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.Id;  
import javax.persistence.Table;

@Entity
@Table(name = "participating_bands")

public class Competition {
	@Id
	@Column(name = "competition_id")
	protected int competitionId;
	//private String eventName;
	@Column(name="band_id")
	private int bandId; 
	
	public Competition() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Competition(int competitionId, int bandId) {
		super();
		this.competitionId = competitionId;
		this.bandId = bandId;
	}

	public int getCompetitionId() {
		return competitionId;
	}
	public void setCompetitionId(int competitionId) {
		this.competitionId = competitionId;
	}
	public int getBandId() {
		return bandId;
	}
	public void setBandId(int bandId) {
		this.bandId = bandId;
	}

	@Override
	public String toString() {
		return "Competition [competitionId=" + competitionId + ", band_id=" + bandId + "]"; 
		
	}

	public String returnCompetitionDetails() {
		// TODO Auto-generated method stub
		String competitionDescription;
		if (competitionId == 1) {
			competitionDescription = "State Competition";
		}else {
			competitionDescription = "Waukee Festival";
		} 
		
		return "Attending " + competitionDescription  + " is band id " + bandId + ".";
		//this would work if we had extended competition...then we can get band name - but for now just displaying id
		//return "Attending " + competitionDescription  + " is " + super.bandNameReport() +".";
	}
	
}
