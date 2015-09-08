package com.example.bestiize.volley_webservice.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.bestiize.volley_webservice.manager.BookManager;
import com.example.bestiize.volley_webservice.R;
import com.example.bestiize.volley_webservice.models.Book;
import com.example.bestiize.volley_webservice.service.HttpRequest;

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

        listView = (ListView) findViewById(R.id.list_item);
        bookAdapter = new BookAdapter(getApplicationContext());
        listView.setAdapter(bookAdapter);
        progressBar = (ProgressBar) findViewById(R.id.progressbar1);
        progressBar.setVisibility(View.INVISIBLE);
        //HttpRequest httpRequest = new HttpRequest(bookList);


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

}
