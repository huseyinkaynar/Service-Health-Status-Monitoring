package com.migros.ServiceHealth.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class servicesDTO {
    @Id
    private long id;
    @NotEmpty
    private String serviceUrl="http://www.omdbapi.com/?i=tt3896198&apikey=816468fd1";
    @NotEmpty
    private String serviceName;
    @NotNull
    private long time;

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }
}
