package studiomarcant.be.model;

import javax.persistence.*;

@Entity
@Table(name = "members")
public class Member {

	// ATTRIBUTES
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userID")
	private int userID;

	@Column(name = "userName")
	private String username;

	@Column(name = "passWord")
	private String password;
	
	// CONSTRUCTOR
	
	public Member(){
		
	}
	
	public Member(int userID, String username, String password) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
	}
	
	// GETTERS
	
	public int getUserID() {
		return userID;
	}

	public String getUserName() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	// SETTERS
	
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	// METHOD HASHCODE
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Member other = (Member) obj;

		// check all possibilities for not equal:
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;

		return true;
	} 	
	
	// METHOD TOSTRING
	
	@Override
	public String toString() {
		return "Member [userID=" + userID + ", username=" + username + ", password=" + password + "]";
	}
}
