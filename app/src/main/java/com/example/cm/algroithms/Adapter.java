package com.example.cm.algroithms;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cm on 01/12/2017.
 */

public class Adapter extends ArrayAdapter {
    ArrayList<data> arrayList;
    Context context;
    int res;
    public Adapter(@NonNull Context context, int resource, @NonNull ArrayList<data> arrayList) {
        super(context, resource, arrayList);
        this.arrayList= arrayList;
        this.context = context;
        this.res = resource;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(res,parent,false);
        TextView textView = convertView.findViewById(R.id.tit);
        textView.setText(arrayList.get(position).getTitle());
        FloatingActionButton floatingActionButton = convertView.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = new yourData();
                Bundle bundle = new Bundle();
                bundle.putString("type",arrayList.get(position).getTitle());
                fragment.setArguments(bundle);
                FragmentManager fragmentManager =((AppCompatActivity)context). getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_content,fragment);
                fragmentTransaction.commit();
            }
        });
        return convertView;
    }
}
