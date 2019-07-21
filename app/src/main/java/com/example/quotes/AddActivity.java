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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        mAuthor= (EditText) findViewById(R.id.author);
        mAddQuoteButton = (Button) findViewById(R.id.addQuoteButton);
        mAddQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String author = mAuthor.getText().toString();
                Intent addQuoteIntent = new Intent(AddActivity.this, ReadActivity.class);
                addQuoteIntent.putExtra("author", author);
                startActivity(addQuoteIntent);
            }
        });





    }
}
