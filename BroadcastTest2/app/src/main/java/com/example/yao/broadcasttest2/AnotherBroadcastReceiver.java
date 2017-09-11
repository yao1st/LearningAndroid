package com.example.yao.broadcasttest2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Yao on 2017/9/2.
 */

public class AnotherBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "This is AnotherBroadcastReceiver", Toast.LENGTH_SHORT).show();
    }
}
