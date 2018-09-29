package qenawi.panda.task_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import qenawi.panda.task_test.netWork.SingleToneRetrofit;
import qenawi.panda.task_test.netWork.home_api;
import qenawi.panda.task_test.netWork.models.Result;

public class MainActivity extends AppCompatActivity implements MyMainadapter.Onclickx {
    private MyMainadapter adapter;
    @BindView(R.id.rv)
    RecyclerView recyclerView;
    CompositeDisposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        disposable = new CompositeDisposable();
        initView();
        GetData();
    }

    private void initView() {
        adapter = new MyMainadapter(this, new ArrayList<Result>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void OnClick(Result Result) {
startActivity(new Intent(this,MainActivity2.class));
    }

    void GetData()
    {
        home_api api = SingleToneRetrofit.get_Retrofit().create(home_api.class);
        disposable.add(
                api.getMainCats()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe
                                (
                                e->{
                                    Sucess(e.getResult());
                                }
                                ,t->{
                                            Faild(t);
                                        }
                        )
        );
    }
    void Sucess(List<Result> results)
    {
        adapter.replaceData(results);
    }
    void Faild(Throwable t)
    {
        Toast.makeText(this,t.getMessage(),Toast.LENGTH_SHORT).show();
    }
}
