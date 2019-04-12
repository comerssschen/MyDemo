package cn.weipan.otherrecyclerviewtype;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * 作者：Created by cc on 2016/11/24 11:19.
 * 邮箱：904359289@QQ.com.
 * 类 ：
 */
public class RecyclAdapter extends RecyclerView.Adapter {

    public static final int TYPE_Type = 0;
    public static final int TYPE_content = 1;
    private final Context mContext;
    private final List<AllMessagBean> newses;

    public RecyclAdapter(MainActivity context, List<AllMessagBean> newses) {
        super();
        this.mContext = context;
        this.newses = newses;
    }

    @Override
    public int getItemViewType(int position) {
//        if (newses.get(position).getType().equals("0")) return TYPE_Type;
////        if (position % 4 == 0) return TYPE_Type;
//        return TYPE_content;

//        temp[0] + "收款", temp[3], temp[2], temp[1]
        //微信收款，2016/11/24 14:37:48，00000419000130742016112414374813，9，
//        String title, String content, String danhao, String maoney
        if (position > 0) {
            String[] splitpre = newses.get(position - 1).getContent().split(" ");
            String[] split = newses.get(position).getContent().split(" ");
            if (split[0].equals(splitpre[0])) {
                return TYPE_content;
            } else {
                return TYPE_Type;
            }
        } else {
            return TYPE_content;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        if (viewType == TYPE_content) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content, parent, false);
            return new ContentHolder(itemView);
        } else {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type, parent, false);
            return new TypeHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ContentHolder) {
            ((ContentHolder) holder).mTvTime.setText(newses.get(position).getContent());
            ((ContentHolder) holder).tv_title.setText(newses.get(position).getTitle());
        } else if (holder instanceof TypeHolder) {
            String[] split = newses.get(position).getContent().split(" ");
            ((TypeHolder) holder).mTvNickname.setText(split[0]);
            ((TypeHolder) holder).tv_type_right.setText(split[0]);
        }
    }

    @Override
    public int getItemCount() {
        return newses.size();
    }

    public static class ContentHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        TextView mTvTime;

        public ContentHolder(View itemView) {
            super(itemView);
            mTvTime = (TextView) itemView.findViewById(R.id.tv_time);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class TypeHolder extends RecyclerView.ViewHolder {
        TextView mTvNickname;
        TextView tv_type_right;

        public TypeHolder(View itemView) {
            super(itemView);
            mTvNickname = (TextView) itemView.findViewById(R.id.tv_nickname);
            tv_type_right = (TextView) itemView.findViewById(R.id.tv_type_right);
        }

    }


}
