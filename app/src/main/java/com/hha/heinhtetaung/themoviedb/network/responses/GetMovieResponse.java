package com.hha.heinhtetaung.themoviedb.network.responses;

import com.google.gson.annotations.SerializedName;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieVo;

import java.util.List;

public class GetMovieResponse {

    //    code": 200,
//            "message": "success",
//            "apiVersion": "v1",
//            "page": "1",
//            "popular-movies": [
//    {
    private int code;
    private String message;
    private String apiVersion;
    private String page;

    @SerializedName("popular-movies")
    private List<MovieVo> movie;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<MovieVo> getMovie() {
        return movie;
    }

    public void setMovie(List<MovieVo> movie) {
        this.movie = movie;
    }
}
