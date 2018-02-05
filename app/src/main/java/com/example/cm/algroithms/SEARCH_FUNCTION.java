package com.example.cm.algroithms;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by cm on 01/12/2017.
 */

public class SEARCH_FUNCTION {

  public String linear_search(ArrayList<Integer> arr, int x)
    {
        for (int i = 0; i < arr.size()-1; i++)
        {
            if (arr.get(i) == x)
                return "exist";
        }


        return "not exist";
    }

    public int binarySearch(ArrayList<Integer> arr, int l, int r, int x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;

            if (arr.get(mid) == x)
                return mid;

            if (arr.get(mid) > x)
                return binarySearch(arr, l, mid-1, x);


            return binarySearch(arr, mid+1, r, x);
        }

        return -1;
    }

    public int jumpSearch(ArrayList<Integer> arr, int x)
    {
        int n = arr.size();


        int step = (int)Math.floor(Math.sqrt(n));

        int prev = 0;
        while (arr.get(Math.min(step, n)-1) < x)
        {
            prev = step;
            step += (int)Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }


        while (arr.get(prev) < x)
        {
            prev++;


            if (prev == Math.min(step, n))
                return -1;
        }


        if (arr.get(prev) == x)
            return prev;

        return -1;
    }


  public   int interpolationSearch(ArrayList<Integer> arr, int n, int x)
    {

        int lo = 0, hi = (n - 1);


        while (lo <= hi && x >= arr.get(lo) && x <= arr.get(hi))
        {

            int pos = lo + (((int) (hi-lo) / (arr.get(hi)-arr.get(lo)))*(x - arr.get(lo)));

            if (arr.get(pos) == x)
                return pos;

            if (arr.get(pos) < x)
                lo = pos + 1;

            else
                hi = pos - 1;
        }
        return -1;
    }


}
