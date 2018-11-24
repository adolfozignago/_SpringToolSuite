package spot.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spot.dao.ISpotDAO;
import spot.entity.rw_spot;
@Service
public class SpotService implements ISpotService {
	@Autowired
	private ISpotDAO spotDAO;
	@Override
	public rw_spot getSpotById(int spotId) {
		rw_spot obj = spotDAO.getSpotById(spotId);
		return obj;
	}	
	@Override
	public List<rw_spot> getAllSpots(){
		return spotDAO.getAllSpots();
	}
	@Override
	public synchronized boolean addSpot(rw_spot spot){
                if (spotDAO.spotExists(spot.getClientId(), spot.getSpotName())) {
    	            return false;
                } else {
    	            spotDAO.addSpot(spot);
    	            return true;
                }
	}
	@Override
	public void updateSpot(rw_spot spot) {
		spotDAO.updateSpot(spot);
	}
	@Override
	public void deleteSpot(int spotId) {
		spotDAO.deleteSpot(spotId);
	}
} 