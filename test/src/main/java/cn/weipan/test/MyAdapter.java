package cn.weipan.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Created by cc on 2016/11/21 15:34.
 * 邮箱：904359289@QQ.com.
 * 类 ：
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    private Context mContext;
    private List<String> mDataset;

    public MyAdapter(Context context, ArrayList<String> dataset) {
        this.mContext = context;
        this.mDataset = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = View.inflate(mContext, R.layout.item, null);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (mOnItemClickLitener != null) {
            holder.bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickLitener.onItemClick(holder.bt1, position);
                }
            });
            holder.bt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickLitener.onItemClick(holder.bt2, position);
                }
            });
            holder.bt3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickLitener.onItemClick(holder.bt3, position);
                }
            });
            holder.bt4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickLitener.onItemClick(holder.bt4, position);
                }
            });
        }
        holder.bt1.setText(position + "" + "_1");
        holder.bt2.setText(position + "" + "_2");
        holder.bt3.setText(position + "" + "_3");
        holder.bt4.setText(position + "" + "_4");
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Button bt1;
        public Button bt2;
        public Button bt3;
        public Button bt4;

        public ViewHolder(View itemView) {
            super(itemView);
            bt1 = (Button) itemView.findViewById(R.id.bt1);
            bt2 = (Button) itemView.findViewById(R.id.bt2);
            bt3 = (Button) itemView.findViewById(R.id.bt3);
            bt4 = (Button) itemView.findViewById(R.id.bt4);
        }
    }
}
