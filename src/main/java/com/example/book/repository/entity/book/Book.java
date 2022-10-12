package com.example.book.repository.entity.book;
import com.example.book.repository.entity.author.Author;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String name;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Author> authorList;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishingDate;
    @Nullable
    private double price;
    @Nullable
    private String pictureUrl;
    @Nullable
    private String summary;
    @Nullable
    private double rating;

    public Book() {}

    public Book(String name, LocalDate publishingDate, int price, String pictureUrl, String summary, double rating) {
        this.name = name;
        this.publishingDate = publishingDate;
        this.price = price;
        this.pictureUrl = pictureUrl;
        this.summary = summary;
        this.rating = rating;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getPictureUrl() {
        return pictureUrl;
    }
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Author> getAuthor() {
        return authorList;
    }
    public void setAuthor(List<Author> author) {
        this.authorList = author;
    }
    public LocalDate getPublishingDate() {
        return publishingDate;
    }
    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }
    @Nullable
    public String getSummary() {
        return summary;
    }
    public void setSummary(@Nullable String summary) {
        this.summary = summary;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }

    public void addAuthor(Author author){
        this.authorList.add(author);
        author.getHisBooks().add(this);
    }
}
