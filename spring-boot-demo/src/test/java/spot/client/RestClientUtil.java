package spot.client;
import java.net.URI;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import spot.entity.rw_spot;
public class RestClientUtil {
    public void getSpotByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/user/spot/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<rw_spot> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, rw_spot.class, 1);
        rw_spot spot = responseEntity.getBody();
        System.out.println("Id:"+spot.getSpotId()+", Client:"+spot.getClientId()
                 +", Spot Name:"+spot.getSpotName());      
    }
    public void getAllSpotsDemo() {
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/user/spots";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<rw_spot[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, rw_spot[].class);
        rw_spot[] spots = responseEntity.getBody();
        for(rw_spot spot : spots) {
            System.out.println("Id:"+spot.getSpotId()+", Client:"+spot.getClientId()
            	+", Spot Name:"+spot.getSpotName());      
        }
    }
    public void addSpotDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/user/spot";
	rw_spot objSpot = new rw_spot();
	objSpot.setClientId("Spring REST Security using Hibernate");
	objSpot.setSpotName("Spring");
        HttpEntity<rw_spot> requestEntity = new HttpEntity<rw_spot>(objSpot, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void updateSpotDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/spot";
	rw_spot objSpot = new rw_spot();
	objSpot.setSpotId(1);
	objSpot.setClientId("eSmartIT");
	objSpot.setSpotName("Prueba");
        HttpEntity<rw_spot> requestEntity = new HttpEntity<rw_spot>(objSpot, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deleteSpotDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/user/spot/{id}";
        HttpEntity<rw_spot> requestEntity = new HttpEntity<rw_spot>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        util.getSpotByIdDemo();
    	util.getAllSpotsDemo();
    	//util.addArticleDemo();
    	//util.updateArticleDemo();
    	//util.deleteArticleDemo();
    }    
} 