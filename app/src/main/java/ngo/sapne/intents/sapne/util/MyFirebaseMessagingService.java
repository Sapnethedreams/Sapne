package ngo.sapne.intents.sapne.util;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import ngo.sapne.intents.sapne.NotificationList;
import ngo.sapne.intents.sapne.R;

/**
 * Created by Naruto on 2/5/2018.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
      String x,y;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        x = remoteMessage.getNotification().getBody();
        y= remoteMessage.getNotification().getTitle();
        Intent intent = new Intent(this, NotificationList.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pi =  PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notif = new NotificationCompat.Builder(this);
        notif.setContentText("FCM Notification");
        notif.setContentText(x);
        notif.setAutoCancel(true);
        notif.setSmallIcon(R.mipmap.ic_launcher);
        notif.setContentIntent(pi);
        NotificationManager notificationManager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notif.build());



        saveNotification();
    }

    private void saveNotification() {
        SharedPreferences sharedPref = getSharedPreferences("notification1",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        int count = sharedPref.getInt("key" , 0);
        count++;
        editor.putString("notify"+count,x);
        editor.putString("notify3"+count,y);
        editor.putInt("key",count);
        editor.apply();


    }
}
