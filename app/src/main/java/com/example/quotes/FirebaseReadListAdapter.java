package com.example.quotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.quotes.models.Quote;
import com.example.quotes.util.ItemTouchHelperAdapter;
import com.example.quotes.util.OnStartDragListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;

public class FirebaseReadListAdapter extends FirebaseRecyclerAdapter<Quote, FirebaseReadViewHolder> implements ItemTouchHelperAdapter {
    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;

    public FirebaseReadListAdapter(FirebaseRecyclerOptions<Quote> options,
                                   DatabaseReference ref,
                                   OnStartDragListener onStartDragListener,
                                   Context context){
        super(options);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull FirebaseReadViewHolder firebaseReadViewHolder, int position, @NonNull Quote quote) {
        firebaseReadViewHolder.bindQuote(quote);
    }
    @NonNull
    @Override
    public FirebaseReadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.read_list_item_drag, parent, false);
        return new FirebaseReadViewHolder(view);
    }
    @Override
    public boolean onItemMove(int fromPosition, int toPosition){
        return false;
    }

    @Override
    public void onItemDismiss(int position){

    }
}