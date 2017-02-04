package com.leslie.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {
    List<User> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ListView listView = (ListView) findViewById(R.id.listview);
        data = new ArrayList<>();
        data.add(new User("小敏", 25));
        data.add(new User("小房", 28));
        data.add(new User("张磊", 22));
        data.add(new User("张胜男", 21));
        data.add(new User("露露", 18));

        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                TextView tvName = (TextView) view.findViewById(R.id.base_item_name);
//                tvName.getText();

                User user = (User) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), user.getName() + " " + user.getAge(), Toast.LENGTH_LONG).show();
            }
        });
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.base_item, null);
                holder.tvName = (TextView) convertView.findViewById(R.id.base_item_name);
                holder.tvAge = (TextView) convertView.findViewById(R.id.base_item_age);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            User user = data.get(position);
            holder.tvName.setText(user.getName());
            holder.tvAge.setText(user.getAge() + "");
            return convertView;
        }

        class ViewHolder {
            TextView tvName;
            TextView tvAge;
        }
    }
}
