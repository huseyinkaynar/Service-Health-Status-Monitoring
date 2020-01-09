package com.migros.ServiceHealth.Service.impl;

import com.migros.ServiceHealth.Model.CheckServices;
import com.migros.ServiceHealth.Model.Services;
import com.migros.ServiceHealth.Model.ServicesDTO;
import com.migros.ServiceHealth.Repositories.CheckServicesRepository;
import com.migros.ServiceHealth.Repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.*;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

@Service
public class CheckStatusImpl implements CheckStatusService {


    @Autowired
    ServicesRepository servicesRepository;
    ServicesDTO servicesDTO=new ServicesDTO();
    CheckServices checkServices=new CheckServices();
    @Autowired
    CheckServicesRepository checkServicesRepository;





    @Override
    public List<CheckServices> allCheckServices() {
        return checkServicesRepository.findAll();
    }

    @Override
    public void saveCheckService(CheckServices checkServices) {
        checkServicesRepository.save(checkServices);

    }



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
    public List<Services> getServicesName(){
        return servicesRepository.findByName("services");


    }



    @Override
    public Object addServices(String name,String url,String status, Date date) {
        Services services=new Services();
        services.setName(name);
        services.setUrl(url);
        services.setDate(date);
        services.setStatus(status);
        servicesRepository.save(services);
        return "Saved.";
    }


    @Scheduled(fixedRate = 5000 )
    @Override
    public Health a() {

       final String API_CHECK_URL = servicesDTO.getServiceUrl();
        final String ServiceName =servicesDTO.getServiceName();

        Date date=new Date();
        try {
            URI uri = new URI(API_CHECK_URL);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Object> entity = new HttpEntity<>(headers);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.exchange(uri, HttpMethod.GET, entity, Object.class);

            addServices(ServiceName,API_CHECK_URL,"up",date);


            return Health.up().build();




        } catch (URISyntaxException e) {

        } catch (HttpClientErrorException e) {

            addServices(ServiceName,API_CHECK_URL,"down",date);
            return Health.down().build();

        }
        addServices(ServiceName,API_CHECK_URL,"down",date);
        return Health.down().build();

    }




}
