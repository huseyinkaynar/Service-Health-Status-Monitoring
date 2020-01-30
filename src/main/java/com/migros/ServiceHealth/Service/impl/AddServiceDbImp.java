package com.migros.ServiceHealth.Service.impl;

import com.migros.ServiceHealth.Model.Services;
import com.migros.ServiceHealth.Repositories.ServicesRepository;
import com.migros.ServiceHealth.Service.AddServiceDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddServiceDbImp implements AddServiceDb {
    @Autowired
    ServicesRepository servicesRepository;

    @Override
    public void addServices(String name,String url,String status, Date date) {
        Services services=new Services();
        services.setName(name);
        services.setUrl(url);
        services.setDate(date);
        services.setStatus(status);
        servicesRepository.save(services);

    }
}
