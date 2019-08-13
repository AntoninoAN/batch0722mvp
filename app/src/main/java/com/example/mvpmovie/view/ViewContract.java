package com.example.mvpmovie.view;

import android.graphics.Movie;

import com.example.mvpmovie.model.MoviePojo;

import java.util.ArrayList;

public interface ViewContract {
    void onBindPresenter();
    void initUI();
    void initNetworkCall();
    void getMovieData(ArrayList<MoviePojo> dataSet);
    void getFailureMessage(String message);
}
