package com.example.book.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    private String author;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishingDate;

    private int price;
    @Nullable
    private String pictureUrl;
    @Nullable
    private String summary;
    @Nullable
    private int rating;
    public Book() {}

    public Book(String name, String author, LocalDate publishingDate, int price, String pictureUrl, String summary, int rating) {
        this.name = name;
        this.author = author;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
