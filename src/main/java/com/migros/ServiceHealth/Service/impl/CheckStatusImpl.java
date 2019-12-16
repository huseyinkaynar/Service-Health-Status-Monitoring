package com.migros.ServiceHealth.Service.impl;

import com.migros.ServiceHealth.Model.Services;
import com.migros.ServiceHealth.Model.ServicesDTO;
import com.migros.ServiceHealth.Repositories.ServicesRepository;
import com.migros.ServiceHealth.Service.CheckStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
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
    ServicesDTO servicesDTO=new ServicesDTO();



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
    public Object addServices(String url,String status, Date date) {
        Services services=new Services();
        services.setUrl(url);
        services.setDate(date);
        services.setStatus(status);
        servicesRepository.save(services);
        return "Saved.";
    }


    @Override
    @Scheduled(fixedRate = 6000)
    public Health health() {
        final String API_CHECK_URL = servicesDTO.getServiceUrl();


        Date date=new Date();
        try {
            URI uri = new URI(API_CHECK_URL);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Object> entity = new HttpEntity<>(headers);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.exchange(uri, HttpMethod.GET, entity, Object.class);

            addServices(API_CHECK_URL,"up",date);


            return Health.up().build();




        } catch (URISyntaxException e) {

        } catch (HttpClientErrorException e) {

            addServices(API_CHECK_URL,"down",date);
            return Health.down().build();

        }
        addServices(API_CHECK_URL,"down",date);
        return Health.down().build();
    }



}
