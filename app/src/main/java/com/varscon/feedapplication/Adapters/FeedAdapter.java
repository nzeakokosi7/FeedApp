package com.varscon.feedapplication.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
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

        public void setCard(Card current) {
            if(current.getCard_type().equals("text")) {
                mFeedTitle.setText(current.getCard().getValue());
                mFeedTitle.setTextSize(current.getCard().getAttributes().getFont().getSize());
                mFeedTitle.setTextColor(Color.parseColor(current.getCard().getAttributes().getTextColor()));


            } else if(current.getCard_type().equals("title_description")) {
                mFeedTitle.setText(current.getCard().getTitle().getValue());
                mFeedTitle.setTextSize(current.getCard().getTitle().getAttributes().getFont().getSize());
                mFeedTitle.setTextColor(Color.parseColor(current.getCard().getTitle().getAttributes().getTextColor()));

                mFeedDesc.setText(current.getCard().getDescription().getValue());
                mFeedDesc.setTextSize(current.getCard().getDescription().getAttributes().getFont().getSize());
                mFeedDesc.setTextColor(Color.parseColor(current.getCard().getDescription().getAttributes().getTextColor()));

            } else {

                mFeedTitle.setText(current.getCard().getTitle().getValue());
                mFeedTitle.setTextSize(current.getCard().getTitle().getAttributes().getFont().getSize());
                mFeedTitle.setTextColor(Color.parseColor(current.getCard().getTitle().getAttributes().getTextColor()));

                mFeedDesc.setText(current.getCard().getDescription().getValue());
                mFeedDesc.setTextSize(current.getCard().getDescription().getAttributes().getFont().getSize());
                mFeedDesc.setTextColor(Color.parseColor(current.getCard().getDescription().getAttributes().getTextColor()));

                mFeedImage.setMinimumHeight(current.getCard().getImage().getSize().getHeight());
                mFeedImage.setMinimumWidth(current.getCard().getImage().getSize().getWidth());
                setImage(current.getCard().getImage().getUrl());
            }



        }

        private void setImage(String displayUrl) {
            Log.d(TAG, "setImage: "+ displayUrl);
            Glide.with(mContext)
                    .load(displayUrl)
                    .thumbnail(0.1f)
                    .apply(new RequestOptions())

                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                            mProgressLoader.setVisibility(View.GONE);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                            mProgressLoader.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .into(mFeedImage);
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
        viewHolder.setCard(current);

    }

    @Override
    public int getItemCount() {
        if (mCards != null)
            return mCards.size();
        else return 0;
    }

}

