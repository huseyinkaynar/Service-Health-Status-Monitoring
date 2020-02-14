package com.migros.ServiceHealth.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "mail")
public class MailModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String toMail;
    @Column
    private String mailText;
    @Column
    private String mailSubject;





}
