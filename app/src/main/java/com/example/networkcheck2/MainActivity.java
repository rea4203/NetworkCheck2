package com.example.networkcheck2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static TextView tv_st;
    private NetworkReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_st = findViewById(R.id.tv_st);

        // 브로드 캐스트 리시버 등록
        IntentFilter filter = new IntentFilter(); // 암시적 Intent 이쪽을 알아서 이 이용해?
        receiver = new NetworkReceiver();
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);  // 네트워크 변환 값을 추가해라
        registerReceiver(receiver, filter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //  브로드 캐스트 리시버 해제
        unregisterReceiver(receiver);
    }
}