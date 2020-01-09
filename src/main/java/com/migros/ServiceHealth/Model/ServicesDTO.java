package com.migros.ServiceHealth.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;


@Getter
@Setter
public class ServicesDTO {
    private long id;

    private String serviceUrl="http://localhost:8080/actuator";
    private String serviceName="actuator";
    private int time=6000;




}
