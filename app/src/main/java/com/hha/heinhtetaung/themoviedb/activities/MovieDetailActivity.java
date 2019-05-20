package com.hha.heinhtetaung.themoviedb.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hha.heinhtetaung.themoviedb.R;
import com.hha.heinhtetaung.themoviedb.data.Model.MovieModel;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDBVo;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieVo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends AppCompatActivity {

    @BindView(R.id.iv_manga)
    ImageView ivBackground;

    @BindView(R.id.tvOverView)
    TextView tvOverView;

    @BindView(R.id.tv_release_date)
    TextView tvReleaseDate;

    @BindView(R.id.tv_Tile)
    TextView tvTitle;

    private String mMovieId;
    private MovieVo mMovieVo;
    private MovieDBVo mMovieDB;

    public static Intent newIntent(Context context, String movieId) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra("movieId", movieId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this, this);

        mMovieId = getIntent().getStringExtra("movieId");

        MovieModel.getsObjInstance().loadMovie();
        mMovieDB = MovieModel.getsObjInstance().getMovieDbById(mMovieId);

        displayMovieDetail(mMovieDB);

    }

    private void displayMovieDetail(MovieDBVo movieVo) {
        if (movieVo.getPoster_path() != null) {
            ivBackground.setVisibility(View.VISIBLE);
            Glide.with(ivBackground.getContext())
                    .load("http://image.tmdb.org/t/p/original" + movieVo.getPoster_path())
                    .into(ivBackground);
        } else {
            ivBackground.setVisibility(View.GONE);
        }
        tvReleaseDate.setText(movieVo.getRelease_date());
        tvOverView.setText(movieVo.getOverview());
        tvTitle.setText(movieVo.getTitle());
    }
}
