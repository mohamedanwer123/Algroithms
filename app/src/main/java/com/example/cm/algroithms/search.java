package com.example.cm.algroithms;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class search extends Fragment {


    public search() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ListView listView = view.findViewById(R.id.lv_search);
        ArrayList<data> arrayList = new ArrayList<>();
        arrayList.add(new data("Linear Search"));
        arrayList.add(new data("Binary Search"));
        arrayList.add(new data("Jump Search"));
        arrayList.add(new data("Interpolation Search"));
        arrayList.add(new data("Fibonacci Search"));
        Adapter adapter = new Adapter(getActivity(),R.layout.items,arrayList);
        listView.setAdapter(adapter);
        return view;
    }

}
