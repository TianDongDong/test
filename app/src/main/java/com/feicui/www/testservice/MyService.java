package com.feicui.www.testservice;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import android.util.Log;

import java.io.FileDescriptor;

/**
 * Created by Administrator on 2016/10/21.
 */
public class MyService extends Service {
    String TAG = "aac";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: " );
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand: "+intent.getStringExtra("a") );
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy: " );
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        super.unbindService(conn);
        Log.e(TAG, "unbindService: " );
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind: " );
        return super.onUnbind(intent);
    }
   public void sleep(){

       Log.e(TAG, "sleep: " +"我要睡觉了");
   }
    public void eat(){
        Log.e(TAG, "sleep: " +"我要吃饭了");
    }
    public void paly(){
        Log.e(TAG, "sleep: " +"我要玩耍了");
    }
    private class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
       public void callsleep(){
            sleep();
        }
    }

}
