package springmvc;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import model.User;

public class SpringRestTestClient {

	public static final String REST_SERVICE_URI = "http://localhost:8080/Spring4MVC";

	@SuppressWarnings("unchecked")
	private static void listAllUsers() {
		System.out.println("Testing ListAllUsers API");

		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI + "/user/",
				List.class);

		if (usersMap != null) {
			for (LinkedHashMap<String, Object> map : usersMap) {
				System.out.println("User : id=" + map.get("id") + ",Name=" + map.get("name") + ",Age=" + map.get("age")
						+ ", Salary=" + map.get("salary"));
			}
		} else {
			System.out.println("No user exist");
		}
	}

	private static void getUser() {
		System.out.println("Testing getUser API");
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject(REST_SERVICE_URI + "/user/1", User.class);
		System.out.println(user);
	}

	private static void createUser() {
		System.out.println("Teating create User API");
		RestTemplate restTemplate = new RestTemplate();
		User user = new User(0, "Giri", 27, 50000);
		URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/user/", user, User.class);
		System.out.println("Location : " + uri.toASCIIString());
	}

	private static void updateUser() {
		System.out.println("Testing update User API");
		RestTemplate restTemplate = new RestTemplate();
		User user = new User(1, "Jerry", 26, 15000);
		restTemplate.put(REST_SERVICE_URI + "/user/1", user);
		System.out.println(user);
	}

	private static void deleteUser() {
		System.out.println("Testing all delete Users API");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI + "/user/3");
	}

	private static void deleteAllUsers() {
		System.out.println("Testing all delete Users API");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI + "/user/");
	}

	public static void main(String args[]) {
		listAllUsers();
		getUser();
		createUser();
		listAllUsers();
		updateUser();
		listAllUsers();
		deleteUser();
		listAllUsers();
		deleteAllUsers();
		listAllUsers();

	}
}