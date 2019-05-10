package com.example.badrus.percobaanproject.DataComponents;

import android.content.Context;
import android.widget.Filter;


import java.util.ArrayList;

public class FilterHelper extends Filter { //-----BARU untuk search
    private ArrayList<PDFDoc> currentList;
    private GridViewAdapter adapter;
    Context c;

    public FilterHelper(ArrayList<PDFDoc> currentList, GridViewAdapter adapter, Context c) {
        this.currentList = currentList;
        this.adapter = adapter;
        this.c = c;
    }

    /*
    - Perform actual filtering.
     */
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults filterResults = new FilterResults();

        if (constraint != null && constraint.length() > 0) {
            //CHANGE TO UPPER
            constraint = constraint.toString().toUpperCase();

            //HOLD FILTERS WE FIND
            ArrayList<PDFDoc> foundFilters = new ArrayList<>();

            PDFDoc pdfDocuments = null;

            //ITERATE CURRENT LIST
            for (int i = 0; i < currentList.size(); i++) {
                pdfDocuments = currentList.get(i);

                //SEARCH
                if (pdfDocuments.getTitle().toUpperCase().contains(constraint)) {
                    //ADD IF FOUND
                    foundFilters.add(pdfDocuments);
                }
            }

            //SET RESULTS TO FILTER LIST
            filterResults.count = foundFilters.size();
            filterResults.values = foundFilters;
        } else {
            //NO ITEM FOUND.LIST REMAINS INTACT
            filterResults.count = currentList.size();
            filterResults.values = currentList;
        }

        //RETURN RESULTS
        return filterResults;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        adapter.setPDFDoc((ArrayList<PDFDoc>) filterResults.values);
        adapter.refresh();
    }
}
