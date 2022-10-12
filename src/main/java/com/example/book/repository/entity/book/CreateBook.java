package com.example.book.repository.entity.book;

import com.example.book.repository.entity.book.Book;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public class CreateBook {
    private String name;
    private double price;
    private String summary;
    private String pictureUrl;
    private double rating;
    private MultipartFile pictureFile;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishingDate;
    private List<Long> authorId;
    public CreateBook(){}

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

    public List<Long> getAuthorId() {
        return authorId;
    }

    public void setAuthorId(List<Long> authorId) {
        this.authorId = authorId;
    }

    public MultipartFile getPictureFile() {
        return pictureFile;
    }

    public void setPictureFile(MultipartFile pictureFile) {
        this.pictureFile = pictureFile;
    }
}
