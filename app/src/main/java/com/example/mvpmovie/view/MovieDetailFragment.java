package com.example.mvpmovie.view;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvpmovie.R;
import com.example.mvpmovie.model.MoviePojo;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MovieDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieDetailFragment extends Fragment {
    ImageView imagePoster;
    TextView tv_title, tv_rating, tv_release;

    public MovieDetailFragment() {
        // Required empty public constructor
    }

    public static MovieDetailFragment newInstance(MoviePojo item) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("Item", item);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        imagePoster = view.findViewById(R.id.iv_item_poster);
        tv_title = view.findViewById(R.id.tv_movie_title);
        tv_rating = view.findViewById(R.id.tv_movie_rating);
        tv_release = view.findViewById(R.id.tv_movie_release);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();

//        MoviePojo item = bundle.getParcelable("Item");
//        Picasso.get()
//                .load(item.image)
//                .into(imagePoster);
//        tv_title.setText(item.title);
//        tv_release.setText(item.releaseYear);
//        tv_rating.setText(Double.toString(item.rating));
    }

    public void populateData() {
        Bundle bundle = getArguments();

        MoviePojo item =
                bundle.getParcelable("Item");

        Picasso.get()
                .load(item.image)
                .into(imagePoster);
        tv_title.setText(item.title);
        tv_release.setText(item.releaseYear);
        tv_rating.setText(Double.toString(item.rating));
    }
}
