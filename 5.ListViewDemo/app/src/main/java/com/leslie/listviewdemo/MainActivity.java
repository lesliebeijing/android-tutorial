package com.leslie.listviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnArray, btnSimple, btnBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnArray = (Button) findViewById(R.id.array_adapter);
        btnSimple = (Button) findViewById(R.id.simple_adapter);
        btnBase = (Button) findViewById(R.id.base_adapter);
        btnArray.setOnClickListener(this);
        btnSimple.setOnClickListener(this);
        btnBase.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.array_adapter:
                Intent intent = new Intent(this, ArrayActivity.class);
                startActivity(intent);
                break;
            case R.id.simple_adapter:
                Intent simpleIntent = new Intent(this, SimpleActivity.class);
                startActivity(simpleIntent);
                break;
            case R.id.base_adapter:
                Intent baseIntent = new Intent(this, BaseActivity.class);
                startActivity(baseIntent);
                break;
        }
    }
}
