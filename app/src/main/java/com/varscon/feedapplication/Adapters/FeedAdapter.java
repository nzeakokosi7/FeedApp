package com.varscon.feedapplication.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elyeproj.loaderviewlibrary.LoaderImageView;
import com.elyeproj.loaderviewlibrary.LoaderTextView;
import com.varscon.feedapplication.Models.Card;
import com.varscon.feedapplication.R;

import java.util.ArrayList;
import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewModel> {
    public static final String TAG = FeedAdapter.class.getSimpleName();

    class FeedViewModel extends RecyclerView.ViewHolder {

        View mView;
        private LoaderTextView mFeedTitle, mFeedDesc;
        private LoaderImageView mFeedImage;

        public FeedViewModel(@NonNull View itemView) {
            super(itemView);

            mView = itemView;
            mFeedTitle = mView.findViewById(R.id.feed_title);
            mFeedDesc = mView.findViewById(R.id.feed_desc);
            mFeedImage = mView.findViewById(R.id.display_image);

        }

    }

    private final LayoutInflater mInflater;
    private List<Card> mCards; // Cached copy of polls
    private Context mContext;

    public FeedAdapter(Context context) {
        mCards = new ArrayList<>();
        mInflater = LayoutInflater.from(context);
        this.mContext = context;

    }

    public void setFeeds(List<Card> cards) {
        this.mCards.clear();
        this.mCards.addAll(cards);

        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public FeedViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.feed_item_view, parent, false);

        return new FeedViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewModel viewHolder, int position) {
        Log.d("View", "onBindViewHolder: " + position);
        final Card current = this.mCards.get(position);

    }

    @Override
    public int getItemCount() {
        if (mCards != null)
            return mCards.size();
        else return 0;
    }

}

