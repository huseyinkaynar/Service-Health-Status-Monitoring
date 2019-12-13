/*package com.migros.ServiceHealth.Model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "serviceUrl")
public class ServiceUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String url;

    public Long getId() {
        return id;
    }

    @OneToMany(mappedBy = "serviceUrl")
    private Set<Services> services;

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
*/