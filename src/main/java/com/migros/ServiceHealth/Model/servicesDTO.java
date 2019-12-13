package com.migros.ServiceHealth.Model;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class servicesDTO {
    private long id;

    private String serviceUrl="http://www.omdbapi.com/?i=tt3896198&apikey=816468fd1";
    private String serviceName;
    private long time;

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

}
