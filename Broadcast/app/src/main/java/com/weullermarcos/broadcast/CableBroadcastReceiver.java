package com.weullermarcos.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by weullermarcos on 12/06/17.
 */

public class CableBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        //verifica se o cabo foi conectado
        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            Toast.makeText(context, "CABO DE ENERGIA CONECTADO", Toast.LENGTH_LONG).show();
        }

        //verifica se o cabo foi desconectado
        if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
            Toast.makeText(context, "CABO DE ENERGIA DESCONECTADO", Toast.LENGTH_LONG).show();
        }

    }
}
