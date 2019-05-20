package com.hha.heinhtetaung.themoviedb.network;

import com.hha.heinhtetaung.themoviedb.network.responses.GetMovieDBResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {
//    @FormUrlEncoded
//    @POST("getPopularMovies.php")
//    Call<GetMovieResponse> getMovies(@Field("page") int page,
//                                     @Field("access_token") String accessToken);

    @GET("/3/movie/{category}")
    Call<GetMovieDBResponse> getMoviesdb(
            @Path("category") String category,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );


}
