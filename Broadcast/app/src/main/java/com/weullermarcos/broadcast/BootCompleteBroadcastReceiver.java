package com.weullermarcos.broadcast;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by weullermarcos on 12/06/17.
 */

public class BootCompleteBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent it = new Intent(context, MainActivity.class);

        PendingIntent pIntent = PendingIntent.getActivity(context,0,it,PendingIntent.FLAG_ONE_SHOT);

        Notification n = new Notification.Builder(context)
                .setContentTitle("TITULO")
                .setContentText("Booot completooo")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
                .build();

        nm.notify(0,n);

    }
}
