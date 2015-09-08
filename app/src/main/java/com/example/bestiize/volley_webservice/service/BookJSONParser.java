package com.example.bestiize.volley_webservice.service;

import android.util.Log;

import com.example.bestiize.volley_webservice.models.Book;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bestiize on 9/7/2015.
 */
public class BookJSONParser {
    private List<Book> bookList;
    public BookJSONParser(List<Book> bookList){
        this.bookList=bookList;

    }
    public List<Book> parseFeed(String content){


        JSONArray jsonArray = null;

        try {

            jsonArray = new JSONArray(content);

            for(int i=0;i<jsonArray.length();i++){

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Book book =new Book();
                book.setId(jsonObject.getString("id"));
                book.setTitle(jsonObject.getString("title"));
                book.setAuthor(jsonObject.getString("author"));
                book.setPublisher(jsonObject.getString("publisher"));
                book.setPrice(Double.parseDouble(jsonObject.getString("price")));
                book.setRating(Double.parseDouble(jsonObject.getString("rating")));

                bookList.add(book);



            }
            return bookList;
        } catch (JSONException e) {

            e.printStackTrace();
            return null;
        }


    }
}
