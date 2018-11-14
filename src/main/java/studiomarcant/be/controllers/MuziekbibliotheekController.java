package studiomarcant.be.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import studiomarcant.be.model.ArrangementData;
import studiomarcant.be.repositories.ArrangementDataRepository;
import studiomarcant.be.utils.CustomErrorType;
import studiomarcant.be.validator.LoginValidator;
import javax.servlet.http.HttpSession;
import org.springframework.*;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api")
public class MuziekbibliotheekController {

	public static final Logger logger = LoggerFactory.getLogger (MuziekbibliotheekController.class);

	@Autowired
	ArrangementDataRepository arrangementDataRepository;

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

	// Retrieve all ArrangementData

	@GetMapping (value = "/allArrangements/")
	public List<ArrangementData> listAllArrangements() {
		List<ArrangementData> arrangements = arrangementDataRepository.findAll();
        /*if (diamonds.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);

        }*/
		//return new ResponseEntity<List<DiamondData>>(diamonds, HttpStatus.OK);
		return arrangements;
	}

	// Retrieve data of a single ArrangementData by Id

	@GetMapping(value = "/arrangementData/{id}")
	public ResponseEntity<ArrangementData> getArrangementDataById(@PathVariable ("id") Long id) throws IllegalAccessException, NoSuchFieldException, IOException {
		logger.info("Fetching ArrangementData with id {}", id);
		ArrangementData arrangementData = arrangementDataRepository.getOne(id);
		if (arrangementData == null) {
			logger.error("ArrangementData with id {} not found.", id);


			return new ResponseEntity(new CustomErrorType ( new Error("ArrangementData with id " + id
					+ " not found")), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ArrangementData>(arrangementData, HttpStatus.OK);
	}

	//Create a single arrangementData

	@PostMapping(value = "/createArrangementData")
	public ResponseEntity<ArrangementData> createArrangementData(@RequestBody ArrangementData arrangementData) {
		if (! checkIfDataExists (arrangementData)) {
			logger.info ("Creating ArrangementData : {}", arrangementData);
			arrangementDataRepository.save (arrangementData);
			return new ResponseEntity<ArrangementData> (arrangementData, HttpStatus.OK);
		} else {
			logger.error ("Unable to create. An ArrangementData with these properties {} already exist", arrangementData.getArrangementDataID (), arrangementData.getArrangedByName (), arrangementData.getArrangedByLastName (), arrangementData.getArrangerId (), arrangementData.getArrangedFor (), arrangementData.getArrangerYearOfBirth (), arrangementData.getArrangerYearOfDeath (), arrangementData.getScoreTypeID ());
			return new ResponseEntity (new CustomErrorType ("Unable to create. An ArrangementData with this ID " + arrangementData.getArrangementDataID () + " already exist."),HttpStatus.CONFLICT);
		}
	}
	//Update an ArrangementData

	@PutMapping(value = "/updateArrangementData/{id}")
	public ResponseEntity<ArrangementData> updateArrangementData(@PathVariable("id") long id, @RequestBody ArrangementData arrangementData) {
		logger.info("Updating arrangementData with id {}", id);

		ArrangementData currentArrangementData = arrangementDataRepository.findOne (id);

		if (currentArrangementData == null) {
			logger.error("Unable to update. ArrangementData with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType(new Error("Unable to update. ArrangementData with id " + id + " not found.")),
					HttpStatus.NOT_FOUND);
		}
		ArrangementData toSave=null;
		toSave.setArrangementDataID (arrangementData.getArrangementDataID ());
		toSave.setArrangedByLastName (arrangementData.getArrangedByLastName());
		toSave.setArrangedByName (arrangementData.getArrangedByName ());
		toSave.setArrangerYearOfBirth (arrangementData.getArrangerYearOfBirth());
		toSave.setArrangerYearOfDeath (arrangementData.getArrangerYearOfDeath());
		toSave.setArrangedFor (arrangementData.getArrangedFor ());
		toSave.setArrangerId (arrangementData.getArrangerId ());
		toSave.setScoreTypeID (arrangementData.getScoreTypeID ());
		arrangementDataRepository.save (toSave);
		return new ResponseEntity<ArrangementData>(toSave, HttpStatus.OK);
	}

	//Delete a single arrangementData

	@DeleteMapping(value = "/deleteArrangementData/{id}")
	public ResponseEntity deleteArrangementData(@PathVariable("id") long id) {
	logger.info("Fetching & Deleting ArrangementData with id {}", id);

		ArrangementData arrangementData = arrangementDataRepository.getOne(id);
		if (arrangementData == null) {
			logger.error("Unable to delete. ArrangementData with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType(new Error("Unable to delete. ArrangementData with id " + id + " not found.")),
					HttpStatus.NOT_FOUND);
		}
		arrangementDataRepository.delete(arrangementData);
		return new ResponseEntity<ArrangementData>(HttpStatus.NO_CONTENT);
	}

	//Delete all arrangementData objects

	@DeleteMapping(value = "/deleteAll")
	public ResponseEntity<ArrangementData> deleteAllArrangementData() {
		logger.info("Deleting All ArrangementData");
		arrangementDataRepository.deleteAll();
		return new ResponseEntity<ArrangementData>(HttpStatus.NO_CONTENT);
	}

	public  boolean  checkIfDataExists(ArrangementData arrangementData) {

		List<ArrangementData> results = arrangementDataRepository.findAll();
		for (ArrangementData d : results) {
			if (d.getArrangementDataID().equals(arrangementData.getArrangementDataID()) && d.getArrangedByLastName().equals(arrangementData.getArrangedByLastName())
					&& d.getArrangedByName().equals (arrangementData.getArrangedByName()) && d.getArrangerId().equals(arrangementData.getArrangerId())
					&& d.getArrangedFor().equals(arrangementData.getArrangedFor ()) && d.getScoreTypeID()==(arrangementData.getScoreTypeID())
					) {
				return true;
			}

		}return false;
	}

}
