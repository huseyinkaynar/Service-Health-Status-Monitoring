package com.migros.ServiceHealth.Model;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "services")
public class services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private Date date;
    private  String status;



     public services(String xyz, String xyz1, String xyz2){
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


    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
