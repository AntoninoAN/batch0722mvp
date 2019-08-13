package com.example.mvpmovie.presenter;

import com.example.mvpmovie.model.ApiInterface;
import com.example.mvpmovie.model.MoviePojo;
import com.example.mvpmovie.view.ViewContract;
import com.google.gson.Gson;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Presenter implements PresenterContract {

    private ViewContract view;

    @Override
    public void onBindView(ViewContract view) {
        this.view = view;
    }

    @Override
    public void unBindView() {
        view = null;
    }

    @Override
    public void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.androidhive.info/json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(ApiInterface.class)
                .getMovies()
                .enqueue(new Callback<ArrayList<MoviePojo>>() {
                    @Override
                    public void onResponse(Call<ArrayList<MoviePojo>> call,
                                           Response<ArrayList<MoviePojo>> response) {
                        if(response.isSuccessful())
                            onMovieDataSuccess(response.body());
                    }

                    @Override
                    public void onFailure(Call<ArrayList<MoviePojo>> call,
                                          Throwable t) {
                        onMovieDataFailure(t.getMessage());
                    }
                });
    }

    @Override
    public void onMovieDataSuccess(ArrayList<MoviePojo> item) {
        view.getMovieData(item);
    }

    @Override
    public void onMovieDataFailure(String errorMessage) {
        view.getFailureMessage(errorMessage);
    }
}
