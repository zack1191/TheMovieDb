package com.hha.heinhtetaung.themoviedb.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hha.heinhtetaung.themoviedb.R;
import com.hha.heinhtetaung.themoviedb.contorller.MovieDelegate;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDBVo;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieVo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PopularViewHolder extends BaseViewHolder<MovieDBVo> {

    @BindView(R.id.iv_background)
    ImageView ivBackground;

    @BindView(R.id.tv_name)
    TextView tvMovieName;

    private MovieDelegate mMovieDelegate;
    private MovieVo mMovie;
    private MovieDBVo mMovieDb;


    public PopularViewHolder(View itemView, MovieDelegate movieDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mMovieDelegate = movieDelegate;

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        mMovieDelegate.onTapMovieItems(mMovieDb);
    }

    @Override
    public void setData(MovieDBVo data) {
        mMovieDb = data;
        tvMovieName.setText(data.getTitle());
        if (data.getPoster_path() != null) {
            ivBackground.setVisibility(View.VISIBLE);
            Glide.with(ivBackground.getContext())
                    .load("http://image.tmdb.org/t/p/original" + data.getPoster_path())
                    .into(ivBackground);
        } else {
            ivBackground.setVisibility(View.GONE);
        }

    }
}
