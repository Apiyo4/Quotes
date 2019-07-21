package com.example.quotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    private Button mAddQuoteButton;
    private EditText mAuthor;
    private EditText mQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        mAuthor= (EditText) findViewById(R.id.author);
        mQuote= (EditText) findViewById(R.id.quote);
        mAddQuoteButton = (Button) findViewById(R.id.addQuoteButton);
        mAddQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String author = mAuthor.getText().toString();
                String quote = mQuote.getText().toString();
                Intent addQuoteIntent = new Intent(AddActivity.this, ReadActivity.class);
                addQuoteIntent.putExtra("author", author);
                addQuoteIntent.putExtra("quote", quote);
                startActivity(addQuoteIntent);
            }
        });





    }
}
