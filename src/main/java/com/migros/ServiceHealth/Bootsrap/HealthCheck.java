package com.migros.ServiceHealth.Bootsrap;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.*;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;


@Component
public class HealthCheck implements HealthIndicator {

    final String API_CHECK_URL = "http://www.omdbapi.com/?i=tt3896198&apikey=816468fd";

    @Override
    public Health health(){

        try {
        URI uri = new URI(API_CHECK_URL);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(uri, HttpMethod.GET, entity, Object.class);


        return Health.up().build();


        } catch (URISyntaxException e) {

        } catch (HttpClientErrorException e) {

            HttpStatus status = e.getStatusCode();

            String detail = status.equals(HttpStatus.UNAUTHORIZED) ? "Api key is invalid" : e.getLocalizedMessage();

            return Health.down()
                    .withDetail("code", status.value())
                    .withDetail("detail", detail).build();

        }

        return Health.down().withDetail("detail", "Couldn't reach the api").build();

    }


}
