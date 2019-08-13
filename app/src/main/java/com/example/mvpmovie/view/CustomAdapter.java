package com.example.mvpmovie.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpmovie.R;
import com.example.mvpmovie.model.MoviePojo;

import java.util.ArrayList;

public class CustomAdapter
        extends RecyclerView.Adapter<CustomViewHolder> {

    private ArrayList<MoviePojo> dataSet;
    private ItemClickEvent listener;

    public void setDataSet(ArrayList<MoviePojo> dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    public void setListener(ItemClickEvent listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.onBind(dataSet.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.size() : 0;
    }
}
