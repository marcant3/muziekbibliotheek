package studiomarcant.be.model;

import javax.persistence.*;

@Entity
@Table(name = "arrangers")
public class Arranger {

	// ATTRIBUTES
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "arrangerID")
	private int arrangerID;

	@Column(name = "arrangerName")
	private String arrangerName;
	@Column(name = "arrangerLastname")
	private String arrangerLastname;
	@Column(name = "arrangerYearOfBirth")
	private int arrangerYearOfBirth;
	@Column(name = "arrangerYearOfDeath")
	private int arrangerYearOfDeath;
	@Column(name = "arrangerNationality")
	private String arrangerNationality;

	// CONSTRUCTOR
	
	public Arranger(int arrangerID, String arrangerName, String arrangerLastname, int arrangerYearOfBirth,
			int arrangerYearOfDeath, String arrangerNationality) {
		this.arrangerID = arrangerID;
		this.arrangerName = arrangerName;
		this.arrangerLastname = arrangerLastname;
		this.arrangerYearOfBirth = arrangerYearOfBirth;
		this.arrangerYearOfDeath = arrangerYearOfDeath;
		this.arrangerNationality = arrangerNationality;
	}

	// GETTERS
	
	public int getArrangerID() {
		return arrangerID;
	}

	public String getArrangerName() {
		return arrangerName;
	}

	public String getArrangerLastname() {
		return arrangerLastname;
	}

	public int getArrangerYearOfBirth() {
		return arrangerYearOfBirth;
	}

	public int getArrangerYearOfDeath() {
		return arrangerYearOfDeath;
	}

	public String getArrangerNationality() {
		return arrangerNationality;
	}

	// SETTERS

	public void setArrangerID(int arrangerID) {
		this.arrangerID = arrangerID;
	}

	public void setArrangerName(String arrangerName) {
		this.arrangerName = arrangerName;
	}

	public void setArrangerLastname(String arrangerLastname) {
		this.arrangerLastname = arrangerLastname;
	}

	public void setArrangerYearOfBirth(int arrangerYearOfBirth) {
		this.arrangerYearOfBirth = arrangerYearOfBirth;
	}

	public void setArrangerYearOfDeath(int arrangerYearOfDeath) {
		this.arrangerYearOfDeath = arrangerYearOfDeath;
	}

	public void setArrangerNationality(String arrangerNationality) {
		this.arrangerNationality = arrangerNationality;
	}

	// METHOD HASHCODE
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + arrangerID;
		result = prime * result + ((arrangerLastname == null) ? 0 : arrangerLastname.hashCode());
		result = prime * result + ((arrangerName == null) ? 0 : arrangerName.hashCode());
		result = prime * result + arrangerYearOfBirth;
		result = prime * result + arrangerYearOfDeath;
		result = prime * result + ((arrangerNationality == null) ? 0 : arrangerNationality.hashCode());
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
		Arranger other = (Arranger) obj;
		if (arrangerID != other.arrangerID)
			return false;
		if (arrangerLastname == null) {
			if (other.arrangerLastname != null)
				return false;
		} else if (!arrangerLastname.equals(other.arrangerLastname))
			return false;
		if (arrangerName == null) {
			if (other.arrangerName != null)
				return false;
		} else if (!arrangerName.equals(other.arrangerName))
			return false;
		if (arrangerYearOfBirth != other.arrangerYearOfBirth)
			return false;
		if (arrangerYearOfDeath != other.arrangerYearOfDeath)
			return false;
		if (arrangerNationality == null) {
			if (other.arrangerNationality != null)
				return false;
		} else if (!arrangerNationality.equals(other.arrangerNationality))
			return false;
		return true;
	}

	// METHOD TOSTRING
	
	@Override
	public String toString() {
		return "Arranger [arrangerID=" + arrangerID + ", arrangerName=" + arrangerName + ", arrangerLastname="
				+ arrangerLastname + ", arrangerYearOfBirth=" + arrangerYearOfBirth + ", arrangerYearOfDeath="
				+ arrangerYearOfDeath + ", arrangerNationality=" + arrangerNationality + "]";
	}

}
