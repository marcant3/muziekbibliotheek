package studiomarcant.be.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studiomarcant.be.dao.ArrangerDao;
import studiomarcant.be.model.Arranger;

@Service
public class ArrangerServiceImpl implements ArrangerService {

	@Autowired
	ArrangerDao dao;	
	
	@Override
	public Object findAll() {
		Object foundList = dao.findAll();
		return foundList;
	}

	@Override
	public Arranger find(int id) {
		Arranger found = dao.findOne(id);
		return found;
	}

	@Override
	public Arranger find(String arrangerLastName) {
		Arranger found = null;
		List<Arranger> foundList = (ArrayList<Arranger>) dao.findAll();
		for (Arranger arranger : foundList) {
			if (arranger.getArrangerLastname().equals(arrangerLastName)) {
				found = arranger;
			}
		}
		return found;
	}

	@Override
	public Arranger createArranger(Arranger arranger) {
		dao.save(arranger);
		return arranger;
	}

	@Override
	public Arranger updateArranger(Arranger arranger) {
		Arranger found = dao.findOne(arranger.getArrangerID());
		dao.save(arranger);
		return found;
	}

	@Override
	public Arranger deleteArranger(Arranger arranger) {
		Arranger found = dao.findOne(arranger.getArrangerID());
		dao.delete(found);
		return found;
	}

}
