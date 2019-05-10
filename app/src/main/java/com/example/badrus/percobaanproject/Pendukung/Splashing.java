package com.example.badrus.percobaanproject.Pendukung;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.badrus.percobaanproject.MainActivity;
import com.example.badrus.percobaanproject.R;

public class Splashing extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2500;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //satu baris dibawah ini untuk membuat aktifiti fullscreen, tapi karena hp saya norcth maka saya tidak gunakan
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Window window = this.getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.statusBARsplash));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent z = new Intent(Splashing.this,MainActivity.class);
                startActivity(z);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
