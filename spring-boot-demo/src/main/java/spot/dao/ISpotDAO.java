package spot.dao;
import java.util.List;
import spot.entity.rw_spot;
public interface ISpotDAO {
    List<rw_spot> getAllSpots();
    rw_spot getSpotById(int spotId);
    void addSpot(rw_spot spot);
    void updateSpot(rw_spot spot);
    void deleteSpot(int spotId);
    boolean spotExists(String client_id, String spot_name);
} 