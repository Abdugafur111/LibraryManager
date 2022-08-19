package ru.alishev.springcourse.Project2Boot.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Neil Alishev
 */
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2, max = 100, message = "Title should be from 2 characters to 100 characters")
    @Column(name = "title")
    private String title;

    @NotEmpty(message = "Author should not be empty")
    @Size(min = 2, max = 100, message = "Author should be from 2 characters to 100 characters")
    @Column(name = "author")
    private String author;

    @Min(value = 1500, message = "Year should be more than 1500")
    @Column(name = "year")
    private int year;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    @Column(name = "taken_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date takenAt;

    @Column(name="ISBN")
    private Integer ISBN;







    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }



    @Transient
    private boolean expired; // Hibernate не будет замечать этого поля, что нам и нужно. По-умолчанию false.
    @Transient
    @Column(name = "isAvailable")
    private boolean isAvailable;


    public boolean isAvailable() {
        return owner != null;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
@Column(name="location")
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Book() {

    }

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Date getTakenAt() {
        return takenAt;
    }

    public void setTakenAt(Date takenAt) {
        this.takenAt = takenAt;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
