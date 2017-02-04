package com.leslie.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        ListView listView = (ListView) findViewById(R.id.listview);

        List<Map<String, String>> data = new ArrayList<>();
        HashMap<String, String> map;

        map = new HashMap<>();
        map.put("name", "leslie");
        map.put("age", "28");
        data.add(map);

        map = new HashMap<>();
        map.put("name", "xiaomin");
        map.put("age", "25");
        data.add(map);

        map = new HashMap<>();
        map.put("name", "zhanglu");
        map.put("age", "22");
        data.add(map);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, android.R.layout.simple_expandable_list_item_2,
                new String[]{"name", "age"}, new int[]{android.R.id.text1, android.R.id.text2});
        listView.setAdapter(simpleAdapter);
    }
}
