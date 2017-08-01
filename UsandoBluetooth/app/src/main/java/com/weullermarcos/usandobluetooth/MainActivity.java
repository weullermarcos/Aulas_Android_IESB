package com.weullermarcos.usandobluetooth;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;
import java.util.jar.Manifest;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_FINE_LOCATION = 0;

    ListView lstDevices;
    private final int REQUEST_ENABLE_BT = 7;
    private ArrayAdapter<String> mArrayAdapter;
    Dialog mProgressDlg;

    BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //cria lista de dispositivos
        lstDevices = (ListView) findViewById(R.id.lstDevices);
        mArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        lstDevices.setAdapter(mArrayAdapter);


        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }

        IntentFilter filter = new IntentFilter();
        filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        filter.addAction(BluetoothDevice.ACTION_FOUND);


        BroadcastReceiver mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                String action = intent.getAction();

                if (BluetoothAdapter.ACTION_STATE_CHANGED.equals(action)){

                    final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);

                    if(state == BluetoothAdapter.STATE_ON){
                        showToast("ACTION_STATE_CHANGED: STATE_ON");
                    }

                }
                else if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)) {
                    showToast("ACTION_DISCOVERY_STARTED");

                    if(mProgressDlg != null && mProgressDlg.isShowing())
                        mProgressDlg.dismiss();

                    mProgressDlg = ProgressDialog.show(context, "Buscando..", "Buscando dispositivos", false, false);
                }

                else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {

                    mProgressDlg.dismiss();
                    showToast("ACTION_DISCOVERY_FINISHED");

                    BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                    if (device != null){

                        mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                        showToast("Device found = " + device.getName());
                    }


//                    Intent newIntent = new Intent(MainActivity.this, DeviceListActivity.class);
//                    newIntent.putParcelableArrayListExtra("device.list", mDeviceList);
//                    startActivity(newIntent);
                }
                else if (BluetoothDevice.ACTION_FOUND.equals(action)) {// When discovery finds a device
                    // Get the BluetoothDevice object from the Intent
                    BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
//                    mDeviceList.add(device);
                    mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                    showToast("Device found = " + device.getName());
                }
            }
        };


        registerReceiver(mReceiver, filter);

        //ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION);

        loadPermissions(android.Manifest.permission.ACCESS_FINE_LOCATION, REQUEST_FINE_LOCATION);

        //inicia a discoberta de novos dispositivos
        mBluetoothAdapter.startDiscovery();



//        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
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

    private void loadPermissions(String perm, int requestCode) {

        Log.d("MENSAGEM: ","ENTROU NO LOAD");

        if (ContextCompat.checkSelfPermission(this, perm) != PackageManager.PERMISSION_GRANTED) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this, perm)) {
                ActivityCompat.requestPermissions(this, new String[]{perm},requestCode);
            }
        }
    }

    //exibe toast
    private void showToast(String message){

        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}


