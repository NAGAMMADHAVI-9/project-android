package com.example.step_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import com.example.step_counter.Preferences;
import com.example.step_counter.StepCounter;







/**
 * Created by Paito Anderson on 2014-04-26.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if the service is running
        if (!isServiceRunning()) {

            // Mark Service as Started
            Preferences.setServiceRun(this, false);

            // Start Step Counting service
            Intent serviceIntent = new Intent(this, StepCounter.class);
            startService(serviceIntent);
        }

        // Exit Activity
        finish();
    }

    private boolean isServiceRunning() {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if ("com.paitoanderson.stepcounter.services.StepCounter".equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
