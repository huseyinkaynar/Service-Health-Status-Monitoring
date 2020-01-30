package com.migros.ServiceHealth.Service.impl;

import com.migros.ServiceHealth.Model.CheckServices;
import com.migros.ServiceHealth.Model.Services;
import com.migros.ServiceHealth.Repositories.CheckServicesRepository;
import com.migros.ServiceHealth.Repositories.ServicesRepository;
import com.migros.ServiceHealth.Service.AddServiceDb;
import com.migros.ServiceHealth.Service.CheckStatusService;
import com.migros.ServiceHealth.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.actuate.health.Health;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;

import org.springframework.scheduling.TaskScheduler;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;


@Service
public class CheckStatusImpl implements CheckStatusService {

    private final TaskScheduler executor;
    public CheckStatusImpl(TaskScheduler taskExecutor) {
        this.executor = taskExecutor;
    }
    @Autowired
    AddServiceDb addServiceDb;
    @Autowired
    ServicesRepository servicesRepository;
    @Autowired
    CheckServicesRepository checkServicesRepository;





    @Override
    public Page<Services> getServicesPage(Pageable pageable){
        Page<Services> resultPage=servicesRepository.findAll(pageable);

        return resultPage;

    }


    @Override
    public List<CheckServices> allCheckServices() {
        return checkServicesRepository.findAll();
    }

    @Override
    public void saveCheckService(CheckServices checkServices) {
        checkServicesRepository.save(checkServices);

    }


    @Override
    public List<Services> allServices() {

        return servicesRepository.findAll();
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
    public void checkServiceHealth(CheckServices checkServices) {
        final String API_CHECK_URL=checkServices.getServiceUrl();
        final String ServiceName=checkServices.getServiceName();

        Date date=new Date();
        try {
            URI uri = new URI(API_CHECK_URL);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Object> entity = new HttpEntity<>(headers);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.exchange(uri, HttpMethod.GET, entity, Object.class);


            addServiceDb.addServices(ServiceName,API_CHECK_URL,"up",date);



        } catch (URISyntaxException | HttpClientErrorException e) {
            addServiceDb.addServices(ServiceName,API_CHECK_URL,"down",date);



        } catch (ResourceAccessException e){


            addServiceDb.addServices(ServiceName,API_CHECK_URL,"hatalı url",date);

        }



    }



    @Override
    public void scheduling(CheckServices checkServices) {


            Runnable task  = () -> checkServiceHealth(checkServices);
            executor.scheduleAtFixedRate(task,checkServices.getTime());

    }




}
