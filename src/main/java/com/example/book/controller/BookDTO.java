package com.example.book.controller;

import com.example.book.repository.entity.author.Author;
import com.example.book.repository.entity.book.Book;

import java.time.LocalDate;
import java.util.List;

public class BookDTO {

    public BookDTO() {
    }

    public static BookDTO from(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setName(book.getName());
        dto.setPrice(book.getPrice());
        dto.setRating(book.getRating());
        dto.setSummary(book.getSummary());
        dto.setPublishingDate(book.getPublishingDate());
        dto.setPictureUrl(book.getPictureUrl());

        return dto;
    }

    private long id;

    private String name;

    private List<Author> authorList;

    private LocalDate publishingDate;

    private double price;

    private String pictureUrl;

    private String summary;

    private double rating;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


}
