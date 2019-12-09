package com.migros.ServiceHealth.service;

import com.migros.ServiceHealth.Model.Services;
import org.springframework.boot.actuate.health.Health;

import java.util.List;

public interface CheckStatusService {
    void saveService(Services services);
    void deleteService(long id);
    void updateService(Services services);

    List<Services> allServices();


}