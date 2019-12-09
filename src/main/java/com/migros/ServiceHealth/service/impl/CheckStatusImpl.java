package com.migros.ServiceHealth.service.impl;

import com.migros.ServiceHealth.Model.Services;
import com.migros.ServiceHealth.Repositories.ServicesRepository;
import com.migros.ServiceHealth.service.CheckStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CheckStatusImpl implements CheckStatusService {

    @Autowired
    ServicesRepository servicesRepository;


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




}
