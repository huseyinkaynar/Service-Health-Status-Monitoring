package com.migros.ServiceHealth.Bootsrap;

import com.migros.ServiceHealth.Model.services;
import com.migros.ServiceHealth.Repositories.ServicesRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootsrap implements ApplicationListener<ContextRefreshedEvent> {
    private ServicesRepository servicesRepository;

    public DevBootsrap(ServicesRepository servicesRepository){
        this.servicesRepository=servicesRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        services.url a=new url;


    }



}
