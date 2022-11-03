package com.example.bluetoothsample

import android.bluetooth.BluetoothHeadset
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bluetoothsample.broadcastreceiver.BluetoothReceiver

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bluetoothReceiver = BluetoothReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction(BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED)
        intentFilter.addAction(BluetoothHeadset.ACTION_VENDOR_SPECIFIC_HEADSET_EVENT)
        intentFilter.addAction(BluetoothHeadset.ACTION_AUDIO_STATE_CHANGED)
        this.registerReceiver(bluetoothReceiver, intentFilter)

    }
}