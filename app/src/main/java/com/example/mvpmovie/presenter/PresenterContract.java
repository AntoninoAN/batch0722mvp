package com.example.mvpmovie.presenter;

import com.example.mvpmovie.model.MoviePojo;
import com.example.mvpmovie.view.ViewContract;

import java.util.ArrayList;

public interface PresenterContract {
    void onBindView(ViewContract view);
    void unBindView();
    void initRetrofit();
    void onMovieDataSuccess(ArrayList<MoviePojo> item);
    void onMovieDataFailure(String errorMessage);
}
