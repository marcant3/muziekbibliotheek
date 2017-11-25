package studiomarcant.be.model;

import javax.persistence.*;

@Entity
@Table(name = "scoredata")
public class ScoreType {

	// ATTRIBUTES
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "scoreTypeID")
	private int scoreTypeID;

	@Column(name = "scoreWrittenFor")
	private String scoreWrittenFor;

	// CONSTRUCTOR
	
	public ScoreType(int scoreTypeID, String scoreWrittenFor) {
		this.scoreTypeID = scoreTypeID;
		this.scoreWrittenFor = scoreWrittenFor;

	}

	// GETTERS
	
	public int getScoreTypeID() {
		return scoreTypeID;
	}

	public String getScoreWrittenFor() {
		return scoreWrittenFor;
	}

	// SETTERS
	
	public void setScoreTypeID(int scoreTypeID) {
		this.scoreTypeID = scoreTypeID;
	}

	public void setScoreWrittenFor(String scoreWrittenFor) {
		this.scoreWrittenFor = scoreWrittenFor;
	}

	// METHOD HASHCODE
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + scoreTypeID;
		result = prime * result + ((scoreWrittenFor == null) ? 0 : scoreWrittenFor.hashCode());
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
		ScoreType other = (ScoreType) obj;
		if (scoreTypeID != other.scoreTypeID)
			return false;
		if (scoreWrittenFor == null) {
			if (other.scoreWrittenFor != null)
				return false;
		} else if (!scoreWrittenFor.equals(other.scoreWrittenFor))
			return false;
		return true;
	}

	// METHOD TOSTRING
	
	@Override
	public String toString() {
		return "ScoreType [scoreTypeID=" + scoreTypeID + ", scoreWrittenFor=" + scoreWrittenFor + "]";
	}
}
