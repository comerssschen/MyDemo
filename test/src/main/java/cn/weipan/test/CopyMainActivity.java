package cn.weipan.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class CopyMainActivity extends Activity {
    private ArrayList<String> dataset;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copy_main);
        initView();


    }



    private void initView() {
        // 创建数据集
        dataset = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            dataset.add("item = " + i);
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layout);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        MyAdapter adapter = new MyAdapter(CopyMainActivity.this, dataset);
        adapter.setOnItemClickLitener(new MyAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                int id = view.getId();
                Log.i("test", String.valueOf(id));
                switch (view.getId()) {
                    case R.id.bt1:
                        showToast(position + "" + "_bt1");
                        break;
                    case R.id.bt2:
                        showToast(position + "" + "_bt2");
                        break;
                    case R.id.bt3:
                        showToast(position + "" + "_bt3");
                        break;
                    case R.id.bt4:
                        showToast(position + "" + "_bt4");
                        break;
                    default:
                        break;
                }
            }
        });
        recyclerView.setAdapter(adapter);
    }

    public void showToast(String test) {
        toast = Toast.makeText(CopyMainActivity.this, test, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

}
