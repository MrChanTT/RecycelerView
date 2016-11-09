package com.example.chenquan.recycelrview;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> mData;
    private MyAdapter myAdapter;
    private PackageManager mPackageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        mPackageManager = this.getPackageManager();
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview_main);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter();
        mRecyclerView.setAdapter(myAdapter);
    }
        private void initData(){
            mData = new ArrayList<>();
            for(int i='A';i<='Z';i++){
                mData.add(""+(char)i);
                Log.i("log","log"+i);
            }
        }

        class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
            @Override
            public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                MyViewHolder holder = new MyViewHolder(getLayoutInflater().from(
                        MainActivity.this).inflate(R.layout.recyclerview_item, parent,
                        false));
                return holder;
            }

            @Override
            public void onBindViewHolder(MyViewHolder holder, int position) {
                holder.tv.setText(mData.get(position));
            }

            @Override
            public int getItemCount() {
                return mData.size();
            }
            class MyViewHolder extends RecyclerView.ViewHolder{
                TextView tv;
                public MyViewHolder(View view){
                    super(view);
                    tv = (TextView) view.findViewById(R.id.tv_recyclerview_item);
                }

            }
        }
    


}
