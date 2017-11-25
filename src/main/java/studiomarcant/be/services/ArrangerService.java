package studiomarcant.be.services;

import studiomarcant.be.model.Arranger;

public interface ArrangerService {
	
	public Object findAll();

	public Arranger find(int id);

	public Arranger find(String arrangerLastname);

	public Arranger createArranger(Arranger arranger);

	public Arranger updateArranger(Arranger arranger);

	public Arranger deleteArranger(Arranger arranger);

}
