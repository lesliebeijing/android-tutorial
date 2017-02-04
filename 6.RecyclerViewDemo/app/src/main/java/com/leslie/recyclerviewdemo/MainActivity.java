package com.leslie.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<User> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        data = new ArrayList<>();
        data.add(new User("item1", 22));
        data.add(new User("item2", 21));
        data.add(new User("item3", 25));
        data.add(new User("item4", 28));
        data.add(new User("item5", 23));
        data.add(new User("item6", 29));
        data.add(new User("item7", 18));
        data.add(new User("item8", 20));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout, parent, false);
            final MyViewHolder holder = new MyViewHolder(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    User user = (User) v.getTag();
                    Toast.makeText(getApplicationContext(), user.getName(), Toast.LENGTH_SHORT).show();
                }
            });

            holder.tvAge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    User user = (User) holder.itemView.getTag();
                    Toast.makeText(getApplicationContext(), user.getAge() + "", Toast.LENGTH_SHORT).show();
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            User user = data.get(position);
            holder.tvName.setText(user.getName());
            holder.tvAge.setText(user.getAge() + "");
            holder.itemView.setTag(user);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAge;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.name);
            tvAge = (TextView) itemView.findViewById(R.id.age);
        }
    }
}
