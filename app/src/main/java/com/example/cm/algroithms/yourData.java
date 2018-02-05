package com.example.cm.algroithms;


import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class yourData extends Fragment {

    EditText editText;
    FloatingActionButton floatingActionButton;
    TextView textView;

    public yourData() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_your_data, container, false);
        editText = view.findViewById(R.id.data_place);
        floatingActionButton = view.findViewById(R.id.check);
        textView = view.findViewById(R.id.show_data);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.length()==0)
                {
                    Toast.makeText(getActivity(), "Please enter data", Toast.LENGTH_SHORT).show();
                }else
                {
                    fun();
                }

            }
        });

        return view;
    }

    public void fun()
    {
        String key_word = getArguments().getString("type");
        if(key_word.toLowerCase().contains("sort")) {
            String data[] = editText.getText().toString().split(" ");
            int convert_data[] = new int[data.length];
            String con = "";
            for (int i = 0; i < data.length; i++) {

                convert_data[i] = Integer.valueOf(data[i]);
            }

            // insertion sort
            /********************************************** search ******************************************/
            if (key_word.equals("Insertion sort")) {

                SORT_FUNCTIONS functions = new SORT_FUNCTIONS();
                int get_data[] = functions.insertion_sort(convert_data);

                for (int i = 0; i < get_data.length; i++) {

                    con += "{" + get_data[i] + "}   ";

                }

                textView.setText(con);

            } else if (key_word.equals("Selection sort")) {
                SORT_FUNCTIONS functions = new SORT_FUNCTIONS();
                int get_data[] = functions.selection_sort(convert_data);

                for (int i = 0; i < get_data.length; i++) {

                    con += "{" + get_data[i] + "}   ";

                }

                textView.setText(con);
            } else if (key_word.equals("Merge sort")) {
                SORT_FUNCTIONS functions = new SORT_FUNCTIONS();
                functions.merge(convert_data, 0, convert_data.length / 2, convert_data.length - 1);
                int get_data[] = functions.sort(convert_data, 0, convert_data.length - 1);

                for (int i = 0; i < get_data.length; i++) {

                    con += "{" + get_data[i] + "}   ";

                }

                textView.setText(con);
            } else if (key_word.equals("Heap sort")) {
                SORT_FUNCTIONS functions = new SORT_FUNCTIONS();
                functions.heapify(convert_data, convert_data.length - 1, 0);
                int get_data[] = functions.heap_sort(convert_data);

                for (int i = 0; i < get_data.length; i++) {

                    con += "{" + get_data[i] + "}   ";

                }

                textView.setText(con);
            } else if (key_word.equals("Quick sort")) {
                SORT_FUNCTIONS functions = new SORT_FUNCTIONS();
                int x = functions.partition(convert_data, 0, convert_data.length - 1);
                int get_data[] = functions.quick_sort(convert_data, 0, convert_data.length - 1);

                for (int i = 0; i < get_data.length; i++) {

                    con += "{" + get_data[i] + "}   ";

                }

                textView.setText(con);
            } else if (key_word.equals("Bubble sort")) {
                SORT_FUNCTIONS functions = new SORT_FUNCTIONS();
                int get_data[] = functions.bubbleSort(convert_data);

                for (int i = 0; i < get_data.length; i++) {

                    con += "{" + get_data[i] + "}   ";

                }

                textView.setText(con);
            }
        }else if(key_word.toLowerCase().contains("search")) {

            ArrayList<Integer> arrayList = new ArrayList<>();
            try {
                InputStream inputStream = getActivity().getAssets().open("search_data.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String s;
                while ((s=bufferedReader.readLine())!=null)
                {
                    arrayList.add(Integer.valueOf(s));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            if (key_word.equals("Linear Search")) {
                SEARCH_FUNCTION search_function = new SEARCH_FUNCTION();
                int key = Integer.valueOf(editText.getText().toString());
                textView.setText(search_function.linear_search(arrayList,key));


            } else if (key_word.equals("Binary Search")) {

                SEARCH_FUNCTION search_function = new SEARCH_FUNCTION();
                int key = Integer.valueOf(editText.getText().toString());
                if(search_function.binarySearch(arrayList,0,arrayList.size()-1,key) == -1)
                {
                    textView.setText("not exist");
                }else
                {
                    textView.setText("exist");
                }



            } else if (key_word.equals("Jump Search")) {
                SEARCH_FUNCTION search_function = new SEARCH_FUNCTION();
                int key = Integer.valueOf(editText.getText().toString());
                if(search_function.jumpSearch(arrayList,key) == -1)
                {
                    textView.setText("not exist");
                }else
                {
                    textView.setText("exist");
                }




            } else if (key_word.equals("Interpolation Search")) {
                SEARCH_FUNCTION search_function = new SEARCH_FUNCTION();
                int key = Integer.valueOf(editText.getText().toString());
                if(search_function.interpolationSearch(arrayList,arrayList.size(),key) == -1)
                {
                    textView.setText("not exist");
                }else
                {
                    textView.setText("exist");
                }


            }
        }else if(key_word.toLowerCase().contains("string"))
        {
            String key = editText.getText().toString();
           String txt="";
            try {
                InputStream inputStream = getActivity().getAssets().open("string_matching.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String s;
                while ((s=bufferedReader.readLine())!=null)
                {
                   txt+=s;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            STRINGMATCHING_FUNCTIONS stringmatching_functions = new STRINGMATCHING_FUNCTIONS();
            boolean b = stringmatching_functions.String_Match(txt,key);
            if(b==true)
            {
                textView.setText("the word {"+key+"} is exist in the data");
            }else
            {
                textView.setText("the word {"+key+"} is not exist in the data");
            }

        }
    }

}
