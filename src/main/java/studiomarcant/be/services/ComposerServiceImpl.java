package studiomarcant.be.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studiomarcant.be.dao.ComposerDao;
import studiomarcant.be.model.Composer;

@Service
public class ComposerServiceImpl implements ComposerService {

	@Autowired
	ComposerDao dao;

	@Override
	public Object findAll() {
		Object foundList = dao.findAll();
		return foundList;
	}

	@Override
	public Composer find(int id) {
		Composer found = dao.findOne(id);
		return found;
	}

	@Override
	public Composer find(String composerLastName) {
		Composer found = null;
		List<Composer> foundList = (ArrayList<Composer>) dao.findAll();
		for (Composer composer : foundList) {
			if (composer.getComposerLastName().equals(composerLastName)) {
				found = composer;
			}
		}
		return found;
	}

	@Override
	public Composer createComposer(Composer composer) {
		dao.save(composer);
		return composer;
	}

	@Override
	public Composer updateComposer(Composer composer) {
		Composer found = dao.findOne(composer.getComposerID());
		dao.save(composer);
		return found;
	}

	@Override
	public Composer deleteComposer(Composer composer) {
		Composer found = dao.findOne(composer.getComposerID());
		dao.delete(found);
		return found;
	}
}
