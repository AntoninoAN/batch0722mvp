package com.example.mvpmovie.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvpmovie.R;
import com.example.mvpmovie.model.MoviePojo;
import com.example.mvpmovie.presenter.Presenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements ViewContract, ItemClickEvent {

    RecyclerView recyclerView;
    CustomAdapter adapter;
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        onBindPresenter();
        initNetworkCall();
    }

    @Override
    public void onBindPresenter() {
        presenter = new Presenter();
        presenter.onBindView(this);
    }

    @Override
    public void initUI() {
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new CustomAdapter();
        adapter.setListener(this);
        recyclerView.setLayoutManager(
                new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initNetworkCall() {
        presenter.initRetrofit();
    }

    @Override
    public void getMovieData(ArrayList<MoviePojo> dataSet) {
        adapter.setDataSet(dataSet);
    }

    @Override
    public void getFailureMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClicked(MoviePojo item) {
        FragmentManager manager = getSupportFragmentManager();
        MovieDetailFragment fragment = MovieDetailFragment.newInstance(item);
        manager.beginTransaction()
                .add(R.id.container, fragment)
                .commit();
        fragment.populateData();
    }
}
