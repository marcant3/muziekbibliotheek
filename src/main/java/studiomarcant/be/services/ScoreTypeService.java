package studiomarcant.be.services;

import studiomarcant.be.model.ScoreType;

public interface ScoreTypeService {
	
	public Object findAll();

	public ScoreType find(int id);

	public ScoreType find(String scoreWrittenFor);

	public ScoreType createScoreType(ScoreType scoreType);

	public ScoreType updateScoreType(ScoreType scoreType);

	public ScoreType deleteScoreType(ScoreType scoreType);

}
