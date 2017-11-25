package studiomarcant.be.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studiomarcant.be.dao.LocationDataDao;
import studiomarcant.be.model.LocationData;

@Service
public class LocationDataServiceImpl implements LocationDataService {

	@Autowired
	LocationDataDao dao;

	@Override
	public Object findAll() {
		Object foundList = dao.findAll();
		return foundList;
	}

	@Override
	public LocationData find(int id) {
		LocationData found = dao.findOne(id);
		return found;
	}

	@Override
	public LocationData find(String locationMedium) {
		LocationData found = null;
		List<LocationData> foundList = (ArrayList<LocationData>) dao.findAll();
		for (LocationData locationData : foundList) {
			if (locationData.getLocationMedium().equals(locationMedium)) {
				found = locationData;
			}
		}
		return found;
	}

	@Override
	public LocationData createLocationData(LocationData locationData) {
		dao.save(locationData);
		return locationData;
	}

	@Override
	public LocationData updateLocationData(LocationData locationData) {
		LocationData found = dao.findOne(locationData.getlocationDataID());
		dao.save(locationData);
		return found;
	}

	@Override
	public LocationData deleteLocationData(LocationData locationData) {
		LocationData found = dao.findOne(locationData.getlocationDataID());
		dao.delete(found);
		return found;
	}

}
