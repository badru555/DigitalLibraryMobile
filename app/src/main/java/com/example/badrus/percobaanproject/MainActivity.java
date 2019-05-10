package com.example.badrus.percobaanproject;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    CardView btnTarbiyah, btnUshuludin, btnSyariah, btnKesehatan, btnHumaniora, btnSaintek, btnFem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnUshuludin = findViewById(R.id.btnUshuludin);
        btnTarbiyah = findViewById(R.id.btnTarbiyah);
        btnSyariah = findViewById(R.id.btnSyariah);
        btnKesehatan = findViewById(R.id.btnKesehatan);
        btnUshuludin.setOnClickListener(this);
        btnTarbiyah.setOnClickListener(this);
        btnSyariah.setOnClickListener(this);
        btnKesehatan.setOnClickListener(this);
        btnHumaniora = findViewById(R.id.btnHumaniora);
        btnHumaniora.setOnClickListener(this);
        btnSaintek = findViewById(R.id.btnSaintek);
        btnSaintek.setOnClickListener(this);
        btnFem = findViewById(R.id.btnFem);
        btnFem.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnUshuludin:
                Intent a = new Intent(MainActivity.this, ushuludin.class);
                startActivity(a);
                break;
            case R.id.btnTarbiyah:
                Intent b = new Intent(MainActivity.this, tarbiyah.class);
                startActivity(b);
                break;
            case R.id.btnSyariah:
                Intent c = new Intent(MainActivity.this, syariah.class);
                startActivity(c);
                break;
            case R.id.btnKesehatan:
                Intent d = new Intent(MainActivity.this, ilmukesehatan.class);
                startActivity(d);
                break;
            case R.id.btnHumaniora:
                Intent e = new Intent(MainActivity.this, humaniora.class);
                startActivity(e);
                break;
            case R.id.btnSaintek:
                Intent f = new Intent(MainActivity.this, saintek.class);
                startActivity(f);
                break;
            case R.id.btnFem:
                Intent g = new Intent(MainActivity.this, fem.class);
                startActivity(g);
                break;
        }
    }
}
