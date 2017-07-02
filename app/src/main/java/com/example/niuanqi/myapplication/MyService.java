package com.example.niuanqi.myapplication;

import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends IMyAidlInterface.Stub {
    public MyService() {
    }


    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

    }

    @Override
    public String get() throws RemoteException {
        return null;
    }

    @Override
    public void set(String s) throws RemoteException {

    }
}
