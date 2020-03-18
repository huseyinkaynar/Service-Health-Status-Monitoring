package com.migros.ServiceHealth.SearchQueries;

public interface Queries {
    interface Query {

        final String serviceSearch = "select * from services where lower(name) like lower(concat('%',:name,'%'))";

        final String statusSearch = "select * from services where lower(company_name) like lower(concat('%',:status,'%'))";

    }
}
