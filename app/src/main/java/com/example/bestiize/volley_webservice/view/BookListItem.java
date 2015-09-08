package com.example.bestiize.volley_webservice.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bestiize.volley_webservice.R;
import com.example.bestiize.volley_webservice.models.Book;

/**
 * Created by Bestiize on 9/8/2015.
 */
public class BookListItem  extends RelativeLayout{
    private  TextView textView1,textView2;
    private ImageView imageView;
    public BookListItem(Context context) {
        super(context);
        initView();
    }
    public void initView(){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.book_list_item,this);
        textView1 = (TextView) view.findViewById(R.id.textView1);
        textView2 = (TextView) view.findViewById(R.id.textView2);
        imageView = (ImageView) view.findViewById(R.id.imageView1);


    }
    public void fill(Book book){
        textView1.setText(book.getTitle());
        textView2.setText(book.getAuthor());
        imageView.setImageResource(R.mipmap.ic_launcher);

    }

}
