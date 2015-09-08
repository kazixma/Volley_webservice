package com.example.bestiize.volley_webservice.models;

/**
 * Created by Bestiize on 9/7/2015.
 */
public class Book {
    private String id;
    private String title;
    private String author;
    private String publisher;
    private double price;
    private double rating;

    public Book(String id, String title, String author, String publisher, double price, double rating) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.rating = rating;
    }
    public Book(){


    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    public String toString(){

        return this.getTitle()+"\n"+this.getAuthor();
    }
}
