package com.migros.ServiceHealth.Service.impl;
import com.migros.ServiceHealth.Model.CheckServices;
import com.migros.ServiceHealth.Model.Services;
import org.springframework.boot.actuate.health.Health;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

public interface CheckStatusService {
    void saveService(Services services);
    void deleteService(long id);
    void updateService(Services services);
    Health a();
    Object addServices(String name,String url,String status, Date date);
    List<Services> allServices();
    List<Services> getServicesName();
    List<CheckServices> allCheckServices();
    void saveCheckService(CheckServices checkServices);






}
