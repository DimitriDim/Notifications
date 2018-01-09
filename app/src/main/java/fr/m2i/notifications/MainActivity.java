package fr.m2i.notifications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static fr.m2i.notifications.Tools.showNotificationV_26;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<5;i++){
            showNotificationV_26(this,"coucou");}
    }
}
