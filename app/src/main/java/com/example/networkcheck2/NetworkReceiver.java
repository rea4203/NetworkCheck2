package com.example.networkcheck2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;

public class NetworkReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // 네트워크 상태 값 받아오기
        if (WifiManager.NETWORK_STATE_CHANGED_ACTION.equals(intent.getAction())) {
            NetworkInfo info = (NetworkInfo) intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            NetworkInfo.DetailedState state = info.getDetailedState();

            if (state == NetworkInfo.DetailedState.CONNECTED) {  // 네트워크 연결 상태면
                MainActivity.tv_st.setTextColor(Color.parseColor("#B6FB53"));
                MainActivity.tv_st.setText("네트워크 연결 완료");
            } else if (state == NetworkInfo.DetailedState.DISCONNECTED) {  // 네트워크 연결 해제면
                MainActivity.tv_st.setTextColor(Color.RED);
                MainActivity.tv_st.setText("네트워크 연결 해제");
            }
        }
    }
}
