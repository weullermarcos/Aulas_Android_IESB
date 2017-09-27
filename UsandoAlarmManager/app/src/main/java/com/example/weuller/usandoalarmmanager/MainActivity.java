package com.example.weuller.usandoalarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        alarmeUmaVez();
        alarmeQueRepete();

    }

    //dispara alarme uma única vez contando a partir do tempo que o telefone está ligado
    public void alarmeUmaVez(){

        AlarmManager alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        //disparando o alarme após 20 segundos
        alarmMgr.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,  SystemClock.elapsedRealtime() + 10 * 1000, alarmIntent);
    }

    public void alarmeQueRepete(){

        AlarmManager alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        // só vai executar alarme após as 14
        calendar.set(Calendar.HOUR_OF_DAY, 13);
        long inicio = calendar.getTimeInMillis();

        //cria o intervalo de repetição
        long intervalo =  10 * 1000;

        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, inicio, intervalo, alarmIntent);

    }

}
