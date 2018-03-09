package Model;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.persistence.Access;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;
 

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "band_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "PlainBand")
@Table(name = "band")

public class Bands {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "band_id")
	protected int bandId;

	@Column(name = "num_of_members")
	private int numberOfMembers;
	@Column(name = "name_of_band")
	protected String nameOfBand;
	@Column(name = "location_of_band")
	private String locationOfBand;
	@Column(name = "cost_of_participation")
	private double costOfParticipation;

	@Column(name = "level_of_band")
	// @Convert(converter = BandLevelAttributeConverter.class)
	private int levelBandId;
	@Column(name = "band_type")
	private String bandType;

	@Transient
	// @Convert(converter = BandLevelAttributeConverter.class)
	//not yet implementing the converter
	private String levelOfBand;

	@Transient
	final double JUNIOR_HIGH_COST = 20.00;
	@Transient
	final double HIGH_SCHOOL_COST = 35.50;
	@Transient
	final double ELEMENTARY_COST = 15.50;
	@Transient
	final int ELEMENTARY_LEVEL_ID = 1;
	@Transient
	final int JUNIOR_HIGH_LEVEL_ID = 2;
	@Transient
	final int HIGH_SCHOOL_LEVEL_ID = 3;
	@Transient
	double quantityDiscount;
	@Transient
	protected int minimumNumberBuses;
	@Transient
	DecimalFormat df = new DecimalFormat("$##0.00");

	public Bands() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bands(int bandId) {
		super();
		this.bandId = bandId;
	}

	public Bands(int numberOfMembers, String nameOfBand, String locationOfBand, int levelBandId) {
		super();
		setNumberOfMembers(numberOfMembers);
		this.nameOfBand = nameOfBand;
		this.locationOfBand = locationOfBand;
		setLevelBandId(levelBandId);
	}

	public int getBandId() {
		return bandId;
	}

	public int getLevelBandId() {
		return levelBandId;
	}

	public void setLevelBandId(int levelBandId) {
		this.levelBandId = levelBandId;
		if (this.levelBandId == JUNIOR_HIGH_LEVEL_ID) {
			this.costOfParticipation = JUNIOR_HIGH_COST - quantityDiscount;
		} else if (this.levelBandId == HIGH_SCHOOL_LEVEL_ID) {
			this.costOfParticipation = HIGH_SCHOOL_COST - quantityDiscount;
		} else if (this.levelBandId == ELEMENTARY_LEVEL_ID) {
			this.costOfParticipation = ELEMENTARY_COST - quantityDiscount;
		} else {
			throw new IllegalStateException("Invalid band level id - " + levelBandId);
		}
	}

	public int getNumberOfMembers() {
		return numberOfMembers;
	}

	public void setNumberOfMembers(int numberOfMembers) {
		this.numberOfMembers = numberOfMembers;
		if (this.numberOfMembers < 30) {
			quantityDiscount = 0;
		} else if (this.numberOfMembers > 100) {
			quantityDiscount = 15.00;
		} else {
			quantityDiscount = 5.50;
		}
		if (this.numberOfMembers < 50) {
			minimumNumberBuses = 1;
		} else if (this.numberOfMembers < 100) {
			minimumNumberBuses = 2;
		} else {
			minimumNumberBuses = 3;
		} 
	}

	public String getNameOfBand() {
		return nameOfBand;
	}

	public void setNameOfBand(String nameOfBand) {
		this.nameOfBand = nameOfBand;
	}

	public String getLocationOfBand() {
		return locationOfBand;
	}

	public void setLocationOfBand(String locationOfBand) {
		this.locationOfBand = locationOfBand;
	}

	public double getCostOfParticipation() {
		return costOfParticipation;
	}

	public String getLevelOfBand() {
		if (this.levelBandId == JUNIOR_HIGH_LEVEL_ID) {
			this.levelOfBand = "Junior High";
		} else if (this.levelBandId == HIGH_SCHOOL_LEVEL_ID) {
			this.levelOfBand = "Highschool";
		} else if (this.levelBandId == ELEMENTARY_LEVEL_ID) {
			this.levelOfBand = "Elementary";
		} 
		return levelOfBand;
	}

	public void setLevelOfBand(String levelOfBand) {
		this.levelOfBand = levelOfBand;
		if (this.levelOfBand.equalsIgnoreCase("jh")) {
			this.costOfParticipation = JUNIOR_HIGH_COST - quantityDiscount;
		} else if (this.levelOfBand.equalsIgnoreCase("HS")) {
			this.costOfParticipation = HIGH_SCHOOL_COST - quantityDiscount;
		} else {
			throw new IllegalStateException("Invalid band level");
		}
	}

//	private double calcCostOfParticipation(int numberOfMembers2, int levelOfBand2) {
//		// TODO Auto-generated method stub
//		
//
//			if (this.numberOfMembers < 25) {
//				quantityDiscount = 0;
//			} else if (this.numberOfMembers > 100) {
//				quantityDiscount = 10.00;
//			} else {
//				quantityDiscount = 5.50;
//			}
//			
//			Double totalCostOfParticipation;
//			if (this.levelOfBand == ELEMENTARY_LEVEL_ID) {
//				totalCostOfParticipation = 0.0;
//			} else if (this.levelOfBand == JUNIOR_HIGH_LEVEL_ID) {
//				totalCostOfParticipation = JUNIOR_HIGH_COST - quantityDiscount;
//			} else {
//				totalCostOfParticipation = HIGH_SCHOOL_COST - quantityDiscount;
//			}
//	//1		totalCostOfParticipation = 599.99;
//			return totalCostOfParticipation;
//	}
	@Override
	public String toString() {
		return "Bands [numberOfMembers=" + numberOfMembers + ", nameOfBand=" + nameOfBand + ", locationOfBand="
				+ locationOfBand + ", costOfParticipation=" + costOfParticipation + ", levelOfBand=" + levelOfBand
				+ "]";
	}

	public String bandReport() {
		return "The " + this.nameOfBand + " band(" + bandId + ") is located in " + this.locationOfBand + ". It costs "
				+ df.format(costOfParticipation) + " to join.";

	}
	public String bandNameReport() {
		return this.nameOfBand;

	}
	public String returnBandDetails() {
		// TODO Auto-generated method stub
		String bandLevelDescription = "";
		if (levelBandId == 1) {
			bandLevelDescription = "Elementary";
		} else if (levelBandId == 2) {
			bandLevelDescription = "Junior High";
		} else if (levelBandId == 3) {
			bandLevelDescription = "High School";
		}
		return nameOfBand + "(" + bandId + ") has " + numberOfMembers + " members. It is located in " + locationOfBand
				+ ". It is a " + bandLevelDescription + " level so costs " + costOfParticipation + ".";

	}

}
