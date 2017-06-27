package com.weullermarcos.usandobluetooth;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Set;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    ListView lstDevices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstDevices = (ListView) findViewById(R.id.lstDevices);

        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);

        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1);
                ProgressDialog progress = new ProgressDialog(context);
                String action = intent.getAction();

                if(BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)){

                    progress = ProgressDialog.show(MainActivity.this, "Bluetooth", "Procurando dispositivos...");
                    progress.show();

                }
                else if(BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)){
                    progress.dismiss();
                }
                else if(BluetoothDevice.ACTION_FOUND.equals(action)){

                    BluetoothDevice device = (BluetoothDevice) intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                    adapter.add(device.getName() + "\n" + device.getAddress());

                }
            }
        };

        registerReceiver(receiver, filter);


//        Forma 1 de fazer
//        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
//        Set<BluetoothDevice> pairedDevices = btAdapter.getBondedDevices();
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
//
//        //setar o adapter na lista
//        lstDevices.setAdapter(adapter);
//
//        if(pairedDevices.size() > 0){
//            for (BluetoothDevice device : pairedDevices){
//                adapter.add(device.getName() + "\n" + device.getAddress());
//            }
//        }


    }

    private void continueDoDiscvery(){

        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        btAdapter.startDiscovery();

    }

    @Override
    public void onClick(View view) {


    }
}
