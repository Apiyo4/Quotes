package com.example.quotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @BindView(R.id.addButton) Button mAddButton;
    @BindView(R.id.readButton) Button mReadButton;
    @BindView(R.id.picButton) Button mPicButton;
    @BindView(R.id.authorEditText) EditText mAuthorEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(addIntent);
            }

        });


        mReadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String author = mAuthorEditText.getText().toString();
                if(!(author).equals("")) {
                    addToSharedPreferences(author);
                  }
                Intent addIntent = new Intent(MainActivity.this, ReadActivity.class);
                startActivity(addIntent);

            }
            private void addToSharedPreferences(String author) {
                mEditor.putString(Constants.PREFERENCES_AUTHOR_KEY, author).apply();


            }
        });

        mPicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(MainActivity.this, PicActivity.class);
                startActivity(addIntent);
            }
        });


    }
}
