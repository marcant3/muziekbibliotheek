package studiomarcant.be.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studiomarcant.be.dao.ScoreTypeDao;
import studiomarcant.be.model.ScoreType;

@Service
public class ScoreTypeServiceImpl implements ScoreTypeService {

	@Autowired
	ScoreTypeDao dao;

	@Override
	public Object findAll() {
		Object foundList = dao.findAll();
		return foundList;
	}

	@Override
	public ScoreType find(int id) {
		ScoreType found = dao.findOne(id);
		return found;
	}

	@Override
	public ScoreType find(String scoreWrittenFor) {
		ScoreType found = null;
		List<ScoreType> foundList = (ArrayList<ScoreType>) dao.findAll();
		for (ScoreType scoreType : foundList) {
			if (scoreType.getScoreWrittenFor().equals(scoreWrittenFor)) {
				found = scoreType;
			}
		}
		return found;
	}

	@Override
	public ScoreType createScoreType(ScoreType scoreType) {
		dao.save(scoreType);
		return scoreType;
	}

	@Override
	public ScoreType updateScoreType(ScoreType scoreType) {
		ScoreType found = dao.findOne(scoreType.getScoreTypeID());
		dao.save(scoreType);
		return found;
	}

	@Override
	public ScoreType deleteScoreType(ScoreType scoreType) {
		ScoreType found = dao.findOne(scoreType.getScoreTypeID());
		dao.delete(found);
		return found;
	}
}
