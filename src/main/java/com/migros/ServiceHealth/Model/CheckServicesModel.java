package com.migros.ServiceHealth.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CheckServices")
@Getter
@Setter
public class CheckServicesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String serviceName;
    @NotNull
    private String serviceUrl;
    @NotNull
    private long time;



}
