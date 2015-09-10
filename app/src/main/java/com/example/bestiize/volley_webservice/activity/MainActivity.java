package com.example.bestiize.volley_webservice.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.bestiize.volley_webservice.BookApplication;
import com.example.bestiize.volley_webservice.manager.BookManager;
import com.example.bestiize.volley_webservice.R;
import com.example.bestiize.volley_webservice.models.Book;
import com.example.bestiize.volley_webservice.service.BookJSONParser;
import com.example.bestiize.volley_webservice.service.HttpRequest;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ProgressBar progressBar;
    private List<Book> bookList;
    private BookAdapter bookAdapter;
    private BookManager bookManager;
    private static final String image_url = "https://dl.dropboxusercontent.com/u/186325148/ands/img/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.list_item);
        bookAdapter = new BookAdapter(getApplicationContext());
        listView.setAdapter(bookAdapter);
        progressBar = (ProgressBar) findViewById(R.id.progressbar1);
        progressBar.setVisibility(View.INVISIBLE);
        //HttpRequest httpRequest = new HttpRequest(bookList);
       // requestJSON();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {

               // testJsonArray();

            return true;
        }

        return super.onOptionsItemSelected(item);
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
