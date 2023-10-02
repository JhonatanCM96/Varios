package com.jhonatan.appvarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.provider.Settings;

public class MainActivity extends AppCompatActivity {

    Button Mapas, Google, Alarma, Llamar, Wifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapas = findViewById(R.id.btnMapas);
        Google = findViewById(R.id.btnGoogle);
        Alarma = findViewById(R.id.btnAlarma);
        Llamar = findViewById(R.id.btnLlamar);
        Wifi = findViewById(R.id.btnWifi);

        Mapas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:6.271650, -75.552648"));
                startActivity(intent);
            }
        });

        Google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent GoToGoogle = new Intent(Intent.ACTION_VIEW);
                GoToGoogle.setData(Uri.parse("https://www.google.com/"));
                startActivity(GoToGoogle);
            }
        });

        Alarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent Alarmy = new Intent(AlarmClock.ACTION_SET_ALARM);
                Alarmy.putExtra(AlarmClock.EXTRA_MESSAGE,"Wake Up");
                Alarmy.putExtra(AlarmClock.EXTRA_HOUR,05);
                Alarmy.putExtra(AlarmClock.EXTRA_MINUTES,00);
                if(Alarmy.resolveActivity(getPackageManager()) != null)
                {
                    startActivity(Alarmy);
                }

                Intent Alarmy2 = new Intent(AlarmClock.ACTION_SET_ALARM);
                Alarmy2.putExtra(AlarmClock.EXTRA_MESSAGE,"Wake Up !!!!");
                Alarmy2.putExtra(AlarmClock.EXTRA_HOUR,05);
                Alarmy2.putExtra(AlarmClock.EXTRA_MINUTES,05);
                if(Alarmy2.resolveActivity(getPackageManager()) != null)
                {
                    startActivity(Alarmy2);
                }
            }
        });

        Llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Llamar = new Intent(Intent.ACTION_DIAL);
                Llamar.setData(Uri.parse("tel:" + "3172528893"));
                if (Llamar.resolveActivity(getPackageManager()) != null) {
                    startActivity(Llamar);
                }

            }
        });

        Wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wifi = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(wifi);

            }
        });
    }

}