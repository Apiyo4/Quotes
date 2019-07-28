package com.example.quotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import java.util.*;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReadActivity extends AppCompatActivity {

    @BindView(R.id.listView) ListView mListView;

    private ArrayList<String> authors = new ArrayList<String>();
    private ArrayList<String> quotes = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        ButterKnife.bind(this);
        authors.add("Robert Sewell");
        authors.add("Gavin Russell Baker");
        quotes.add("If Java had true garbage collection, most programs would delete themselves upon execution.");
        quotes.add( "C++ : Where friends have access to your private members.");

        Intent addQuoteIntent = getIntent();
        String author = addQuoteIntent.getStringExtra("author");
        authors.add(author);
        String quote = addQuoteIntent.getStringExtra("quote");
        quotes.add(quote);

        QuotesArrayAdapter quotesArrayAdapter = new QuotesArrayAdapter(this, android.R.layout.simple_list_item_1, authors, quotes);
        mListView.setAdapter(quotesArrayAdapter);

    }
}
