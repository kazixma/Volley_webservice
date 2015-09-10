package com.example.bestiize.volley_webservice;

import android.annotation.TargetApi;
import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.bestiize.volley_webservice.manager.BookManager;
import com.example.bestiize.volley_webservice.models.Book;
import com.example.bestiize.volley_webservice.service.BookJSONParser;
import com.example.bestiize.volley_webservice.service.HttpRequest;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bestiize on 9/8/2015.
 */
public class BookApplication  extends Application{
    public static final String TAG = BookApplication.class
            .getSimpleName();

    private RequestQueue mRequestQueue;

    private static BookApplication mInstance;
    private BookManager bookManager;
    private List<Book> bookList;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;

        bookList = new ArrayList<>();
        bookManager =new BookManager(bookList);

        //bookList.add(new Book("vvv","v","v","v",1.0,1.0));
        //bookList.add(new Book("vvv","v","v","v",1.0,1.0));
        //bookList.add(new Book("vvv","v","v","v",1.0,1.0));





    }

    public BookManager getBookManager() {
        return bookManager;
    }

    public void setBookManager(BookManager bookManager) {
        this.bookManager = bookManager;
    }
    public static synchronized BookApplication getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());

        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

}
