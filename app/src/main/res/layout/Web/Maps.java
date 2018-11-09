package com.example.windows.reyogsememi.Web;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.windows.reyogsememi.R;


public class Maps extends AppCompatActivity {


    /*Deklarasi variable*/
    Button navigation_home;
    String goolgeMap = "com.google.android.apps.maps"; // identitas package aplikasi google masps android
    Uri gmmIntentUri;
    Intent mapIntent;
    String ReogSjR = "-7.249197, 112.644314"; // koordinat Masjid Agung Demak
    /*Deklarasi variable*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

// menyamakan variable pada layout activity_main.xml
        navigation_home    = (Button) findViewById(R.id.navigation_home);

        // tombol untuk menjalankan navigasi goolge maps intents
        navigation_home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Buat Uri dari intent string. Gunakan hasilnya untuk membuat Intent.
                gmmIntentUri = Uri.parse("google.navigation:q=" + ReogSjR);

                // Buat Uri dari intent gmmIntentUri. Set action => ACTION_VIEW
                mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                // Set package Google Maps untuk tujuan aplikasi yang di Intent yaitu google maps
                mapIntent.setPackage(goolgeMap);

                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(com.example.windows.reyogsememi.Web.Maps.this, "Google Maps Belum Terinstal. Install Terlebih dahulu.",
                          Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}
