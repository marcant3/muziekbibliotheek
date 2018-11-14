package studiomarcant.be.services;

import studiomarcant.be.model.ArrangementData;

import java.util.List;

public interface ArrangementDataService {
	
	List<ArrangementData> findAll();
	
	ArrangementData findById(int id);
	
	ArrangementData findByName(String arrangedByName);
	
	ArrangementData createArrangementData(ArrangementData arrangementData);
	
	ArrangementData updateArrangementData(ArrangementData arrangementData);
	
	ArrangementData deleteArrangementData(ArrangementData arrangementData);

}
