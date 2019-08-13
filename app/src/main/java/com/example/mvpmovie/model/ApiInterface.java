package com.example.mvpmovie.model;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    //https://api.androidhive.info/json/movies.json
    @GET("movies.json")
    Call<ArrayList<MoviePojo>> getMovies();
}
