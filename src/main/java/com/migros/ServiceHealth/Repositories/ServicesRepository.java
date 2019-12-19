package com.migros.ServiceHealth.Repositories;

import com.migros.ServiceHealth.Model.Services;
import org.omg.CORBA.Object;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServicesRepository extends JpaRepository<Services,Long> {

    Optional<Services> findById(Long id);
    List<Services> findByName(String name);


}
