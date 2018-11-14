package studiomarcant.be.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studiomarcant.be.dao.ArrangementDataDao;
import studiomarcant.be.model.ArrangementData;

@Service
public class ArrangementDataServiceImpl implements ArrangementDataService {
	@Autowired
	ArrangementDataDao dao;

	public static List<ArrangementData> arrangements;

	@Override
	public  List<ArrangementData> findAll() {
		List<ArrangementData> foundList = dao.findAll();
		return foundList;
	}

	@Override
	public ArrangementData findById (int id) {
		ArrangementData found = dao.findOne(id);
		return found;
	}

	@Override
	public ArrangementData findByName (String arrangedByName) {
		ArrangementData found = null;
		List<ArrangementData> foundList = (ArrayList<ArrangementData>) dao.findAll();
		for (ArrangementData arrangementData : foundList) {
			if (arrangementData.getArrangedByName().equals(arrangedByName)) {
				found = arrangementData;
			}
		}
		return found;
	}


	@Override
	public ArrangementData createArrangementData(ArrangementData arrangementData) {
		dao.save(arrangementData);
		return arrangementData;
	}

	@Override
	public ArrangementData updateArrangementData(ArrangementData arrangementData) {
		ArrangementData found = dao.findOne(Math.toIntExact (arrangementData.getArrangementDataID ()));
		dao.save(arrangementData);
		return found;
	}

	@Override
	public ArrangementData deleteArrangementData(ArrangementData arrangementData) {
		ArrangementData found = dao.findOne(Math.toIntExact (arrangementData.getArrangementDataID ()));
		dao.delete(found);
		return found;
	}

}
