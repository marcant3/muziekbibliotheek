package studiomarcant.be.model;

import javax.persistence.*;

@Entity
@Table(name = "composers")
public class Composer {

	// ATTRIBUTES
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "composerID")
	private int composerID;

	@Column(name = "names")
	private String composerNames;
	@Column(name = "lastname")
	private String composerLastName;
	@Column(name = "yearOfBirth")
	private int composerYearOfBirth;
	@Column(name = "yearOfDeath")
	private int composerYearOfDeath;
	@Column(name = "nationality")
	private String composerNationality;

	// CONSTRUCTOR
	
	public Composer(){
		
	}
	
	public Composer(int composerID, String composerNames, String composerLastname, int composerYearOfBirth,
			int composerYearOfDeath, String composerNationality) {
		this.composerID = composerID;
		this.composerNames = composerNames;
		this.composerLastName = composerLastname;
		this.composerYearOfBirth = composerYearOfBirth;
		this.composerYearOfDeath = composerYearOfDeath;
		this.composerNationality = composerNationality;
	}

	// GETTERS
	
	public int getComposerID() {
		return composerID;
	}

	public String getComposerNames() {
		return composerNames;
	}

	public String getComposerLastName() {
		return composerLastName;
	}

	public int getComposerYearOfBirth() {
		return composerYearOfBirth;
	}

	public int getComposerYearOfDeath() {
		return composerYearOfDeath;
	}

	public String getComposerNationality() {
		return composerNationality;
	}

	// SETTERS

	public void setComposerID(int composerID) {
		this.composerID = composerID;
	}

	public void setComposerNames(String composerNames) {
		this.composerNames = composerNames;
	}

	public void setComposerLastname(String composerLastName) {
		this.composerLastName = composerLastName;
	}

	public void setComposerYearOfBirth(int composerYearOfBirth) {
		this.composerYearOfBirth = composerYearOfBirth;
	}

	public void setComposerYearOfDeath(int composerYearOfDeath) {
		this.composerYearOfDeath = composerYearOfDeath;
	}

	public void setComposerNationality(String composerNationality) {
		this.composerNationality = composerNationality;
	}

	// METHOD HASHCODE
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + composerID;
		result = prime * result + ((composerLastName == null) ? 0 : composerLastName.hashCode());
		result = prime * result + ((composerNames == null) ? 0 : composerNames.hashCode());
		result = prime * result + ((composerNationality == null) ? 0 : composerNationality.hashCode());
		result = prime * result + composerYearOfBirth;
		result = prime * result + composerYearOfDeath;
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
		Composer other = (Composer) obj;
		if (composerID != other.composerID)
			return false;
		if (composerLastName == null) {
			if (other.composerLastName != null)
				return false;
		} else if (!composerLastName.equals(other.composerLastName))
			return false;
		if (composerNames == null) {
			if (other.composerNames != null)
				return false;
		} else if (!composerNames.equals(other.composerNames))
			return false;
		if (composerNationality == null) {
			if (other.composerNationality != null)
				return false;
		} else if (!composerNationality.equals(other.composerNationality))
			return false;
		if (composerYearOfBirth != other.composerYearOfBirth)
			return false;
		if (composerYearOfDeath != other.composerYearOfDeath)
			return false;
		return true;
	}

	// METHOD TOSTRING
	
	@Override
	public String toString() {
		return "Composer [composerID=" + composerID + ", composerNames=" + composerNames + ", composerLastName="
				+ composerLastName + ", composerYearOfBirth=" + composerYearOfBirth + ", composerYearOfDeath=" + composerYearOfDeath
				+ ", composerNationality=" + composerNationality + "]";
	}
}
