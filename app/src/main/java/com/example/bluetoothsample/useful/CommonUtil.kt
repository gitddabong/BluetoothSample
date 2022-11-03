package com.example.bluetoothsample.useful

import android.content.Intent
import android.util.Log

open class CommonUtil {
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