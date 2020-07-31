package com.example.step_counter;


        import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;


        import com.example.step_counter.Preferences;
        import com.example.step_counter.StepCounter;


/**
 * Created by Paito Anderson on 2014-04-27.
 */
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        // Clear Steps
        Preferences.clearStepCount(context);

        // Check if the Step Counter service was running?
        if (Preferences.shouldServiceRun(context))
        {
            // Start Step Counter service
            Intent myIntent = new Intent(context, StepCounter.class);
            context.startService(myIntent);
        }
    }
}
