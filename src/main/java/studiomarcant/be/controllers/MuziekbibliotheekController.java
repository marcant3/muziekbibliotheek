package studiomarcant.be.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import studiomarcant.be.validator.LoginValidator;
import javax.servlet.http.HttpSession;
import org.springframework.*;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
@RequestMapping ("/")
public class MuziekbibliotheekController {
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(ModelMap model, HttpSession session){
		model.addAttribute("login","login");
		return "login";
/*public String login(ModelMap model, HttpSession session) {
		LoginValidator login = new LoginValidator();
		model.addAttribute("loginValidator", login);
		// we can come here as anonymous user or as ADMIN
		// check if the user role is ADMIN
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean isAdmin = false;
		for (GrantedAuthority auth : authentication.getAuthorities()) {
			if (auth.getAuthority().equals("ROLE_ADMIN"))
				isAdmin = true;
		}

		if (authentication != null && authentication.isAuthenticated()
				&& !(authentication instanceof AnonymousAuthenticationToken) && isAdmin) {
			session.setAttribute("authorisedUser", true);
			return "menu";

		} else {
			session.setAttribute("authorisedUser", false);
			return "login";
		}*/

	}

}
