package spot.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spot.entity.rw_spot;
@Transactional
@Repository
public class SpotDAO implements ISpotDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public rw_spot getSpotById(int spotId) {
		return entityManager.find(rw_spot.class, spotId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<rw_spot> getAllSpots() {
		String hql = "FROM rw_spot as s ORDER BY s.Id";
		return (List<rw_spot>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addSpot(rw_spot spot) {
		entityManager.persist(spot);
	}
	@Override
	public void updateSpot(rw_spot spot) {
		rw_spot spt = getSpotById(spot.getSpotId());
		spt.setClientId(spot.getClientId());
		spt.setSpotName(spot.getSpotName());
		entityManager.flush();
	}
	@Override
	public void deleteSpot(int spotId) {
		entityManager.remove(getSpotById(spotId));
	}
	@Override
	public boolean spotExists(String client_id, String spot_name) {
		String hql = "FROM rw_spot as s WHERE s.client_id = ? and s.spot_name = ?";
		int count = entityManager.createQuery(hql).setParameter(1, client_id)
		              .setParameter(2, spot_name).getResultList().size();
		return count > 0 ? true : false;
	}
} 