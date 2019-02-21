package com.chrissen.elasticdragdismisslayout.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chrissen.elasticdragdismisslayout.DetailActivity;
import com.chrissen.elasticdragdismisslayout.R;
import com.chrissen.elasticdragdismisslayout.bean.ContentBean;

import java.util.List;

/**
 * Function:
 * <br/>
 * Describe:
 * <br/>
 * Author: chris on 2019/2/21.
 * <br/>
 * Email: chrissen0814@gmail.com
 */

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentViewHolder> {

    private static final String TAG = "ContentAdapter";

    private Context mContext;
    private List<ContentBean> mContentBeanList;

    public ContentAdapter(Context context, List<ContentBean> contentBeanList) {
        mContext = context;
        mContentBeanList = contentBeanList;
    }


    @NonNull
    @Override
    public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_content, viewGroup, false);
        return new ContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder contentViewHolder, int i) {
        final ContentBean contentBean = mContentBeanList.get(i);
        Glide.with(mContext)
                .load(contentBean.getImageUrl())
                .into(contentViewHolder.ivImage);
        contentViewHolder.tvContent.setText(contentBean.getContent());
        contentViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailActivity.actionStart(mContext, contentBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mContentBeanList.size();
    }

    class ContentViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvContent;
        public ContentViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_image);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }

}
