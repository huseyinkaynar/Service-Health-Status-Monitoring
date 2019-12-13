package com.migros.ServiceHealth.service.impl;

import com.migros.ServiceHealth.Model.Services;
import com.migros.ServiceHealth.Model.servicesDTO;
import com.migros.ServiceHealth.Repositories.ServicesRepository;
import com.migros.ServiceHealth.service.CheckStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

@Service
public class CheckStatusImpl implements CheckStatusService ,HealthIndicator{


    @Autowired
    ServicesRepository servicesRepository;
    servicesDTO servicesDTO=new servicesDTO();
    Services services=new Services();
    Date date=new Date();


    @Override
    public void saveService(Services services) {
        servicesRepository.save(services);

    }

    @Override
    public void deleteService(long id) {
        servicesRepository.deleteById(id);

    }

    @Override
    public void updateService(Services services) {

    }



    @Override
    public List<Services> allServices() {

        return servicesRepository.findAll();
    }




    @Override
    public Health health() {
        final String API_CHECK_URL = servicesDTO.getServiceUrl();

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

            return Health.down().build();

        }

        return Health.down().build();
    }
}
