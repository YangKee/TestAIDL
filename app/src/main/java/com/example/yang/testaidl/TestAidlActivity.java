package com.example.yang.testaidl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yang on 2017/3/20.
 */

public class TestAidlActivity extends Activity {
    private IMyAidlInterface mIMyAidlInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mIMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            mIMyAidlInterface = null;
        }
    };
    @OnClick({R.id.bind_btn, R.id.str_btn, R.id.obj_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bind_btn:
                bindService(new Intent(TestAidlActivity.this,TestAidlService.class),mServiceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.str_btn:
                try {
                    mIMyAidlInterface.add(new Student(1,"小三"));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.obj_btn:
                break;
        }
    }
}
