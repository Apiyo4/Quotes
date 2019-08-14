package com.example.quotes;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quotes.models.Quote;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReadDetailFragment extends Fragment  {
    @BindView(R.id.authorTextView) TextView mAuthor;
    @BindView(R.id.quoteTextView) TextView mQuoteTextView;
    @BindView(R.id.idTextView) TextView mId;
    @BindView(R.id.saveQuoteButton) TextView mSaveQuoteButton;
    private Quote mQuote;
    public ReadDetailFragment() {
        // Required empty public constructor
    }

    public static ReadDetailFragment newInstance(Quote quote){
        ReadDetailFragment readDetailFragment = new ReadDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("quote", Parcels.wrap(quote));
        readDetailFragment.setArguments(args);
        return readDetailFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mQuote = Parcels.unwrap(getArguments().getParcelable("quote"));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_read_detail, container, false);
        ButterKnife.bind(this, view);
        mAuthor.setText(mQuote.getAuthor());
        mQuoteTextView.setText(mQuote.getQuote());
        mId.setText(Integer.toString(mQuote.getId()));
        return view;
    }

}
