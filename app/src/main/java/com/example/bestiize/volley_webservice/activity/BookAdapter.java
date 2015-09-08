package com.example.bestiize.volley_webservice.activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.bestiize.volley_webservice.BookApplication;
import com.example.bestiize.volley_webservice.view.BookListItem;
import com.example.bestiize.volley_webservice.models.Book;

import java.util.List;

/**
 * Created by Bestiize on 9/8/2015.
 */
public class BookAdapter extends BaseAdapter {
    private Context context;
    private List<Book> bookList;
    private BookApplication bookApplication;

    public BookAdapter (Context context){
        this.bookApplication = (BookApplication)context;
        this.context=context;



    }
    @Override
    public int getCount() {
        return bookApplication.getBookManager().getBookList().size();
    }

    @Override
    public Object getItem(int position) {
        return bookApplication.getBookManager().getBookList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BookListItem book =createListItem(convertView);
        book.fill(bookApplication.getBookManager().getBookList().get(position));
        return book;
    }
    public BookListItem createListItem(View convertView){

        if(convertView == null || !(convertView instanceof BookListItem)){
            return new BookListItem(this.context);
        }

        return (BookListItem)convertView;

    }

}
