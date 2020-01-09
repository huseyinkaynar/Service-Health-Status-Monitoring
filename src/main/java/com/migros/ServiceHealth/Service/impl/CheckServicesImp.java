/*package com.migros.ServiceHealth.Service.impl;

import com.migros.ServiceHealth.Model.CheckServices;
import com.migros.ServiceHealth.Model.Services;
import com.migros.ServiceHealth.Repositories.CheckServicesRepository;
import com.migros.ServiceHealth.Repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CheckServicesImp implements CheckServicesService {

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


}
*/