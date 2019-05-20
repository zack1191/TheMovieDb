package com.hha.heinhtetaung.themoviedb.events;

import com.hha.heinhtetaung.themoviedb.data.VO.MovieDBVo;

import java.util.List;

public class LoadUpcomingEvent {
    private List<MovieDBVo> movieDBVos;

    public LoadUpcomingEvent(List<MovieDBVo> movieDBVos) {
        this.movieDBVos = movieDBVos;
    }

    public List<MovieDBVo> getMovieDbList() {
        return movieDBVos;
    }
}
