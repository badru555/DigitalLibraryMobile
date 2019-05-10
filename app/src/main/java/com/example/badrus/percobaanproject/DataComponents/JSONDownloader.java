package com.example.badrus.percobaanproject.DataComponents;

import android.content.Context;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/*
   Our HTTP Client
    */
public class JSONDownloader {

    public String FAKULTAS;
    private String PDF_SITE_URL = "http://diglib.badrus.web.id";
    private final Context c;

    public JSONDownloader(Context c, String filterFakultas){
        this.c = c;
        this.FAKULTAS = filterFakultas;

    }


    /*
    DOWNLOAD PDFS FROM MYSQL
     */
    public ArrayList<PDFDoc> retrieve(final GridView gv, final ProgressBar myProgressBar) {
        final ArrayList<PDFDoc> downloadedData = new ArrayList<>();

        myProgressBar.setIndeterminate(true);
        myProgressBar.setVisibility(View.VISIBLE);

        AndroidNetworking.get(PDF_SITE_URL)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSONObject jo;
                        PDFDoc p;
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                jo = response.getJSONObject(i);
                                p = new PDFDoc();

                                if((jo.getString("fakultas")).equals(FAKULTAS)){
                                    int id = jo.getInt("id");
                                    String title = jo.getString("title");
                                    String fakultas = jo.getString("fakultas");
                                    String prodi = jo.getString("prodi");
                                    String abstrack = jo.getString("abstrack");
                                    String author = jo.getString("author");
                                    String year = jo.getString("year");
                                    String pdfURL = jo.getString("pdf_url");
                                    //String pdfIconURL=jo.getString("pdf_icon_url");

                                    p.setId(id);
                                    p.setTitle(title);
                                    p.setAuthor(author);
                                    p.setFakultas(fakultas);
                                    p.setProdi(prodi);
                                    p.setYear(year);
                                    p.setAbstrack(abstrack);
                                    p.setPdfURL( PDF_SITE_URL+"/pdfs/" + pdfURL);

                                    downloadedData.add(p);
                                };

                                //p.setPdfIconURL(PDF_SITE_URL+pdfIconURL);


                            }
                            //(tanpa search)
                            //adapter = new GridViewAdapter(c, pdfDocuments);
                            //gv.setAdapter(adapter);
                            myProgressBar.setVisibility(View.GONE);

                        } catch (JSONException e) {
                            myProgressBar.setVisibility(View.GONE);
                            Toast.makeText(c, "GOOD RESPONSE BUT JAVA CAN'T PARSE JSON IT RECEIEVED. " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }

                    //ERROR
                    @Override
                    public void onError(ANError error) {
                        error.printStackTrace();
                        myProgressBar.setVisibility(View.GONE);
                        Toast.makeText(c, "UNSUCCESSFUL :  ERROR IS : " + error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        return downloadedData; //-----BARU untuk search
    }
}
