package cn.weipan.otherrecyclerviewtype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mSuspensionBar;
    private TextView mSuspensionTv;
    private TextView tv_type_right;
    private int mSuspensionHeight;
    private int mCurrentPosition = 0;
    private RecyclAdapter adapter;
    private List<AllMessagBean> list;
    private List<TypeBean> listType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSuspensionBar = (RelativeLayout) findViewById(R.id.suspension_bar);
        mSuspensionTv = (TextView) findViewById(R.id.tv_tsuspension_bare);
        tv_type_right = (TextView) findViewById(R.id.tv_type_right);
        list = new ArrayList<>();
        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/25 14:37:48", "00000419000130742016112414374813", "55"));

        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/25 14:37:48", "00000419000130742016112414374813", "55"));

        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/25 14:37:48", "00000419000130742016112414374813", "55"));

        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/25 14:37:48", "00000419000130742016112414374813", "55"));

        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/25 14:37:48", "00000419000130742016112414374813", "55"));

        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/25 14:37:48", "00000419000130742016112414374813", "55"));

        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/25 14:37:48", "00000419000130742016112414374813", "55"));

        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/24 14:37:48", "00000419000130742016112414374813", "9"));
        list.add(new AllMessagBean("微信收款", "2016/11/25 14:37:48", "00000419000130742016112414374813", "55"));
        initView();

    }

    private void initView() {
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        adapter = new RecyclAdapter(MainActivity.this, list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.feed_list);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                mSuspensionHeight = mSuspensionBar.getHeight();
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (adapter.getItemViewType(mCurrentPosition + 1) == RecyclAdapter.TYPE_Type) {
                    View view = linearLayoutManager.findViewByPosition(mCurrentPosition + 1);
                    if (view != null) {
                        if (view.getTop() <= mSuspensionHeight) {
                            mSuspensionBar.setY(-(mSuspensionHeight - view.getTop()));
                        } else {
                            mSuspensionBar.setY(0);
                        }
                    }
                }

                if (mCurrentPosition != linearLayoutManager.findFirstVisibleItemPosition()) {
                    mCurrentPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    mSuspensionBar.setY(0);

                    mSuspensionTv.setText(list.get(mCurrentPosition).getContent().split(" ")[0]);
                    tv_type_right.setText(list.get(mCurrentPosition).getContent().split(" ")[0]);
                }
            }
        });


    }

}
