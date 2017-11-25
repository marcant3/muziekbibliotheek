package studiomarcant.be.services;

import studiomarcant.be.model.LocationData;

public interface LocationDataService {

	public Object findAll();

	public LocationData find(int id);

	public LocationData find(String locationMedium);

	public LocationData createLocationData(LocationData locationData);

	public LocationData updateLocationData(LocationData locationData);

	public LocationData deleteLocationData(LocationData locationData);
}
