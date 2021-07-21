package com.optima.prueba.view.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "optima")
public class PropertiesClient {
	
	private String endpoint;
	private String endpointPersistence;

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getEndpointPersistence() {
		return endpointPersistence;
	}

	public void setEndpointPersistence(String endpointPersistence) {
		this.endpointPersistence = endpointPersistence;
	}
	
	

}
