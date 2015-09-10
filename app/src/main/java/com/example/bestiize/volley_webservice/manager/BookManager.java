package com.example.bestiize.volley_webservice.manager;

import android.util.Log;

import com.example.bestiize.volley_webservice.models.Book;
import com.example.bestiize.volley_webservice.service.HttpRequest;

import java.util.List;

/**
 * Created by Bestiize on 9/8/2015.
 */
public class BookManager {
    private List<Book> bookList;
    public BookManager(List<Book> bookList) {
        this.bookList=bookList;
        parseToJSON();



    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setStarList(List<Book> bookList) {
        this.bookList = bookList;
    }
    public void parseToJSON(){
        HttpRequest httpRequest =new HttpRequest(bookList);


    }
}
