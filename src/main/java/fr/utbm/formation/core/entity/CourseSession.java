package fr.utbm.formation.core.entity;
// Generated 26 nov. 2016 11:34:32 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.*;

/**
 * CourseSession
 */
@Entity
@Table(name = "COURSE_SESSION")
public class CourseSession implements java.io.Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID_SESSION", unique = true, length = 10, nullable = false)
    private int idSession;

    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE", length = 10, nullable = false)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE", length = 10, nullable = false)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "COURSE_CODE", referencedColumnName = "CODE", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "ID", nullable = false)
    private Location location;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public CourseSession() {
    }

    public CourseSession(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public CourseSession(Date startDate, Date endDate, Course course, Location location) {

        this.startDate = startDate;
        this.endDate = endDate;
        this.course = course;
        this.location = location;
    }

    public int getIdSession() {
        return this.idSession;
    }

    public void setIdSession(int idSession) {
        this.idSession = idSession;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
