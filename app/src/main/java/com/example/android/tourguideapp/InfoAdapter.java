package com.example.android.tourguideapp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class InfoAdapter extends BaseAdapter {

    public View getView(int position, View convertView, ViewGroup parent){
        View info = null;
        info = info.findViewById(R.id.info);
        return info;
    }
}
