package com.example.todolist.mvp.content;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;
import com.example.todolist.bean.ContentBean;

import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentHolder> {

    private Context context;

    private List<ContentBean> data;

    public ContentAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ContentBean> contentBeanList) {
        data = contentBeanList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContentAdapter.ContentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_content, parent, false);
        return new ContentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentAdapter.ContentHolder holder, int position) {
        ContentBean contentBean = data.get(position);
        holder.content.setText(contentBean.getContent());

        switch (contentBean.getType()) {
            case 0: {
                holder.contentLabel.setText("未完成");
                holder.contentLabel.setTextColor(context.getResources().getColor(R.color.color_red));
            }
            case 1: {
                holder.contentLabel.setText("已完成");
                holder.contentLabel.setTextColor(context.getResources().getColor(R.color.color_green));
            }
        }

    }

    @Override
    public int getItemCount() {
        return data == null? 0 : data.size();
    }

    public static class ContentHolder extends RecyclerView.ViewHolder {
        TextView content;
        TextView contentLabel;

        public ContentHolder(@NonNull View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.content);
            contentLabel = itemView.findViewById(R.id.content_label);
        }
    }
}