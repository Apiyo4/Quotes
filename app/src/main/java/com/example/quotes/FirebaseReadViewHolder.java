package com.example.quotes;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;



import androidx.recyclerview.widget.RecyclerView;

import com.example.quotes.models.Quote;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseReadViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View mView;
    Context mContext;

    public FirebaseReadViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindQuote(Quote quote) {

        TextView mAuthor= (TextView) mView.findViewById(R.id.authorTextView);
        TextView mQuoteTextView= (TextView) mView.findViewById(R.id.quoteTextView);
//        TextView mId= (TextView) mView.findViewById(R.id.idTextView);


        mAuthor.setText(quote.getAuthor());
        mQuoteTextView.setText(quote.getQuote());

    }

    @Override
    public void onClick(View view) {
        final ArrayList<Quote> quotes = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_QUOTES);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    quotes.add(snapshot.getValue(Quote.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, ReadDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("quotes", Parcels.wrap(quotes));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}