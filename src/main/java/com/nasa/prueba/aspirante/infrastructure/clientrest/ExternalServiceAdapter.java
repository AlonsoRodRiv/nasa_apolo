package com.nasa.prueba.aspirante.infrastructure.clientrest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nasa.prueba.aspirante.domain.dto.InformationDTO;
import com.nasa.prueba.aspirante.domain.ports.IExternalServicePort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;

@Component
public class ExternalServiceAdapter {
    private final RestTemplate restTemplate;
    @Value("${nasa.api.base-url}")
    private String baseUrl;
    private static final String SEARCH_ENDPOINT = "search";
    private static final String QUERY_PARAM = "q";

    public ExternalServiceAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public InformationDTO searchInformation(String queryParam) {
        try {
            String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                    .path(SEARCH_ENDPOINT)
                    .queryParam(QUERY_PARAM, queryParam)
                    .build()
                    .toUriString();

            return restTemplate.getForObject(url, InformationDTO.class);
        } catch (RestClientException e) {
            throw new RuntimeException("Error calling NASA API", e);
        }
    }
}
