package com.leslie.servicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnStart, btnStop, btnBind, btnUnBind;
    CalculateService calculateService;
    boolean bounded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button) findViewById(R.id.start_service);
        btnStop = (Button) findViewById(R.id.stop_service);
        btnBind = (Button) findViewById(R.id.bind_service);
        btnUnBind = (Button) findViewById(R.id.unbind_service);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyService.class);
                startService(intent);
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyService.class);
                stopService(intent);
            }
        });


        btnBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CalculateService.class);

//                startService(intent);
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
            }
        });
        btnUnBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(serviceConnection);
            }
        });
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("leslie", "onServiceConnected");
            calculateService = ((CalculateService.MyBinder) service).getService();
            bounded = true;

            int sum = calculateService.add(3, 4);
            Toast.makeText(getApplicationContext(), sum + "", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("leslie", "onServiceDisconnected");
            calculateService = null;
            bounded = false;
        }
    };
}
