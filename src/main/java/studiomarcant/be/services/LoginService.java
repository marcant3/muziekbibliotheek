package studiomarcant.be.services;

public interface LoginService {
	

	boolean isValidUser(String username , String encriptedPassword);
	
	String getPasswordByUsername(String username);

}
