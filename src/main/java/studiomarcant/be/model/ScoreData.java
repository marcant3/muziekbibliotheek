package studiomarcant.be.model;

import javax.persistence.*;

@Entity
@Table(name = "scoredata")
public class ScoreData {

	// ATTRIBUTES
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "scoreID")
	private int scoreID;

	@Column(name = "scoreTitle")
	private String scoreTitle;
	@Column(name = "composerID")
	private int composerID;
	@Column(name = "scoreTypeID")
	private int scoreTypeID;
	@Column(name = "numberOfPages")
	private int numberOfPages;
	@Column(name = "description")
	private String description;
	@Column(name = "locationID")
	private int locationID;
	@Column(name = "arrangementDataID")
	private int arrangementDataID;

	// CONSTRUCTOR
	
	public ScoreData(int scoreID, String scoreTitle, int composerID, int scoreTypeID, int numberOfPages,
			String description, int locationID, int arrangementDataID) {
		this.scoreID = scoreID;
		this.scoreTitle = scoreTitle;
		this.composerID = composerID;
		this.scoreTypeID = scoreTypeID;
		this.numberOfPages = numberOfPages;
		this.description = description;
		this.locationID = locationID;
		this.arrangementDataID = arrangementDataID;
	}

	// GETTERS
	
	public int getScoreID() {
		return scoreID;
	}

	public String getScoreTitle() {
		return scoreTitle;
	}

	public int getComposerID() {
		return composerID;
	}

	public int getScoreTypeID() {
		return scoreTypeID;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public String getDescription() {
		return description;
	}

	public int getLocationID() {
		return locationID;
	}

	public int getArrangementDataID() {
		return arrangementDataID;
	}

	// SETTERS
	
	public void setScoreID(int scoreID) {
		this.scoreID = scoreID;
	}

	public void setScoreTitle(String scoreTitle) {
		this.scoreTitle = scoreTitle;
	}

	public void setComposerID(int composerID) {
		this.composerID = composerID;
	}

	public void setScoreTypeID(int scoreTypeID) {
		this.scoreTypeID = scoreTypeID;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public void setArrangementDatID(int arrangementDataID) {
		this.arrangementDataID = arrangementDataID;
	}

	// METHOD HASHCODE
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + arrangementDataID;
		result = prime * result + composerID;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + locationID;
		result = prime * result + numberOfPages;
		result = prime * result + scoreID;
		result = prime * result + ((scoreTitle == null) ? 0 : scoreTitle.hashCode());
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
		ScoreData other = (ScoreData) obj;
		if (arrangementDataID != other.arrangementDataID)
			return false;
		if (composerID != other.composerID)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (locationID != other.locationID)
			return false;
		if (numberOfPages != other.numberOfPages)
			return false;
		if (scoreID != other.scoreID)
			return false;
		if (scoreTitle == null) {
			if (other.scoreTitle != null)
				return false;
		} else if (!scoreTitle.equals(other.scoreTitle))
			return false;
		if (scoreTypeID != other.scoreTypeID)
			return false;
		return true;
	}

	// METHOD TOSTRING
	
	@Override
	public String toString() {
		return "ScoreData [scoreID=" + scoreID + ", scoreTitle=" + scoreTitle + ", composerID=" + composerID
				+ ", scoreTypeID=" + scoreTypeID + ", numberOfPages=" + numberOfPages + ", description=" + description
				+ ", locationID=" + locationID + ", arrangementDataID=" + arrangementDataID + "]";
	}
}
