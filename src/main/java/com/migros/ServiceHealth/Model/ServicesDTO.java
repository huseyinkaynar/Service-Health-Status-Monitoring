package com.migros.ServiceHealth.Model;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ServicesDTO {
    private long id;

    private String serviceUrl;
    private String serviceName;
    private long time;

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

}
