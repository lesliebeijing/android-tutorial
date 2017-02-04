package com.leslie.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("leslie", "onCreate");

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                User user = new User("xiaomin", 25);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });

        Button btnImplicit = (Button) findViewById(R.id.btn_yinshi);
        btnImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.leslie.action.hello");
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("leslie", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("leslie", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("leslie", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("leslie", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("leslie", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("leslie", "onRestart");
    }
}

