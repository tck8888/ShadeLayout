package com.wejiji.shadelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private List<UserBean> mData = new ArrayList<>();
    private TestAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        mListView = (ListView) findViewById(R.id.listview);
        mAdapter = new TestAdapter(this,mData);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ((ShadeLayout)(mAdapter.getView(position,view,parent))).setViewVisible(true);

                Toast.makeText(MainActivity.this, "测试", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

       mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               ((ShadeLayout)(mAdapter.getView(position,view,parent))).setViewVisible(false);
           }
       });

    }

    private void initData() {
        for (int i = 0; i < 50; i++) {
            mData.add(new UserBean(R.mipmap.ic_launcher, "张三" + i, "Android程序员" + i));
        }
    }
}
