package id.handi.jogjatour.service;

/**
 * Created by akang on 18/05/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * A simply utility receiver used to ensure the device stays awake for the
 * duration of the work being done by
 */
public class UtilityReceiver extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        intent.setClass(context, UtilityService.class);
        intent.setAction(UtilityService.ACTION_GEOFENCE_TRIGGERED);
        startWakefulService(context, intent);
    }

}
