package studiomarcant.be.model;

import javax.persistence.*;

@Entity
@Table(name = "locationdata")
public class LocationData {

	// ATTRIBUTES
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "locationDataID")
	private int locationDataID;
	@Column(name = "locationMedium")
	private String locationMedium;
	@Column(name = "locationCode")
	private String locationCode;
	@Column(name = "locationDescription")
	private String locationDescription;

	// CONSTRUCTOR
	
	public LocationData(int locationDataID, String locationMedium, String locationCode, String locationDescription) {
		this.locationDataID = locationDataID;
		this.locationMedium = locationMedium;
		this.locationCode = locationCode;
		this.locationDescription = locationDescription;

	}

	// GETTERS
	
	public int getlocationDataID() {
		return locationDataID;
	}

	public String getLocationMedium() {
		return locationMedium;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	// SETTERS
	
	public void setlocationDataID(int locationDataID) {
		this.locationDataID = locationDataID;
	}

	public void setLocationMedium(String locationMedium) {
		this.locationMedium = locationMedium;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	// METHOD HASHCODE
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locationCode == null) ? 0 : locationCode.hashCode());
		result = prime * result + ((locationDescription == null) ? 0 : locationDescription.hashCode());
		result = prime * result + locationDataID;
		result = prime * result + ((locationMedium == null) ? 0 : locationMedium.hashCode());
		return result;
	}

	// METHOD EQUALS
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationData other = (LocationData) obj;
		if (locationCode == null) {
			if (other.locationCode != null)
				return false;
		} else if (!locationCode.equals(other.locationCode))
			return false;
		if (locationDescription == null) {
			if (other.locationDescription != null)
				return false;
		} else if (!locationDescription.equals(other.locationDescription))
			return false;
		if (locationDataID != other.locationDataID)
			return false;
		if (locationMedium == null) {
			if (other.locationMedium != null)
				return false;
		} else if (!locationMedium.equals(other.locationMedium))
			return false;
		return true;
	}

	// METHOD TOSTRING
	
	@Override
	public String toString() {
		return "LocationData [locationDataID=" + locationDataID + ", locationMedium=" + locationMedium + ", locationCode="
				+ locationCode + ", locationDescription=" + locationDescription + "]";
	}
}
