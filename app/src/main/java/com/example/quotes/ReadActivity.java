package com.example.quotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.quotes.models.Quote;

import java.io.IOException;
import java.util.*;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ReadActivity extends AppCompatActivity {

    public static final String TAG = ReadActivity.class.getSimpleName();


//     @BindView(R.id.listView) ListView mListView;
        @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
        private ReadListAdapter mAdapter;

//    private ArrayList<String> authors = new ArrayList<String>();
//    private ArrayList<String> quotes = new ArrayList<String>();
   public ArrayList<Quote> mQuotes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        ButterKnife.bind(this);

//        authors.add("Robert Sewell");
//        authors.add("Gavin Russell Baker");
//        quotes.add("If Java had true garbage collection, most programs would delete themselves upon execution.");
//        quotes.add( "C++ : Where friends have access to your private members.");

//        Intent addQuoteIntent = getIntent();
//        String author = addQuoteIntent.getStringExtra("author");
//        authors.add(author);
//        String quote = addQuoteIntent.getStringExtra("quote");
//        quotes.add(quote);

//        QuotesArrayAdapter quotesArrayAdapter = new QuotesArrayAdapter(this, android.R.layout.simple_list_item_1, authors, quotes);
//        mListView.setAdapter(quotesArrayAdapter);
        getQuotes("author");
    }

    private void getQuotes(String author) {
        final QuoteService quoteService = new QuoteService();
        quoteService.findQuotes(author, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            //           public void onResponse(Call call, Response response) throws IOException {
            public void onResponse(Call call, Response response) {
//                try {
//                    String jsonData = response.body().string();
//                    Log.v(TAG, jsonData);
//                }catch(IOException e){
//                    e.printStackTrace();
//                }
//                try{
//                    String jsonData = response.body().string();
//                    if(response.isSuccessful()){
//                        Log.v(TAG, jsonData);
//                        mQuotes = quoteService.processResults(response);
//                    }
//
//                } catch (IOException e){
//                    e.printStackTrace();
//                }


                mQuotes = quoteService.processResults(response);
                ReadActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new ReadListAdapter(ReadActivity.this, mQuotes);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ReadActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                        mRecyclerView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(ReadActivity.this,"Hi",Toast.LENGTH_LONG).show();
                            }
                        });
//                        String[] quoteQuotes = new String[mQuotes.size()];
//                        for(int i = 0; i< quoteQuotes.length; i++){
//                            quoteQuotes[i] = mQuotes.get(i).getQuote();
//                        }
//                        ArrayAdapter adapter = new ArrayAdapter(ReadActivity.this, android.R.layout.simple_list_item_1, quoteQuotes);
//                        mListView.setAdapter(adapter);
//                        for(Quote quote: mQuotes) {
//                            Log.d(TAG, "author:" + quote.getAuthor());
//                            Log.d(TAG, "id:" + quote.getId());
//                            Log.d(TAG, "quote:" + quote.getQuote());
//                            Log.d(TAG, "permalink:" + quote.getPermalink());
//                        }
                    }
                });
                    }

                });
            }
}