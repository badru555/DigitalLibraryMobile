package com.example.badrus.percobaanproject.DataComponents;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.badrus.percobaanproject.R;
import com.example.badrus.percobaanproject.Pendukung.viewdetail;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/*
   Our custom adapter class
    */
public class GridViewAdapter extends BaseAdapter implements Filterable {


    Context c;
    ArrayList<PDFDoc> pdfDocuments;
    //batu berserta implement
    public ArrayList<PDFDoc> currentList;
    FilterHelper filterHelper;

    public GridViewAdapter(Context c, ArrayList<PDFDoc> pdfDocuments) {
        this.c = c;
        this.pdfDocuments = pdfDocuments;
        this.currentList = pdfDocuments;
    }

    @Override
    public int getCount() {
        return pdfDocuments.size();
    }

    @Override
    public Object getItem(int pos) {
        return pdfDocuments.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(c).inflate(R.layout.row_model, viewGroup, false);
        }

        final TextView txtName = view.findViewById(R.id.pdfNameTxt);
        //TextView txtFak = view.findViewById(R.id.prodiheading);
        TextView txtAuthor = view.findViewById(R.id.authorTxt);
        TextView txtProdi = view.findViewById(R.id.prodiTxt);
        ImageView pdfIcon = view.findViewById(R.id.imageView);

        final PDFDoc pdf = (PDFDoc) this.getItem(pos);

        //txtFak.setText(fakultas);
        txtName.setText(pdf.getTitle());
        txtAuthor.setText(pdf.getAuthor());
        txtProdi.setText(pdf.getProdi());


//        if (pdf.getPdfURL() != null && pdf.getPdfURL().length() > 0) {
//            //Picasso.get().load(pdf.getPdfIconURL()).placeholder(R.drawable.placeholder).into(pdfIcon);
//        } else {
//            Toast.makeText(c, "Empty Image URL", Toast.LENGTH_LONG).show();
//            Picasso.get().load(R.drawable.pdf_icon).into(pdfIcon);
//        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(c, pdf.getName(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(c, viewdetail.class);
                i.putExtra("PATH", pdf.getPdfURL());
                //baru
                i.putExtra("title", pdf.getTitle());
                i.putExtra("abstrack", pdf.getAbstrack());
                i.putExtra("author", pdf.getAuthor());
                i.putExtra("prodi", pdf.getProdi());
                i.putExtra("year", pdf.getYear());
                c.startActivity(i);


            }
        });

        return view;
    }

    //baru
    public void setPDFDoc(ArrayList<PDFDoc> filteredpdfDocuments) {
        this.pdfDocuments = filteredpdfDocuments;
    }

    @Override
    public Filter getFilter() {
        if (filterHelper == null) {
            filterHelper = new FilterHelper(currentList, this, c);
        }

        return filterHelper;
    }

    public void refresh() {
        notifyDataSetChanged();
    }
}
