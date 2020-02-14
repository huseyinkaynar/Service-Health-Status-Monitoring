package com.migros.ServiceHealth.Service;
import com.migros.ServiceHealth.Model.CheckServicesModel;
import com.migros.ServiceHealth.Model.ServicesModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface CheckStatusService {
    void saveService(ServicesModel servicesModel);
    void deleteService(long id);
    void checkServiceHealth(CheckServicesModel checkServicesModel);
    void saveCheckService(CheckServicesModel checkServicesModel);
    void scheduling(CheckServicesModel checkServicesModel);
    void addServices(String name,String url,String status, Date date);

    List<CheckServicesModel> allCheckServices();
    Page<ServicesModel> getServicesPage(Pageable pageable);
    Page<ServicesModel> getSearchServicesPage(String name, Pageable pageable);
    List<ServicesModel> allServices();









}
