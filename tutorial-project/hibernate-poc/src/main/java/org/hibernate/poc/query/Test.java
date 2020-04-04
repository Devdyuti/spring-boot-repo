package org.hibernate.poc.query;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class Test {
	public static void main(String[] args) {
		Client client=ClientBuilder.newClient();
		WebTarget target=client.target("http://localhost:8280/user/findAll")
				.queryParam("cnt", "10")
			       .queryParam("mode", "json")
			       .queryParam("units", "metric");
		
	}
}
