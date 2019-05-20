package com.hha.heinhtetaung.themoviedb.events;

import com.hha.heinhtetaung.themoviedb.data.VO.MovieDBVo;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieVo;

import java.util.List;

public class LoadMovieEvent {
    private List<MovieVo> movieVos;
    private List<MovieDBVo> movieDBVos;

    public LoadMovieEvent(List<MovieVo> movieVos) {
        this.movieVos = movieVos;
    }



    public List<MovieVo> getMovieList() {
        return movieVos;
    }
}
