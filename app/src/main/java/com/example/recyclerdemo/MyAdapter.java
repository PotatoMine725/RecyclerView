package com.example.recyclerdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

// Thay đổi kiểu dữ liệu từ String sang MyItem
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<MyItem> mData;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    // Constructor nhận vào ArrayList<MyItem>
    public MyAdapter(ArrayList<MyItem> data) {
        mData = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Sử dụng layout recycler_item.xml của bạn
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Lấy đối tượng MyItem tại vị trí hiện tại
        MyItem currentItem = mData.get(position);

        // Gắn dữ liệu vào các TextView thông qua holder
        holder.textViewTitle.setText(currentItem.getTitle());
        holder.textViewSubtitle.setText(currentItem.getSubtitle());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    // Lớp MyViewHolder đã được cập nhật
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // 1. Khai báo hai TextView
        public TextView textViewTitle;
        public TextView textViewSubtitle;

        public MyViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            // 2. Ánh xạ các TextView từ layout
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewSubtitle = itemView.findViewById(R.id.textViewSubtitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
