package com.migros.ServiceHealth.Service.impl;

import com.migros.ServiceHealth.Model.CheckServicesModel;
import com.migros.ServiceHealth.Model.ServicesModel;
import com.migros.ServiceHealth.Repositories.CheckServicesRepository;
import com.migros.ServiceHealth.Repositories.ServicesRepository;
import com.migros.ServiceHealth.Service.CheckStatusService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;

import org.springframework.scheduling.TaskScheduler;

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
    ServicesRepository servicesRepository;
    @Autowired
    CheckServicesRepository checkServicesRepository;

    @Override
    public Page<ServicesModel> getServicesPage(Pageable pageable){

        return servicesRepository.findAll(pageable);

    }
    public List<ServicesModel> allServices() {
        return servicesRepository.findAll();
    }



    @Override
    public void saveService(ServicesModel servicesModel) {
        servicesRepository.save(servicesModel);

    }

    @Override
    public void deleteService(long id) {
        servicesRepository.deleteById(id);

    }

    @Override
    public List<CheckServicesModel> allCheckServices() {
        return checkServicesRepository.findAll();
    }

    @Override
    public void saveCheckService(CheckServicesModel checkServicesModel) {
        checkServicesRepository.save(checkServicesModel);

    }
    @Override
    public Page<ServicesModel> getSearchServices(String name,Pageable pageable) {

        return servicesRepository.findByNameQuery(name,pageable);
    }


    @Override
    public void addServices(String name, String url, String status, Date date) {
        ServicesModel servicesModel =new ServicesModel();
        servicesModel.setName(name);
        servicesModel.setUrl(url);
        servicesModel.setDate(date);
        servicesModel.setStatus(status);
        servicesRepository.save(servicesModel);

    }

    @Override
    public void checkServiceHealth(CheckServicesModel checkServicesModel) {
        final String API_CHECK_URL= checkServicesModel.getServiceUrl();
        final String ServiceName= checkServicesModel.getServiceName();




        Date date=new Date();
        try {
            URI uri = new URI(API_CHECK_URL);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Object> entity = new HttpEntity<>(headers);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.exchange(uri, HttpMethod.GET, entity, Object.class);

            addServices(ServiceName,API_CHECK_URL,"up",date);



        } catch (URISyntaxException | HttpClientErrorException e) {
            addServices(ServiceName,API_CHECK_URL,"down",date);



        } catch (ResourceAccessException e){


        }

    }




    @Override
    public void scheduling(CheckServicesModel checkServicesModel) {


            Runnable task  = () -> checkServiceHealth(checkServicesModel);
            executor.scheduleAtFixedRate(task, checkServicesModel.getTime());

    }


}
