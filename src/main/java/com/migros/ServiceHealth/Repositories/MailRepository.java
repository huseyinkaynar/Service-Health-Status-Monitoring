package com.migros.ServiceHealth.Repositories;

import com.migros.ServiceHealth.Model.MailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<MailModel,Long> {
}
