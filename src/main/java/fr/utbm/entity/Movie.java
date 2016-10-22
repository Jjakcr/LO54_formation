package fr.utbm.entity;

/**
 * Movie generated by hbm2java
 */
public class Movie implements java.io.Serializable {

    private int id;
    private String title;
    private int copies;
    private String movieType;
    private Integer mainActorId;

    public Movie() {
    }

    public Movie(int id, String title, int copies, String movieType) {
        this.id = id;
        this.title = title;
        this.copies = copies;
        this.movieType = movieType;

        getTitle();
    }

    public Movie(int id, String title, int copies, String movieType, Integer mainActorId) {
        this.id = id;
        this.title = title;
        this.copies = copies;
        this.movieType = movieType;
        this.mainActorId = mainActorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public Integer getMainActorId() {
        return mainActorId;
    }

    public void setMainActorId(Integer mainActorId) {
        this.mainActorId = mainActorId;
    }

}
