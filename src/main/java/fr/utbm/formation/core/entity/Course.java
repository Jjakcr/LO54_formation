package fr.utbm.formation.core.entity;
// Generated 26 nov. 2016 11:34:32 by Hibernate Tools 4.3.1

import javax.persistence.*;

/**
 * Course
 */
@Entity
@Table(name = "COURSE")
public class Course implements java.io.Serializable {

    @Id
    @Column(name = "CODE", unique = true, length = 16, nullable = false)
    private String code;

    @Column(name = "TITLE", length = 128, nullable = false)
    private String title;

    public Course() {
    }

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
