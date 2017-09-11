package com.example.yao.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Yao on 2017/9/2.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, " Received in my Receiver", Toast.LENGTH_SHORT).show();
        abortBroadcast();
    }
}
