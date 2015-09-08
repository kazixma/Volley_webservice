package com.example.bestiize.volley_webservice.service;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.bestiize.volley_webservice.BookApplication;
import com.example.bestiize.volley_webservice.models.Book;

import org.json.JSONArray;

import java.util.List;

/**
 * Created by Bestiize on 9/8/2015.
 */
public class HttpRequest {
    private List<Book> bookList;
    public HttpRequest(List<Book> bookList){
        this.bookList=bookList;
        requestJSON();
    }
    public void requestJSON(){
            Log.d("TAG", "HELLO1");
            String tag_json_array = "json_array_req";
            String url = "https://dl.dropboxusercontent.com/u/186325148/ands/services/books.json";
            JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, url,
                    new Response.Listener<JSONArray>() {
                        @TargetApi(Build.VERSION_CODES.KITKAT)
                        @Override

                        public void onResponse(JSONArray response) {
                            BookJSONParser bookJSONParser = new BookJSONParser(bookList);
                            Log.d("TAG", response.toString());
                            Log.d("TAG","HELLO");
                            bookList = bookJSONParser.parseFeed(response.toString());


                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d("TAG", "Error: " + error.getMessage());


                }
            });



            BookApplication.getInstance().addToRequestQueue(req,tag_json_array);

            //return bookList;


    }
}
