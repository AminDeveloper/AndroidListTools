package com.paraxco.listtools.helper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.paraxco.listtools.R;

import java.util.ArrayList;
import java.util.List;


/**
 *
 */

public class SpinerAdapterHelper {

    public static void initSpinner(Context context, Spinner spinner, String firstItem) {
        List<String> list = new ArrayList<>();
        list.add(firstItem);
        initStringSpinner(context, spinner, list,false);
    }

    public static void initSpinner(Context context, Spinner spinner, List<?> list) {
        List<String> stringsList = new ArrayList<String>(list.size());
        for (Object car : list) {
            stringsList.add(car.toString());
        }
        initStringSpinner(context, spinner, stringsList,true);

    }
    public static void initSpinner(Context context, Spinner spinner, List<?> list,boolean whiteTextColor) {
        List<String> stringsList = new ArrayList<String>(list.size());
        for (Object car : list) {
            stringsList.add(car.toString());
        }
        initStringSpinner(context, spinner, stringsList,whiteTextColor);

    }
    public static void initStringSpinner(Context context, Spinner spinner, List<String> list,boolean whiteTextColor) {
        int layoutRes;
        if(whiteTextColor)
            layoutRes= R.layout.spinner_white;
        else
            layoutRes= R.layout.spinner;

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,layoutRes, list) {

            @Override
            public View getView(int position,  View convertView,  ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                return v;
            }

            @Override
            public View getDropDownView(int position,  View convertView,  ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);


                return v;
            }
        };
        adapter.setDropDownViewResource(R.layout.spinner);
        spinner.setAdapter(adapter);

    }


}
