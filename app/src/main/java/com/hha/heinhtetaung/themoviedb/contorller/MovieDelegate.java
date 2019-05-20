package com.hha.heinhtetaung.themoviedb.contorller;

import com.hha.heinhtetaung.themoviedb.data.VO.MovieDBVo;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieVo;

public interface MovieDelegate {
    void onTapMovieItems(MovieDBVo tapMovie);
}
