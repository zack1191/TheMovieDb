package com.hha.heinhtetaung.themoviedb.data.Model;

import android.util.Log;

import com.hha.heinhtetaung.themoviedb.data.VO.MovieDBVo;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieVo;
import com.hha.heinhtetaung.themoviedb.events.LoadMovieDbEvent;
import com.hha.heinhtetaung.themoviedb.events.LoadMovieEvent;
import com.hha.heinhtetaung.themoviedb.events.LoadUpcomingEvent;
import com.hha.heinhtetaung.themoviedb.network.MovieDataAgent;
import com.hha.heinhtetaung.themoviedb.network.RetrofitDataAgent;
import com.hha.heinhtetaung.themoviedb.network.UpcomingDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

public class MovieModel {
    private static MovieModel sObjInstance;
    private MovieDataAgent mMovieDataAgent;
    private UpcomingDataAgent mUpcomingDataAgent;

    private Map<String, MovieVo> mMovie;
    private Map<String, MovieDBVo> movieDB;

    public MovieModel() {
        mMovie = new HashMap<>();
        movieDB = new HashMap<>();
        mMovieDataAgent = RetrofitDataAgent.getsObjInstance();
        mUpcomingDataAgent = RetrofitDataAgent.getsObjInstance();
        EventBus.getDefault().register(this);
    }

    public static MovieModel getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new MovieModel();
        }
        return sObjInstance;
    }

    public void loadMovie() {
        mMovieDataAgent.loadMovie();
    }

    public void loadUpcoming() {
        mUpcomingDataAgent.loadUpcoming();
    }


    public MovieDBVo getMovieDbById(String movieDbId) {
        return movieDB.get(movieDbId);
    }


//    @Subscribe(threadMode = ThreadMode.BACKGROUND)
//    public void onMoveLoaded(LoadMovieEvent event) {
//        Log.d("a", "onNewsLoaded : " + event.getMovieList().size());
//        for (MovieVo movie : event.getMovieList()) {
//
//            mMovie.put(movie.getId(), movie);
//        }
//    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onMovieDbLoaded(LoadMovieDbEvent event) {
        Log.d("a", "onMovieLoaded : " + event.getMovieDbList().size());
        for (MovieDBVo movieDBVo : event.getMovieDbList()) {
            movieDB.put(movieDBVo.getId(), movieDBVo);
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onUpcomingLoaded(LoadUpcomingEvent event) {
        Log.d("a", "onUpcomeLoaded : " + event.getMovieDbList().size());
        for (MovieDBVo movieDBVo : event.getMovieDbList()) {
            movieDB.put(movieDBVo.getId(), movieDBVo);
        }
    }
}
