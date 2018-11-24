package spot.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;
import spot.entity.rw_spot;
import spot.service.ISpotService;
@Controller
@RequestMapping("user")
public class SpotController {
	@Autowired
	private ISpotService spotService;
	@GetMapping("spot/{id}")
	public ResponseEntity<rw_spot> getSpotById(@PathVariable("id") Integer id) {
		rw_spot spot = spotService.getSpotById(id);
		return new ResponseEntity<rw_spot>(spot, HttpStatus.OK);
	}
	@GetMapping("spots")
	public ResponseEntity<List<rw_spot>> getAllSpots() {
		List<rw_spot> list = spotService.getAllSpots();
		return new ResponseEntity<List<rw_spot>>(list, HttpStatus.OK);
	}
	@PostMapping("spot")
	public ResponseEntity<Void> addSpot(@RequestBody rw_spot spot, UriComponentsBuilder builder) {
                boolean flag = spotService.addSpot(spot);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/spot/{id}").buildAndExpand(spot.getSpotId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("spot")
	public ResponseEntity<rw_spot> updateSpot(@RequestBody rw_spot spot) {
		spotService.updateSpot(spot);
		return new ResponseEntity<rw_spot>(spot, HttpStatus.OK);
	}
	@DeleteMapping("spot/{id}")
	public ResponseEntity<Void> deleteSpot(@PathVariable("id") Integer id) {
		spotService.deleteSpot(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}  