package qenawi.panda.task_test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import qenawi.panda.task_test.netWork.models.Result;


/**
 * Created by Ahmed Kamal on 21-11-2017.
 */

public class MyMainadapter extends RecyclerView.Adapter<MyHomeViewHolder> {
    private List<Result> movies;
    private Context c;
    Onclickx onclick;
    public MyMainadapter(@NonNull Onclickx onClickx, @NonNull List<Result> movies)
    {
        this.movies = movies;
        this.onclick=onClickx;
    }


    @Override
    public MyHomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.home_main_item, parent, false);
        c = parent.getContext();
        return new MyHomeViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyHomeViewHolder holder, int position) {
        Result movie = movies.get(position);
        OnBind(movie, holder);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void replaceData(List<Result> movies) {
        this.movies.clear();
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }

    public Result getItem(int position) {
        if (position < 0 || position >= movies.size()) {
            throw new InvalidParameterException("INVALID IDX");
        }
        return movies.get(position);
    }

    public void clearData() {
        movies.clear();
        notifyDataSetChanged();
    }

    private void OnBind(final Result data, MyHomeViewHolder viewHolder)
    {
        viewHolder.txt.setText(data.getCategory());
        RequestOptions options = new RequestOptions().centerCrop();
        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick.OnClick(null);
            }
        });

        switch (data.getCategory())
        {
            case "Men":
                Glide.with(c).load(R.drawable.men).apply(options).into(viewHolder.img);
                break;
            case "Women":
                Glide.with(c).load(R.drawable.women).apply(options).into(viewHolder.img);
                break;
            case "Kids":
                Glide.with(c).load(R.drawable.kids).apply(options).into(viewHolder.img);
                break;
        }
    }

    public interface Onclickx
    {
        void OnClick(Result Result);
    }
}
