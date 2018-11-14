/*
package studiomarcant.be.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import studiomarcant.be.model.Composer;
import studiomarcant.be.services.ComposerService;

//@RestController
//@RequestMapping(value = "/")
//public class  ComposerController {

	//@Autowired
	*//*ComposerService service;

	@GetMapping(value = "/showall")
	public Object showAll() {
		Object foundList = service.findAll();
		return foundList;
	}*//*

	@GetMapping(value = "/ComposerID/{id}")
	public Composer showById(@PathVariable int id) {
		Composer found = service.find(id);
		return found;
	}

	@GetMapping(value = "/Composer/{lastname}")
	public Composer show(@PathVariable String lastname) {
		Composer found = service.find(lastname);
		return found;
	}

	@PostMapping(value = "/create")
	@Transactional
	@ResponseBody
	public Composer create(@RequestBody Composer composer) {
		Composer toCreate = new Composer();
		toCreate.setComposerLastname(composer.getComposerLastName());
		toCreate.setComposerNames(composer.getComposerNames());
		toCreate.setComposerYearOfBirth(composer.getComposerYearOfBirth());
		toCreate.setComposerYearOfDeath(composer.getComposerYearOfDeath());
		toCreate.setComposerNationality(composer.getComposerNationality());
		service.createComposer(toCreate);
		return toCreate;
	}

	@PostMapping(value = "/update/{id}")
	@Transactional
	@ResponseBody
	public Composer update(@PathVariable int id, @RequestBody Composer composer) {
		Composer toUpdate = service.find(id);
		toUpdate.setComposerLastname(composer.getComposerLastName());
		toUpdate.setComposerNames(composer.getComposerNames());
		toUpdate.setComposerYearOfBirth(composer.getComposerYearOfBirth());
		toUpdate.setComposerYearOfDeath(composer.getComposerYearOfDeath());
		toUpdate.setComposerNationality(composer.getComposerNationality());
		service.updateComposer(toUpdate);
		return toUpdate;
	}
	
	@RequestMapping(value = "/delete/{id}")
	@ResponseBody
	public Composer delete(@PathVariable int id) {
		Composer toDelete = service.find(id);
		service.deleteComposer(toDelete);
		return toDelete;
	}

}
*/
