package com.donkingliang.groupedadapterdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import library.group.list.adapter.adapter.GroupedRecyclerViewAdapter;
import library.group.list.adapter.holder.BaseViewHolder;
import library.group.list.adapter.widget.StickyHeaderLayout;
import com.donkingliang.groupedadapterdemo.R;
import com.donkingliang.groupedadapterdemo.adapter.NoFooterAdapter;
import com.donkingliang.groupedadapterdemo.model.GroupModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 没有组头的分组列表。
 */
public class StickyActivity extends AppCompatActivity {

    private RecyclerView rvList;
    private StickyHeaderLayout stickyLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky_list);

        rvList = (RecyclerView) findViewById(R.id.rv_list);
        stickyLayout = (StickyHeaderLayout) findViewById(R.id.sticky_layout);

        rvList.setLayoutManager(new LinearLayoutManager(this));
        NoFooterAdapter adapter = new NoFooterAdapter(this, GroupModel.getGroups(10, 5));
        adapter.setOnHeaderClickListener(new GroupedRecyclerViewAdapter.OnHeaderClickListener() {
            @Override
            public void onHeaderClick(GroupedRecyclerViewAdapter adapter, BaseViewHolder holder,
                                      int groupPosition) {
                Toast.makeText(StickyActivity.this, "组头：groupPosition = " + groupPosition,
                        Toast.LENGTH_LONG).show();
                Log.e("eee", adapter.toString() + "  " + holder.toString());
            }
        });

        adapter.setOnChildClickListener(new GroupedRecyclerViewAdapter.OnChildClickListener() {
            @Override
            public void onChildClick(GroupedRecyclerViewAdapter adapter, BaseViewHolder holder,
                                     int groupPosition, int childPosition) {
                Toast.makeText(StickyActivity.this, "子项：groupPosition = " + groupPosition
                                + ", childPosition = " + childPosition,
                        Toast.LENGTH_LONG).show();
            }
        });
        rvList.setAdapter(adapter);

        //设置是否吸顶。
//        stickyLayout.setSticky(true);
    }

    public static void openActivity(Context context) {
        Intent intent = new Intent(context, StickyActivity.class);
        context.startActivity(intent);
    }
}
