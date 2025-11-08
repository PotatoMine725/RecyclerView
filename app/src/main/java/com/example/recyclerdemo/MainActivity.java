package com.example.recyclerdemo;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView2111;
    private MyAdapter mAdapter2111;
    private ArrayList<MyItem> mItemList2111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Tạo dữ liệu mẫu
        createData();

        // 2. Thiết lập RecyclerView
        setupRecyclerView();

        handleItemClick();
    }

    // Hàm tạo dữ liệu mẫu để hiển thị
    private void createData() {
        mItemList2111 = new ArrayList<>();
        mItemList2111.add(new MyItem("Android Studio", "IDE chính thức để phát triển ứng dụng Android."));
        mItemList2111.add(new MyItem("RecyclerView", "Một View linh hoạt để hiển thị danh sách lớn."));
        mItemList2111.add(new MyItem("Java", "Ngôn ngữ lập trình phổ biến cho Android."));
        mItemList2111.add(new MyItem("Kotlin", "Ngôn ngữ hiện đại được Google đề xuất cho Android."));
        mItemList2111.add(new MyItem("C++", "Ngôn ngữ mạnh mẽ cho nhúng và game activity trong Android"));
        for (int i = 1; i <= 15; i++) {
            mItemList2111.add(new MyItem("Tiêu đề " + i, "Đây là mô tả cho mục số " + i));
        }
    }
    private void setupRecyclerView() {
        // Ánh xạ RecyclerView từ layout
        mRecyclerView2111 = findViewById(R.id.recyclerView);

        // Cấu hình để RecyclerView không thay đổi kích thước khi nội dung thay đổi
        mRecyclerView2111.setHasFixedSize(true);

        // Thiết lập LayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView2111.setLayoutManager(layoutManager);

        // Khởi tạo Adapter và truyền dữ liệu vào
        mAdapter2111 = new MyAdapter(mItemList2111);

        // Gắn Adapter vào RecyclerView
        mRecyclerView2111.setAdapter(mAdapter2111);
    }

    // Hàm xử lý khi một item trong danh sách được nhấn
    private void handleItemClick() {
        mAdapter2111.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Lấy item được click
                MyItem clickedItem = mItemList2111.get(position);
                String title = clickedItem.getTitle();

                // Hiển thị thông báo Toast
                Toast.makeText(MainActivity.this, "Bạn đã nhấn vào: " + title, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
