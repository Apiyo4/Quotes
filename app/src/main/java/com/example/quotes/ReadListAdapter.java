package com.example.quotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.quotes.models.Quote;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReadListAdapter extends RecyclerView.Adapter<ReadListAdapter.ReadViewHolder> {
    private ArrayList<Quote> mQuotes = new ArrayList<Quote>();
    private Context mContext;
    public ReadListAdapter(Context context, ArrayList<Quote> quotes){
        mContext = context;
        mQuotes = quotes;
    }
    @Override
    public ReadListAdapter.ReadViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(mContext).inflate(R.layout.read_list_item, parent, false);
        ReadViewHolder viewHolder = new ReadViewHolder(view);
        return viewHolder;
    }
    @Override
        public void onBindViewHolder(ReadListAdapter.ReadViewHolder holder, int position){
        holder.bindRead(mQuotes.get(position));
    }
    @Override
        public int getItemCount(){
        return mQuotes.size();
    }

    public class ReadViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.authorTextView) TextView mAuthorTextView;
        @BindView(R.id.quoteTextView) TextView mQuoteTextView;
        @BindView(R.id.idTextView) TextView mIdTextView;
        private Context mContext;

        public ReadViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindRead(Quote quote){
            mAuthorTextView.setText(quote.getAuthor());
            mQuoteTextView.setText(quote.getQuote());
            mIdTextView.setText(quote.getId().toString());
        }
    }

}
