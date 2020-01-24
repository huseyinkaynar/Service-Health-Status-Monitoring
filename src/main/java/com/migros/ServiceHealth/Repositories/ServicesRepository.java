package com.migros.ServiceHealth.Repositories;
import com.migros.ServiceHealth.Model.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200/")
public interface ServicesRepository extends JpaRepository<Services,Long> {

    Optional<Services> findById(Long id);
    Page<Services> findAll(Pageable pageable);


}
