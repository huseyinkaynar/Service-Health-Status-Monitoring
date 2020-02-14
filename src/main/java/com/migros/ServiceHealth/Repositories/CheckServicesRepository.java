package com.migros.ServiceHealth.Repositories;

import com.migros.ServiceHealth.Model.CheckServicesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckServicesRepository extends JpaRepository<CheckServicesModel,Long> {

}
