package studiomarcant.be.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studiomarcant.be.dao.ScoreDataDao;
import studiomarcant.be.model.ScoreData;

@Service
public class ScoreDataServiceImpl implements ScoreDataService {

	@Autowired
	ScoreDataDao dao;

	@Override
	public Object findAll() {
		Object foundList = dao.findAll();
		return foundList;
	}

	@Override
	public ScoreData find(int id) {
		ScoreData found = dao.findOne(id);
		return found;
	}

	@Override
	public ScoreData find(String description) {
		ScoreData found = null;
		List<ScoreData> foundList = (ArrayList<ScoreData>) dao.findAll();
		for (ScoreData scoreData : foundList) {
			if (scoreData.getDescription().equals(description)) {
				found = scoreData;
			}
		}
		return found;
	}

	@Override
	public ScoreData createScoreData(ScoreData scoreData) {
		dao.save(scoreData);
		return scoreData;
	}

	@Override
	public ScoreData updateScoreData(ScoreData scoreData) {
		ScoreData found = dao.findOne(scoreData.getScoreID());
		dao.save(scoreData);
		return found;
	}

	@Override
	public ScoreData deleteScoreData(ScoreData scoreData) {
		ScoreData found = dao.findOne(scoreData.getScoreID());
		dao.delete(found);
		return found;
	}
}
