package com.example.quotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReadActivity extends AppCompatActivity {
    private TextView mNewAuthor;
    private TextView mNewQuote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        mNewAuthor = (TextView) findViewById(R.id.newAuthor);
        mNewQuote= (TextView) findViewById(R.id.newQuote);
        Intent addQuoteIntent = getIntent();
        String author = addQuoteIntent.getStringExtra("author");
        String quote = addQuoteIntent.getStringExtra("quote");
        mNewAuthor.setText(author);
        mNewQuote.setText(quote);
    }
}
