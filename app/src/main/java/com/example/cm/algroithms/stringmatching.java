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
public class stringmatching extends Fragment {


    public stringmatching() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_stringmatching, container, false);
        ListView listView = view.findViewById(R.id.lv_string_matching);
        ArrayList<data> arrayList = new ArrayList<>();
        arrayList.add(new data("String matching"));

        Adapter adapter = new Adapter(getActivity(),R.layout.items,arrayList);
        listView.setAdapter(adapter);
        return view;
    }

}
