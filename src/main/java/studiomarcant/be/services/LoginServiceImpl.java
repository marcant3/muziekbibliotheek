package studiomarcant.be.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import studiomarcant.be.dao.MemberDao;
import studiomarcant.be.model.Member;

/*@Service("loginService")
@Transactional*/
public class LoginServiceImpl implements LoginService {

	@Autowired
	private MemberService service;

	/*@Autowired
	private PasswordEncoder passwordEncoder;*/

	@Override
	public boolean isValidUser(String memberName, String encriptedPassword) {
		
		final String givenName="marcant";
		final String givenPassword="Geisli38";
		Member member = service.find(givenName);
		if (member != null  && member.getPassword().equals(givenPassword))
			return true;
		else
			return false;
		
	}

	@Override
	public String getPasswordByUsername(String memberName) {
		final String givenName="marcant";
		Member member = service.find(givenName);
		if (member == null)
			return null;
		else
			return member.getPassword();
	}
}
