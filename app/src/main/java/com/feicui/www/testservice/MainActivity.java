package com.feicui.www.testservice;

import android.app.Activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
   Button button1,button2,button3,button4;
    OnService on;
    ServiceConnection connection  = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            on = (OnService) service;
            on.callsleep();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.start_service);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.stop_service);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.bind_service);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.unbind_service);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_service:
                Intent intent = new Intent(MainActivity.this,MyService.class);
                intent.putExtra("a","b");
                startService(intent);
             break;
            case R.id.stop_service:
                Intent intent1 = new Intent(MainActivity.this,MyService.class);

                stopService(intent1);
                break;
            case R.id.bind_service:
                Intent intent2 = new Intent(MainActivity.this,MyService.class);
                intent2.putExtra("c","b");
                bindService(intent2,connection,BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:


                unbindService(connection);
                break;
        }
    }
}
