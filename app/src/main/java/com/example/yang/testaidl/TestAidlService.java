package com.example.yang.testaidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Yang on 2017/3/20.
 */

public class TestAidlService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }



    private Binder mBinder = new IMyAidlInterface.Stub() {
        @Override
        public void add(Student student) throws RemoteException {
            Log.e("TestAidlService","student--"+student.toString());
        }
    };
}
