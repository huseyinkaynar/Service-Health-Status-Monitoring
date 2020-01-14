package com.migros.ServiceHealth.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CheckServices")
@Getter
@Setter
public class GetService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String getServiceName;
}
