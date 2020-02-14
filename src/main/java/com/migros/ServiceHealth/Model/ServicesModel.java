package com.migros.ServiceHealth.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
@Table(name = "Services")
public class ServicesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String url;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;
    @Column
    private  String status;





}
