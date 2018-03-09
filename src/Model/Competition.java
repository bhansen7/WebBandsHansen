package Model;

import java.util.List;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity @IdClass(CompetitionId.class)
@Table(name = "participating_bands")

public class Competition {
	@Id
	@Column(name = "competition_id")
	protected int competitionId; 
	@Id
	@Column(name="band_id")
	private int bandId; 
	@Transient
	String competitionName;
	@Transient
	String bandName;
	
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
	public String getCompetitionName() {
		if (this.competitionId == 1) {
			this.competitionName = "State Competition";
		}else if (this.competitionId == 2) {
			this.competitionName = "Waukee Festival";
		}
		return competitionName;
	}
	
	public String getBandName() {
//		if (this.bandId == 3) {
//			this.bandName = "band 3";
//		}else if (this.bandId == 4) {
//			this.bandName = "Band 4";
//		}else {
//			this.bandName = "All Others";
//		}
		//I just get nulls with this
		//in bandhelper create method tha gets band name from band then call from here
		//Bands nb = new Bands();
		//bandName = nb.getNameOfBand();
		//System.out.println(bandName);
		 
		return bandName;
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
