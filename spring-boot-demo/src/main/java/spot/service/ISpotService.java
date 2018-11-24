package spot.service;
import java.util.List;
import spot.entity.rw_spot;
public interface ISpotService {
     List<rw_spot> getAllSpots();
     rw_spot getSpotById(int spotId);
     boolean addSpot(rw_spot spot);
     void updateSpot(rw_spot spot);
     void deleteSpot(int spotId);
} 