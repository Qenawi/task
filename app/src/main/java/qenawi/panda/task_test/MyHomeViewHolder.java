package qenawi.panda.task_test;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyHomeViewHolder extends RecyclerView.ViewHolder
{
    @BindView(R.id.txt)
    TextView txt;
    @BindView(R.id.img)
    ImageView img;
    public MyHomeViewHolder(View itemView)
    {
        super(itemView);
        ButterKnife.bind(this , itemView);
    }
}
