package com.donkingliang.groupedadapterdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import library.group.list.adapter.adapter.GroupedRecyclerViewAdapter;
import library.group.list.adapter.holder.BaseViewHolder;
import com.donkingliang.groupedadapterdemo.R;
import com.donkingliang.groupedadapterdemo.adapter.VariousChildAdapter;
import com.donkingliang.groupedadapterdemo.model.GroupModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 多种子项类型的分组列表
 */
public class VariousChildActivity extends AppCompatActivity {

    private RecyclerView rvList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);

        rvList = (RecyclerView) findViewById(R.id.rv_list);

        rvList.setLayoutManager(new LinearLayoutManager(this));
        VariousChildAdapter adapter = new VariousChildAdapter(this, GroupModel.getGroups(10, 5));
        adapter.setOnChildClickListener(new GroupedRecyclerViewAdapter.OnChildClickListener() {
            @Override
            public void onChildClick(GroupedRecyclerViewAdapter adapter, BaseViewHolder holder,
                                     int groupPosition, int childPosition) {
                Toast.makeText(VariousChildActivity.this, "子项：groupPosition = " + groupPosition
                                + ", childPosition = " + childPosition,
                        Toast.LENGTH_LONG).show();
            }
        });
        rvList.setAdapter(adapter);

    }

    public static void openActivity(Context context) {
        Intent intent = new Intent(context, VariousChildActivity.class);
        context.startActivity(intent);
    }
}
