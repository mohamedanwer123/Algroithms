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
public class sort extends Fragment {


    public sort() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sort, container, false);
        ListView listView = view.findViewById(R.id.lv_sort);
        ArrayList<data> arrayList = new ArrayList<>();
        arrayList.add(new data("Insertion sort"));
        arrayList.add(new data("Selection sort"));
        arrayList.add(new data("Merge sort"));
        arrayList.add(new data("Heap sort"));
        arrayList.add(new data("Quick sort"));
        arrayList.add(new data("Bubble sort"));
        Adapter adapter = new Adapter(getActivity(),R.layout.items,arrayList);
        listView.setAdapter(adapter);
        return view;
    }

}
