package studiomarcant.be.services;

import studiomarcant.be.model.ScoreData;

public interface ScoreDataService {
	
	public Object findAll();

	public ScoreData find(int id);

	public ScoreData find(String description);

	public ScoreData createScoreData(ScoreData scoreData);

	public ScoreData updateScoreData(ScoreData scoreData);

	public ScoreData deleteScoreData(ScoreData scoreData);

}
