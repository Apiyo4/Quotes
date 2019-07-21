package com.example.quotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class ReadActivity extends AppCompatActivity {
    private ListView mListView;
    private TextView mNewAuthor;
    private TextView mNewQuote;
    private String[] authors = new String[]{ "Robert Sewell", "Gavin Russell Baker"};
    private String[] quotes = new String[]{ "If Java had true garbage collection, most programs would delete themselves upon execution.", "C++ : Where friends have access to your private members."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        mListView = (ListView) findViewById(R.id.listView);
        mNewAuthor = (TextView) findViewById(R.id.newAuthor);
        mNewQuote= (TextView) findViewById(R.id.newQuote);
        Intent addQuoteIntent = getIntent();
        String author = addQuoteIntent.getStringExtra("author");
        String quote = addQuoteIntent.getStringExtra("quote");
        mNewAuthor.setText(author);
        mNewQuote.setText(quote);

        QuotesArrayAdapter quotesArrayAdapter = new QuotesArrayAdapter(this, android.R.layout.simple_list_item_1, authors, quotes);
        mListView.setAdapter(quotesArrayAdapter);
    }
}
