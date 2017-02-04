package com.leslie.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ArrayActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array);
        listView = (ListView) findViewById(R.id.listview);

        ArrayList<String> names = new ArrayList<>();
        names.add("leslie");
        names.add("item1");
        names.add("item2");
        names.add("item3");
        names.add("item4");
        names.add("item5");
        names.add("item6");
        names.add("item7");
        names.add("item8");
        names.add("item9");
        names.add("item10");

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, names);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.array_item, R.id.my_textview, names);
        listView.setAdapter(adapter);
    }
}
