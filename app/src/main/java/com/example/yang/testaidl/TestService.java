package com.example.yang.testaidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Yang on 2017/3/17.
 */

public class TestService extends Service {
    private Student mStudent;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public class MyBinder extends Binder {
        TestService getService() {
            return TestService.this;
        }

    }

    public void showMsg(Student s) {
        if (null == s)
            return;
        this.mStudent = s;
        Log.e("TestService", this.mStudent.toString());
        try {
            Thread.sleep(30*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void showMsg(String s) {
        if (null == s)
            return;
        Log.e("TestService", s);
    }
}
