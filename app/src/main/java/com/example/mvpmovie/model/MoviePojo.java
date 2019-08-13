package com.example.mvpmovie.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviePojo implements Parcelable {

    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("rating")
    @Expose
    public double rating;
    @SerializedName("releaseYear")
    @Expose
    public int releaseYear;
    @SerializedName("genre")
    @Expose
    public List<String> genre = null;

    public MoviePojo(){}

    protected MoviePojo(Parcel in) {
        title = in.readString();
        image = in.readString();
        rating = in.readDouble();
        releaseYear = in.readInt();
        genre = in.createStringArrayList();
    }

    public static final Creator<MoviePojo> CREATOR = new Creator<MoviePojo>() {
        @Override
        public MoviePojo createFromParcel(Parcel in) {
            return new MoviePojo(in);
        }

        @Override
        public MoviePojo[] newArray(int size) {
            return new MoviePojo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(image);
        parcel.writeDouble(rating);
        parcel.writeInt(releaseYear);
        parcel.writeStringList(genre);
    }
}
