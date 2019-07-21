package com.example.quotes;

import android.content.Context;
import android.widget.ArrayAdapter;

public class QuotesArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mAuthors;
    private String[] mQuotes;


    public QuotesArrayAdapter(Context mContext, int resource, String[] mAuthors, String[] mQuotes){
        super(mContext, resource);
        this.mContext = mContext;
        this.mAuthors = mAuthors;
        this.mQuotes = mQuotes;
    }
    @Override
        public Object getItem(int position){
        String author = mAuthors[position];
        String quote = mQuotes[position];
            return String.format( "%S wrote \n %S", author, quote);
    }
    @Override
    public int getCount(){
        return mAuthors.length;
    }
}
