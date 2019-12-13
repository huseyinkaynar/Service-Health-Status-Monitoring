package com.migros.ServiceHealth.Model;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Services")
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String url;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;
    @Column
    private  String status;

   /* @ManyToOne
    @JoinColumn(name = "urlId", nullable = false)
    private  ServiceUrl serviceUrl;*/



    public Services(){
    }
    public Services(String url, Date date, String status){
        this.date=date;
        this.status=status;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
/*
    public ServiceUrl getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(ServiceUrl serviceUrl) {
        this.serviceUrl = serviceUrl;
    }*/
}
