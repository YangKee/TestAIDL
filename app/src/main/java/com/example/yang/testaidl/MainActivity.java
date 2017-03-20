package com.example.yang.testaidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private TestService mTestService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;
    }


    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mTestService = ((TestService.MyBinder) service).getService();
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            mTestService = null;
        }
    };
    @OnClick({R.id.bind_btn, R.id.str_btn, R.id.obj_btn,R.id.next_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bind_btn:
                Intent intent = new Intent(mContext, TestService.class);
                mContext.bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.str_btn:
                if (null != mTestService) {
                    mTestService.showMsg("小明同学");
                }
                break;
            case R.id.obj_btn:
                if (null != mTestService) {
                    mTestService.showMsg(new Student(0, "小花"));
                }
            case R.id.next_btn:
                startActivity(new Intent(MainActivity.this,TestAidlActivity.class));
                break;
        }
    }
}
