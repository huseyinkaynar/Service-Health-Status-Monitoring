package com.migros.ServiceHealth.Repositories;

import com.migros.ServiceHealth.Model.GetService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GetServiceRepository extends JpaRepository<GetService,Long>{
}
