package org.acme;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Developer extends PanacheEntity {

    @Column public String name;
    @Column public int age;

}
