package com.example.badrus.percobaanproject.Pendukung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.badrus.percobaanproject.R;

public class viewdetail extends AppCompatActivity {

    TextView title, abstrack, author,prodi,year;
    Button btn_read;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetail);

        title = findViewById(R.id.judul);
        author = findViewById(R.id.penulis);
        prodi = findViewById(R.id.prodi);
        abstrack = findViewById(R.id.abstrak);
        year = findViewById(R.id.tahun);
        btn_read = findViewById(R.id.btn_read);

        Intent intent = getIntent();
        String extraTitle = intent.getStringExtra("title");
        String extraAuthor = intent.getStringExtra("author");
        String extraProdi = intent.getStringExtra("prodi");
        String extraAbstrack = intent.getStringExtra("abstrack");
        String extraYear = intent.getStringExtra("year");
        final String extraPATH = intent.getStringExtra("PATH");

        title.setText(extraTitle);
        author.setText(extraAuthor);
        prodi.setText(extraProdi);
        year.setText(extraYear);
        abstrack.setText(extraAbstrack);

        btn_read.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(viewdetail.this,PDFActivity.class);
                i.putExtra("PATH",extraPATH);
                startActivity(i);
            }
        });

    }
}
