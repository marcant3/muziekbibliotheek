package studiomarcant.be.services;

import studiomarcant.be.model.ArrangementData;

public interface ArrangementDataService {
	
	public Object findAll();
	
	public ArrangementData find(int id);
	
	public  ArrangementData find(String arrangedByName);
	
	public ArrangementData createArrangementData(ArrangementData arrangementData);	
	
	public ArrangementData updateArrangementData(ArrangementData arrangementData);
	
	public ArrangementData deleteArrangementData(ArrangementData arrangementData);

}
