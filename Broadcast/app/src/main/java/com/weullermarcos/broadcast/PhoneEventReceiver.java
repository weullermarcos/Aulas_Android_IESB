package com.weullermarcos.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by weullermarcos on 12/06/17.
 */

public class PhoneEventReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){



        }

    }
}
