package qenawi.panda.task_test;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyDetailsViewHolder extends RecyclerView.ViewHolder
{
    @BindView(R.id.txt)
    TextView txt;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.img2)
    ImageView img2;
    @BindView(R.id.img3)
    ImageView img3;
    public MyDetailsViewHolder(View itemView)
    {
        super(itemView);
        ButterKnife.bind(this , itemView);
    }
}
