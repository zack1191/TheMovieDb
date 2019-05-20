package com.hha.heinhtetaung.themoviedb.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.themoviedb.R;
import com.hha.heinhtetaung.themoviedb.contorller.MovieDelegate;
import com.hha.heinhtetaung.themoviedb.contorller.UpComingDelegate;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDBVo;
import com.hha.heinhtetaung.themoviedb.viewholders.UpComingMovieViewHolder;

public class UpComingMovieAdapter extends BaseRecyclerAdapter<UpComingMovieViewHolder, MovieDBVo> {
    private UpComingDelegate mMovieDelegate;

    public UpComingMovieAdapter(Context context, UpComingDelegate upComingDelegate) {
        super(context);
        this.mMovieDelegate = upComingDelegate;
    }

    @NonNull
    @Override
    public UpComingMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_upcoming, parent, false);
        return new UpComingMovieViewHolder(view, mMovieDelegate);
    }
}
