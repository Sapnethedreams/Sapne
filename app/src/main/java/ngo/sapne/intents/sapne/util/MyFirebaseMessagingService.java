package ngo.sapne.intents.sapne.util;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import ngo.sapne.intents.sapne.NotificationList;
import ngo.sapne.intents.sapne.R;

/**
 * Created by Naruto on 2/5/2018.
 * edited by abhinav on 18/5/2020.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String CHANNEL_ID = "firebase_notifications" ;
    String body, title;


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        createNotificationChannel();
        body = remoteMessage.getNotification().getBody();
        title = remoteMessage.getNotification().getTitle();

        Intent intent = new Intent(this, NotificationList.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pi =  PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder notif = new NotificationCompat.Builder(this,CHANNEL_ID);
        notif.setContentText("FCM Notification");
        notif.setContentText(body);
        notif.setAutoCancel(true);
        notif.setSmallIcon(R.mipmap.ic_launcher);
        notif.setContentIntent(pi);
//        NotificationManager notificationManager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.notify(0,notif.build());

        int notificationId = (int) System.currentTimeMillis();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId, notif.build());

        saveNotification();
    }

    private void saveNotification() {
        SharedPreferences sharedPref = getSharedPreferences("notification1",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        int count = sharedPref.getInt("key" , 0);
        count++;
        editor.putString("notify"+count, body);
        editor.putString("notify3"+count, title);
        editor.putInt("key",count);
        editor.apply();


    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.firebase_channel_name);
            String description = getString(R.string.firebase_channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}
