package com.example.badrus.percobaanproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.example.badrus.percobaanproject.DataComponents.GridViewAdapter;
import com.example.badrus.percobaanproject.DataComponents.JSONDownloader;
import com.example.badrus.percobaanproject.DataComponents.PDFDoc;


import java.util.ArrayList;

public class ushuludin extends AppCompatActivity {

    ArrayList<PDFDoc> pdfDocuments = new ArrayList<>();
    GridViewAdapter adapter;
    GridView myGridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fem);

        final GridView myGridView = findViewById(R.id.myGridView);
        final ProgressBar myProgressBar = findViewById(R.id.myProgressBar);


        SearchView mySearchView = findViewById(R.id.mySearchView);

        mySearchView.setIconified(true);
        mySearchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                adapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });
        String fakultas = "ushuludin";
        pdfDocuments = new JSONDownloader(ushuludin.this,fakultas).retrieve(myGridView, myProgressBar);
        adapter = new GridViewAdapter(this, pdfDocuments);
        myGridView.setAdapter(adapter);


        //(tanpa search)
        //new JSONDownloader(tarbiyah.this).retrieve(myGridView, myProgressBar);
    }

}
