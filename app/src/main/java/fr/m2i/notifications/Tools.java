package fr.m2i.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import static android.provider.Settings.Global.getString;

/**
 * Created by Administrateur on 09/01/2018.
 */

public class Tools {
    private static int notifID = 0;

    public static int showNotification(Context ctx, String channel) {
        // o = version 26 (Oreo)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return showNotificationV_26(ctx, channel);
        } else {
            return showNotificationV_25(ctx, channel);
        }

    }

    public static int showNotificationV_26(Context ctx, String channel) {

        //création du channel pour la notification

        NotificationManager mNotificationManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        // The id of the channel.
        String id = "my_channel_01";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // The user-visible name of the channel.
            CharSequence name = channel;

            // The user-visible description of the channel.
            String description = channel;

            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(id, name, importance);

            // Configure the notification channel.
            mChannel.setDescription(description);
            mChannel.enableLights(true);

            // Sets the notification light color for notifications posted to this
            // channel, if the device supports this feature.
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]
                    {
                            100, 200, 300, 400, 500, 400, 300, 200, 400
                    });
            mNotificationManager.createNotificationChannel(mChannel);


            // creation de la notification

            notifID++;
            // The id of the channel.
            String CHANNEL_ID = "my_channel_01";
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(ctx, CHANNEL_ID)
                            .setSmallIcon(R.drawable.notification)
                            .setContentTitle("Ma premiere notification n°" + notifID)
                            .setContentText("Youpiiiiii V25");

            //  /!\ peut etre écrit ainsi:
        /*NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(ctx);
        mBuilder.setContentText("Youpiiiiii");
        mBuilder.setContentTitle("Ma premiere notification n°" + notifID);
        mBuilder.setSmallIcon(R.drawable.notification);*/


            mNotificationManager.notify(notifID, mBuilder.build());
        }
        return notifID;
    }

    public static int showNotificationV_25(Context ctx, String channel) {

        NotificationManager mNotificationManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder mBuilder = new Notification.Builder(ctx);
        mBuilder.setContentText("Youpiiiiii");
        mBuilder.setContentTitle("Ma premiere notification n°" + notifID);
        mBuilder.setSmallIcon(R.drawable.notification);

        mNotificationManager.notify(notifID, mBuilder.build());
        return notifID;
    }

}
