package fr.utbm.formation.core.entity;
// Generated 26 nov. 2016 11:34:32 by Hibernate Tools 4.3.1

import javax.persistence.*;

/**
 * Class Client with anotation JPA
 */
@Entity
@Table(name = "CLIENT")
public class Client implements java.io.Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID_Client", unique = true, length = 10, nullable = false)
    private int idClient;

    @Column(name = "LASTNAME", length = 50, nullable = false)
    private String lastname;

    @Column(name = "FIRSTNAME", length = 50, nullable = false)
    private String firstname;

    @Column(name = "ADDRESS", length = 150, nullable = false)
    private String address;

    @Column(name = "PHONE", length = 10, nullable = false)
    private String phone;

    @Column(name = "EMAIL", length = 150, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "COURSE_SESSION_ID", referencedColumnName = "ID_SESSION", nullable = false)
    private CourseSession courseSession;

    public CourseSession getCourseSession() {
        return courseSession;
    }

    public void setCourseSession(CourseSession courseSession) {
        this.courseSession = courseSession;
    }

    public Client() {
    }

    public Client(String lastname, String firstname, String address, String phone, String email) {

        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
        this.email = email;

    }

    public Client(String lastname, String firstname, String address, String phone, String email, CourseSession courseSession) {
        //this.idClient = idClient;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.courseSession = courseSession;
    }

    public int getIdClient() {
        return this.idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
