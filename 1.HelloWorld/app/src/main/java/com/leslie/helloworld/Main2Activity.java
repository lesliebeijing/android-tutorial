package com.leslie.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("leslie", "Main2Activity onCreate");

        User user = getIntent().getParcelableExtra("user");
        if (user != null) {
            Log.d("leslie", user.getName() + " " + user.getAge());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("leslie", "Main2Activity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("leslie", "Main2Activity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("leslie", "Main2Activity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("leslie", "Main2Activity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("leslie", "Main2Activity onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("leslie", "Main2Activity onRestart");
    }
}
