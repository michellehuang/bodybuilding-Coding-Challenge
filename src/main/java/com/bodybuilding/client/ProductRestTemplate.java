package com.bodybuilding.client;

import java.net.URI;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class ProductRestTemplate {
	
    protected RestTemplate restTemplate;

    /**
     * Method to provide the base URL to communicate with the server in question for the RESTful APIs.
     *
     * @return representing the base URL the services.
     */
	public String getBaseUrl() {

		return "http://api.bodybuilding.com";
	}


    /**
     * Wrapper method around Spring's org.springframework.web.client.RestTemplate#getForEntity(java.net.URI, Class) method. Kind of convoluted
     * since the method actually uses org.springframework.web.client.RestTemplate#exchange(String, org.springframework.http.HttpMethod, org.springframework.http.HttpEntity, Class, java.util.Map) to make
     * the API call. The purpose of this functionality is to include the ability to add headers to a get request.
     *
     * @param subPathUrl   Path to the resources requested.
     * @param responseType Type of object that is requested back from the call.
     * @param <T>          Type of object that will be returned in the response.
     * @return org.springframework.http.ResponseEntity object containing status codes and entity that was requested.
     */
    public <T> ResponseEntity<T> getForEntity(String subPathUrl, Class<T> responseType) {
        // Building out the URL's base.
        final UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(getBaseUrl()).path(subPathUrl);

        // Finish building the URL for use.
        final URI url = builder.build().toUri();

        // Setting the additional headers into the request.
        HttpEntity<String> entity = null;
        HttpHeaders httpHeaders = new HttpHeaders();
        
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        entity = new HttpEntity<String>(httpHeaders);

        ResponseEntity<T> response;
        try {
        	restTemplate = new RestTemplate();
            response = restTemplate.exchange(url, HttpMethod.GET, entity, responseType);
        } catch (HttpClientErrorException exception) {
            response = new ResponseEntity<>(exception.getStatusCode());
        } catch (ResourceAccessException exception) {
            response = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }

        return response;
    }
	

}
