package fr.utbm.formation.core.entity;
// Generated 26 nov. 2016 11:34:32 by Hibernate Tools 4.3.1

import javax.persistence.*;

/**
 * Location
 */
@Entity
@Table(name = "LOCATION")
public class Location implements java.io.Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, length = 10, nullable = false)
    private int id;

    @Column(name = "CITY", length = 50, nullable = false)
    private String city;

    public Location() {
    }

    public Location(String city) {

        this.city = city;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
