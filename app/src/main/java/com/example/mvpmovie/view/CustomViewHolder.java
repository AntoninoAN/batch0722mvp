package com.example.mvpmovie.view;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpmovie.R;
import com.example.mvpmovie.model.MoviePojo;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;


public class CustomViewHolder
        extends RecyclerView.ViewHolder {
    ImageView imageView;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView =
                itemView.findViewById(R.id.iv_item_poster);
    }

    public void onBind(final MoviePojo item,
                       final ItemClickEvent listener){
        Picasso.get().load(item.image)
//                .transform(new CircleMoviePoster())
                .into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(item);
            }
        });
    }

    class CircleMoviePoster implements Transformation{

        @Override
        public Bitmap transform(Bitmap source) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setShader(new BitmapShader(source,
                            Shader.TileMode.CLAMP,
                            Shader.TileMode.CLAMP));
            Bitmap bitmap = Bitmap.createBitmap(
                    source.getWidth(),
                    source.getHeight(),
                    Bitmap.Config.ARGB_8888
            );
            Canvas canvas = new Canvas(bitmap);
            canvas.drawCircle(source.getWidth(),
                    source.getHeight(),
                    source.getWidth()/2,
                    paint);
            if(source != bitmap)
                bitmap.recycle();

            return bitmap;
        }

        @Override
        public String key() {
            return "Rounded image";
        }
    }

}










