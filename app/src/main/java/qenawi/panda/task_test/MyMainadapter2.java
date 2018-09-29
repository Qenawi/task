package qenawi.panda.task_test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Random;

import io.reactivex.annotations.NonNull;
import qenawi.panda.task_test.netWork.models.Result;


/**
 * Created by Ahmed Kamal on 21-11-2017.
 */

public class MyMainadapter2 extends RecyclerView.Adapter<MyDetailsViewHolder> {
    private List<Result> movies;
    private Context c;
    Onclickx onclick;
    Toast toast;

    public MyMainadapter2(@NonNull Onclickx onClickx, @NonNull List<Result> movies) {
        this.movies = movies;
        this.onclick = onClickx;
    }


    @Override
    public MyDetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        c = parent.getContext();
        return new MyDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyDetailsViewHolder holder, int position) {
        Result movie = new Result();

        Random random = new Random();
        int x = random.nextInt(90) + 20;
        movie.setCategory(x + "%");
        OnBind(movie, holder);
    }

    @Override
    public int getItemCount() {
        if (movies == null || movies.isEmpty()) return 20;
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

    private void OnBind(final Result data, MyDetailsViewHolder viewHolder) {
        viewHolder.txt.setText(data.getCategory());
        RequestOptions options = new RequestOptions().centerCrop();
        Random random = new Random();
        int x = random.nextInt(3) + 1;
        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick.OnClick(null);
            }
        });
        viewHolder.img1.setOnClickListener(view -> showToast("added to cart ;)"));
        viewHolder.img2.setOnClickListener(view -> showToast("you need to log in"));

        switch (x) {
            case 1:
                Glide.with(c).load(R.drawable.men).apply(options).into(viewHolder.img);
                break;
            case 2:
                Glide.with(c).load(R.drawable.women).apply(options).into(viewHolder.img);
                break;
            case 3:
                Glide.with(c).load(R.drawable.kids).apply(options).into(viewHolder.img);
                break;
        }
    }

    public interface Onclickx {
        void OnClick(Result Result);
    }

    void showToast(String s) {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
        toast = Toast.makeText(c, s, Toast.LENGTH_SHORT);
        toast.show();
    }
}
