package com.onlinevotingsystem.ovs.captcha;

import java.net.URI;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

public class restClient implements RestOperations {

	@Bean
	public RestTemplate restClient(RestTemplateBuilder builder) {
	   // Do any additional configuration here
	   return builder.build();
	}
	@Override
	public <T> T getForObject(String url, Class<T> responseType, Object... uriVariables) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getForObject(String url, Class<T> responseType, Map<String, ?> uriVariables)
			throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getForObject(URI url, Class<T> responseType) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Object... uriVariables)
			throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Map<String, ?> uriVariables)
			throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> ResponseEntity<T> getForEntity(URI url, Class<T> responseType) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpHeaders headForHeaders(String url, Object... uriVariables) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpHeaders headForHeaders(String url, Map<String, ?> uriVariables) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpHeaders headForHeaders(URI url) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URI postForLocation(String url, Object request, Object... uriVariables) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URI postForLocation(String url, Object request, Map<String, ?> uriVariables) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URI postForLocation(URI url, Object request) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T postForObject(String url, Object request, Class<T> responseType, Object... uriVariables)
			throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T postForObject(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables)
			throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T postForObject(URI url, Object request, Class<T> responseType) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> ResponseEntity<T> postForEntity(String url, Object request, Class<T> responseType,
			Object... uriVariables) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> ResponseEntity<T> postForEntity(String url, Object request, Class<T> responseType,
			Map<String, ?> uriVariables) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> ResponseEntity<T> postForEntity(URI url, Object request, Class<T> responseType)
			throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(String url, Object request, Object... uriVariables) throws RestClientException {
		// TODO Auto-generated method stub

	}

	@Override
	public void put(String url, Object request, Map<String, ?> uriVariables) throws RestClientException {
		// TODO Auto-generated method stub

	}

	@Override
	public void put(URI url, Object request) throws RestClientException {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T patchForObject(String url, Object request, Class<T> responseType, Object... uriVariables)
			throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T patchForObject(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables)
			throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T patchForObject(URI url, Object request, Class<T> responseType) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String url, Object... uriVariables) throws RestClientException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String url, Map<String, ?> uriVariables) throws RestClientException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(URI url) throws RestClientException {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<HttpMethod> optionsForAllow(String url, Object... uriVariables) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<HttpMethod> optionsForAllow(String url, Map<String, ?> uriVariables) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<HttpMethod> optionsForAllow(URI url) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity,
			Class<T> responseType, Object... uriVariables) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity,
			Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> ResponseEntity<T> exchange(URI url, HttpMethod method, HttpEntity<?> requestEntity,
			Class<T> responseType) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity,
			ParameterizedTypeReference<T> responseType, Object... uriVariables) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity,
			ParameterizedTypeReference<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> ResponseEntity<T> exchange(URI url, HttpMethod method, HttpEntity<?> requestEntity,
			ParameterizedTypeReference<T> responseType) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> ResponseEntity<T> exchange(RequestEntity<?> requestEntity, Class<T> responseType)
			throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> ResponseEntity<T> exchange(RequestEntity<?> requestEntity, ParameterizedTypeReference<T> responseType)
			throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T execute(String url, HttpMethod method, RequestCallback requestCallback,
			ResponseExtractor<T> responseExtractor, Object... uriVariables) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T execute(String url, HttpMethod method, RequestCallback requestCallback,
			ResponseExtractor<T> responseExtractor, Map<String, ?> uriVariables) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T execute(URI url, HttpMethod method, RequestCallback requestCallback,
			ResponseExtractor<T> responseExtractor) throws RestClientException {
		// TODO Auto-generated method stub
		return null;
	}

}
