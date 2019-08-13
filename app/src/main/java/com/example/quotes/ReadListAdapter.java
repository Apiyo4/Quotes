package com.example.quotes;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.quotes.models.Quote;
import com.squareup.picasso.Picasso;

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
    public void onBindViewHolder(ReadListAdapter.ReadViewHolder holder, int position) {
        holder.bindRead(mQuotes.get(position));
    }

    @Override
        public int getItemCount(){
        return mQuotes.size();
    }

    public class ReadViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.authorTextView) TextView mAuthorTextView;
        @BindView(R.id.quoteTextView) TextView mQuoteTextView;
        @BindView(R.id.shareButton)  Button mShareButton;
        private Context mContext;
        Quote mQuote;

        public ReadViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            mShareButton.setOnClickListener(this);

//            ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
//                @Override
//                public void onItemClicked(RecyclerView recyclerView, int position, View v) {
//                    // do it
//                    Toast.makeText(itemView.getContext(), "hi", Toast.LENGTH_LONG).show();
//                }
//            });


        }


        //    public void bind(final ReadActivity item, final AdapterView.OnItemClickListener listener) {
//        name.setText(item.name);
//
//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onItemClick(View v) {
//                listener.onItemClick()
//            }
//        });
//    };
//        public void bindRead(Quote quote, AdapterView.OnItemClickListener listener){
//            mAuthorTextView.setText(quote.getAuthor());
//            mQuoteTextView.setText(quote.getQuote());
//            mIdTextView.setText(quote.getId().toString());
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(itemView.getContext(), "Hi", Toast.LENGTH_LONG).show();
//                }
//            });
//        }
        public void bindRead(Quote quote){
            mQuote = quote;
            mAuthorTextView.setText(quote.getAuthor());
            mQuoteTextView.setText(quote.getQuote());


        }

        @Override
        public void onClick(View view) {
            Toast.makeText(mContext, mQuote.getAuthor(), Toast.LENGTH_SHORT).show();
//            Intent sendIntent = new Intent(Intent.ACTION_SEND, Uri.parse(mQuote.getQuote()));
//             mContext.startActivity(sendIntent);

        }
    }



}
