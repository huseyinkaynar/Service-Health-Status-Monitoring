package com.migros.ServiceHealth.Service.impl;

import com.migros.ServiceHealth.Model.CheckServices;
import com.migros.ServiceHealth.Model.GetService;
import com.migros.ServiceHealth.Model.Services;
import com.migros.ServiceHealth.Repositories.CheckServicesRepository;
import com.migros.ServiceHealth.Repositories.GetServiceRepository;
import com.migros.ServiceHealth.Repositories.ServicesRepository;
import com.migros.ServiceHealth.Service.CheckStatusService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.*;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

@Service
public class CheckStatusImpl implements CheckStatusService{


    @Autowired
    ServicesRepository servicesRepository;
    @Autowired
    CheckServicesRepository checkServicesRepository;
    @Autowired
    GetServiceRepository getServiceRepository;






    @Override
    public List<CheckServices> allCheckServices() {
        return checkServicesRepository.findAll();
    }

    @Override
    public void saveCheckService(CheckServices checkServices) {
        checkServicesRepository.save(checkServices);

    }

    @Override
    public void saveGetService(GetService getService) {
        getServiceRepository.save(getService);


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
    public List<Services> allServices() {

        return servicesRepository.findAll();
    }
    @Override
    public List<Services> getServicesName(){

        return servicesRepository.findByName("actuator");


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


    @Override
    @Scheduled(fixedRate = 5000 )
    public void checkServiceHealth()  {
        List<CheckServices> serviceList=checkServicesRepository.findAll();
        serviceList.forEach((a)->{

            final String API_CHECK_URL =a.getServiceUrl();
            final String ServiceName =a.getServiceName();

            Date date=new Date();
            try {
                URI uri = new URI(API_CHECK_URL);
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                HttpEntity<Object> entity = new HttpEntity<>(headers);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.exchange(uri, HttpMethod.GET, entity, Object.class);

                addServices(ServiceName,API_CHECK_URL,"up",date);


            } catch (URISyntaxException e) {addServices(ServiceName,API_CHECK_URL,"down",date);

            } catch (HttpClientErrorException e) {

                addServices(ServiceName,API_CHECK_URL,"down",date);

            }catch (ResourceAccessException e){
                addServices(ServiceName,API_CHECK_URL,"hatalı url",date);

            }
        });

    }


}
