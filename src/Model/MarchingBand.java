package Model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@PrimaryKeyJoinColumn(name = "band_id", referencedColumnName = "band_id")
@DiscriminatorValue(value = "MarchingBand")
@Table(name = "marching_band")
public class MarchingBand extends Bands {

	@Transient
	private boolean hasProps;
	@Column(name = "types_of_props")
	private String typesOfProps;
	@Column(name = "number_of_buses")
	private int numberOfBuses;
	@Column(name = "has_color_guard")
	private boolean hasColorGuard;
	@Transient
	final private int additionalBus = 1;

	public MarchingBand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MarchingBand(int bandId) {
		super(bandId);
	}


	public MarchingBand(int numberOfMembers, String nameOfBand, String locationOfBand, int levelBandId,
			String typesOfProps, boolean hasColorGuard) {
		super(numberOfMembers, nameOfBand, locationOfBand, levelBandId);
		setTypesOfProps(typesOfProps);
		setHasColorGuard(hasColorGuard);
	}

	public int getBandId() {
		return bandId;
	}

	public void setBandId(int bandId) {
		this.bandId = bandId;
	}

	public boolean isHasProps() {
		return hasProps;
	}

	public void setHasProps(boolean hasProps) {
		this.hasProps = hasProps;
		if (hasProps) {
			this.numberOfBuses = minimumNumberBuses + additionalBus;
		} else {
			this.numberOfBuses = minimumNumberBuses;
		}
	}

	public String getTypesOfProps() {
		return typesOfProps;
	}

	public void setTypesOfProps(String typesOfProps) {
		this.typesOfProps = typesOfProps;
		if (typesOfProps.equals(null)) {
			this.numberOfBuses = minimumNumberBuses;
		} else {
			this.numberOfBuses = minimumNumberBuses + additionalBus;
		} 
	}

	public int getNumberOfBuses() {
		return numberOfBuses;
	}

	public boolean isHasColorGuard() {
		return hasColorGuard;
	}

	public void setHasColorGuard(boolean hasColorGuard) {
		this.hasColorGuard = hasColorGuard;
		if (hasColorGuard) {
			this.numberOfBuses = this.numberOfBuses + additionalBus; 
		}
	}

	@Override
	public String toString() {
		return "MarchingBand [hasProps=" + hasProps + ", typesOfProps=" + typesOfProps + ", numberOfBuses="
				+ numberOfBuses + ", hasColorGuard=" + hasColorGuard + ", toString()=" + super.toString() + "]";
	}

	@Override
	public String bandReport() {
		// TODO Auto-generated method stub
		if (hasProps) {
			if (numberOfBuses > 1) {
				return super.bandReport() + " Your band will be bringing " + typesOfProps + " and will be taking "
						+ numberOfBuses + " buses.";
			} else {
				return super.bandReport() + " Your band will be bringing " + typesOfProps + " and will be taking "
						+ numberOfBuses + " bus.";
			}
		} else {
			if (numberOfBuses > 1) {
				return super.bandReport() + " Your band will be taking " + numberOfBuses + " buses.";
			} else {
				return super.bandReport() + " Your band will be taking " + numberOfBuses + " bus.";
			}

		}
	}

	public String returnMarchingBandDetails() {
		// TODO Auto-generated method stub
		return super.bandReport() + "MarchingBand: hasProps=" + hasProps + ", typesOfProps=" + typesOfProps
				+ ", numberOfBuses=" + numberOfBuses + ", hasColorGuard=" + hasColorGuard;
	}

}
