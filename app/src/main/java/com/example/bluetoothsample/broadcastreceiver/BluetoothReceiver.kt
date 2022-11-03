package com.example.bluetoothsample.broadcastreceiver

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothProfile
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.bluetoothsample.useful.CommonUtil

const val BLUETOOTH_DISCONNECTED = 0
const val BLUETOOTH_CONNECTING = 1
const val BLUETOOTH_CONNECTED = 2

class BluetoothReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        Log.d("wonjong", "$action")
        Log.d("wonjong", "${intent.getIntExtra(BluetoothProfile.EXTRA_STATE, -1)}")
        Log.d("wonjong", "${intent.getIntExtra(BluetoothProfile.EXTRA_PREVIOUS_STATE, -1)}")
        Log.d("wonjong", "${intent.getStringExtra(BluetoothDevice.EXTRA_DEVICE)}")
        printIntent(intent)

        val currentState = intent.getIntExtra(BluetoothProfile.EXTRA_STATE, -1)
        val previousState = intent.getIntExtra(BluetoothProfile.EXTRA_PREVIOUS_STATE, -1)

        if (currentState == BLUETOOTH_CONNECTED && previousState == BLUETOOTH_CONNECTING) {
            Toast.makeText(context, "블루투스가 연결되었습니다..", Toast.LENGTH_SHORT).show()
        }
        else if (currentState == BLUETOOTH_DISCONNECTED && previousState == BLUETOOTH_CONNECTED) {
            Toast.makeText(context, "블루투스 연결이 끊겼습니다.", Toast.LENGTH_SHORT).show()
        }

    }

    fun printIntent(i: Intent?) {
        try {
            Log.d("wonjong", "-------------------------------------------------------")
            Log.d("wonjong","intent = $i")
            if (i != null) {
                val extras = i.extras
                Log.d("wonjong", "extras = $extras")
                if (extras != null) {
                    val keys: Set<*> = extras.keySet()
                    Log.d("wonjong", "++ bundle key count = " + keys.size)
                    for (_key in extras.keySet()) {
                        Log.d("wonjong", "key=" + _key + " : " + extras[_key])
                    }
                }
            }
        } catch (e: Exception) {
            Log.d("wonjong", "$e")
        } finally {
            Log.e("wonjong", "-------------------------------------------------------")
        }
    }
}