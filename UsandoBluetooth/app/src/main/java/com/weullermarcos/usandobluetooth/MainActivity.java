package com.weullermarcos.usandobluetooth;

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

        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> pairedDevices = btAdapter.getBondedDevices();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        //setar o adapter na lista
        lstDevices.setAdapter(adapter);

        if(pairedDevices.size() > 0){
            for (BluetoothDevice device : pairedDevices){
                adapter.add(device.getName() + "\n" + device.getAddress());
            }
        }
    }

    @Override
    public void onClick(View view) {


    }
}
