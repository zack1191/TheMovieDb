package com.hha.heinhtetaung.themoviedb.events;

import com.hha.heinhtetaung.themoviedb.data.VO.MovieDBVo;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieVo;

import java.util.List;

public class LoadMovieDbEvent {
    private List<MovieDBVo> movieDBVos;

    public LoadMovieDbEvent(List<MovieDBVo> movieDBVos) {
        this.movieDBVos = movieDBVos;
    }

    public List<MovieDBVo> getMovieDbList() {
        return movieDBVos;
    }
}
