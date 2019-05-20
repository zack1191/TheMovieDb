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

import butterknife.BindView;
import butterknife.ButterKnife;

public class UpcomingActivity extends AppCompatActivity {
    @BindView(R.id.tv_Tile_upc)
    TextView tvTitle;

    @BindView(R.id.iv_manga_upc)
    ImageView ivBackground;

    @BindView(R.id.tvDesc_upc)
    TextView tvOverView;

    @BindView(R.id.tv_release_date_upc)
    TextView tvReleaseDate;

    private MovieDBVo mMovieDB;

    public static Intent newIntent(Context context, String movieId) {
        Intent intent = new Intent(context, UpcomingActivity.class);
        intent.putExtra("movieId", movieId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);
        ButterKnife.bind(this, this);

        String mMovieId = getIntent().getStringExtra("movieId");

        MovieModel.getsObjInstance().loadMovie();
        mMovieDB = MovieModel.getsObjInstance().getMovieDbById(mMovieId);

        displayMovieDetail(mMovieDB);
    }

    private void displayMovieDetail(MovieDBVo mMovieDB) {
        if (mMovieDB.getPoster_path() != null) {
            ivBackground.setVisibility(View.VISIBLE);
            Glide.with(ivBackground.getContext())
                    .load("http://image.tmdb.org/t/p/original" + mMovieDB.getPoster_path())
                    .into(ivBackground);
        } else {
            ivBackground.setVisibility(View.GONE);
        }
        tvReleaseDate.setText(mMovieDB.getRelease_date());
        tvOverView.setText(mMovieDB.getOverview());
        tvTitle.setText(mMovieDB.getTitle());
    }
}
