package com.migros.ServiceHealth.Repositories;

import com.migros.ServiceHealth.Model.CheckServices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckServicesRepository extends JpaRepository<CheckServices,Long> {

}
