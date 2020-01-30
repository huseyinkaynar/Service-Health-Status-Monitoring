package com.migros.ServiceHealth.Service;

import java.util.Date;

public interface AddServiceDb {
    void addServices(String name,String url,String status, Date date);
}
