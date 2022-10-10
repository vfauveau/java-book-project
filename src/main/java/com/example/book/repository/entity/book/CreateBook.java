package com.example.book.repository.entity.book;

import com.example.book.repository.entity.book.Book;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CreateBook {
    private String name;
    private double price;
    private String summary;
    private String pictureUrl;
    private double rating;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishingDate;

    public CreateBook(){}

    public Book toBook() {
        Book b = new Book();
        b.setName(this.name);
        b.setPrice(this.price);
        b.setRating(this.rating);
        b.setPictureUrl(this.pictureUrl);
        b.setPublishingDate(this.publishingDate);
        return b;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
