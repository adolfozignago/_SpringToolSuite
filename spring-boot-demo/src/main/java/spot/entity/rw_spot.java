package spot.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="rw_spot")
public class rw_spot implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
        private int Id;  
	@Column(name="client_id")
        private String client_id;
	@Column(name="spot_name")	
	private String spot_name;
	public int getSpotId() {
		return Id;
	}
	public void setSpotId(int id) {
		this.Id = id;
	}
	public String getClientId() {
		return client_id;
	}
	public void setClientId(String client_id) {
		this.client_id = client_id;
	}
	public String getSpotName() {
		return spot_name;
	}
	public void setSpotName(String spot_name) {
		this.spot_name = spot_name;
	}
}  