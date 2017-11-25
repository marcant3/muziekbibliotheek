package studiomarcant.be.model;

import javax.persistence.*;

@Entity
@Table(name = "arrangementdata")
public class ArrangementData {

	// ATTRIBUTES
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "arrangementDataID")
	private int arrangementDataID;

	@Column(name = "arrangerID")
	private int arrangerId;
	@Column(name = "arrangedByName")
	private String arrangedByName;
	@Column(name = "arrangedByLastName")
	private String arrangedByLastName;
	@Column(name = "arrangerYearOfBirth")
	private int arrangerYearOfBirth;
	@Column(name = "arrangerYearOfDeath")
	private int arrangerYearOfDeath;
	@Column(name = "scoreTypeID")
	private int scoreTypeID;
	@Column(name = "arrangedFor")
	private String arrangedFor;

	// CONSTRUCTOR
	
	public ArrangementData(int arrangementDataID, int arrangerID, int scoreTypeID, String arrangedByName,
			String arrangedByLastName, int arrangerYearOfBirth, int arrangerYearOfDeath, String arrangedFor) {
		this.arrangementDataID = arrangementDataID;
		this.arrangerId = arrangerID;
		this.arrangedByName = arrangedByName;
		this.arrangedByLastName = arrangedByLastName;
		this.arrangerYearOfBirth = arrangerYearOfBirth;
		this.arrangerYearOfDeath = arrangerYearOfDeath;
		this.scoreTypeID = scoreTypeID;
		this.arrangedFor = arrangedFor;
	}

	// GETTERS
	
	public int getArrangementDataID() {
		return arrangementDataID;
	}

	public int getArrangerId() {
		return arrangerId;
	}

	public String getArrangedByName() {
		return arrangedByName;
	}

	public String getArrangedByLastName() {
		return arrangedByLastName;
	}

	public int getArrangerYearOfBirth() {
		return arrangerYearOfBirth;
	}

	public int getArrangerYearOfDeath() {
		return arrangerYearOfDeath;
	}

	public int getScoreTypeID() {
		return scoreTypeID;
	}

	public String getArrangedFor() {
		return arrangedFor;
	}

	// SETTERS

	public void setArrangementDataID(int arrangementDataID) {
		this.arrangementDataID = arrangementDataID;
	}

	public void setArrangerId(int arrangerId) {
		this.arrangerId = arrangerId;
	}

	public void setArrangedByName(String arrangedByName) {
		this.arrangedByName = arrangedByName;
	}

	public void setArrangedByLastName(String arrangedByLastName) {
		this.arrangedByLastName = arrangedByLastName;
	}

	public void setArrangerYearOfBirth(int arrangerYearOfBirth) {
		this.arrangerYearOfBirth = arrangerYearOfBirth;
	}

	public void setArrangerYearOfDeath(int arrangerYearOfDeath) {
		this.arrangerYearOfDeath = arrangerYearOfDeath;
	}

	public void setScoreTypeID(int scoreTypeID) {
		this.scoreTypeID = scoreTypeID;
	}

	public void setArrangedFor(String arrangedFor) {
		this.arrangedFor = arrangedFor;
	}

	// METHOD HASHCODE
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrangedByLastName == null) ? 0 : arrangedByLastName.hashCode());
		result = prime * result + ((arrangedByName == null) ? 0 : arrangedByName.hashCode());
		result = prime * result + ((arrangedFor == null) ? 0 : arrangedFor.hashCode());
		result = prime * result + arrangementDataID;
		result = prime * result + arrangerId;
		result = prime * result + arrangerYearOfBirth;
		result = prime * result + arrangerYearOfDeath;
		result = prime * result + scoreTypeID;
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
		ArrangementData other = (ArrangementData) obj;
		if (arrangedByLastName == null) {
			if (other.arrangedByLastName != null)
				return false;
		} else if (!arrangedByLastName.equals(other.arrangedByLastName))
			return false;
		if (arrangedByName == null) {
			if (other.arrangedByName != null)
				return false;
		} else if (!arrangedByName.equals(other.arrangedByName))
			return false;
		if (arrangedFor == null) {
			if (other.arrangedFor != null)
				return false;
		} else if (!arrangedFor.equals(other.arrangedFor))
			return false;
		if (arrangementDataID != other.arrangementDataID)
			return false;
		if (arrangerId != other.arrangerId)
			return false;
		if (arrangerYearOfBirth != other.arrangerYearOfBirth)
			return false;
		if (arrangerYearOfDeath != other.arrangerYearOfDeath)
			return false;
		if (scoreTypeID != other.scoreTypeID)
			return false;
		return true;
	}

	// METHOD TOSTRING
	
	@Override
	public String toString() {
		return "ArrangementData [arrangementDataID=" + arrangementDataID + ", arrangerId=" + arrangerId
				+ ", arrangedByName=" + arrangedByName + ", arrangedByLastName=" + arrangedByLastName
				+ ", arrangerYearOfBirth=" + arrangerYearOfBirth + ", arrangerYearOfDeath=" + arrangerYearOfDeath
				+ ", scoreTypeID=" + scoreTypeID + ", arrangedFor=" + arrangedFor + "]";
	}

}
