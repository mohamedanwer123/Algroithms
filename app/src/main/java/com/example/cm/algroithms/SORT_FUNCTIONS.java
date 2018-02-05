package com.example.cm.algroithms;

/**
 * Created by cm on 01/12/2017.
 */

public class SORT_FUNCTIONS {

    public int[] insertion_sort(int arr[])
    {
        int i, key, j;
        for (i = 1; i < arr.length; i++)
        {
            key = arr[i];
            j = i-1;
            while (j >= 0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
        return arr;
    }

/**************************************************************/

   public int[] selection_sort(int arr[])
    {
        int n = arr.length;

        for (int i = 0; i < n-1; i++)
        {

            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }
 /*******************************************************************/

 public  void merge(int arr[], int l, int m, int r)
 {

     int n1 = m - l + 1;
     int n2 = r - m;

     int L[] = new int [n1];
     int R[] = new int [n2];

     for (int i=0; i<n1; ++i)
         L[i] = arr[l + i];
     for (int j=0; j<n2; ++j)
         R[j] = arr[m + 1+ j];

     int i = 0, j = 0;

     int k = l;
     while (i < n1 && j < n2)
     {
         if (L[i] <= R[j])
         {
             arr[k] = L[i];
             i++;
         }
         else
         {
             arr[k] = R[j];
             j++;
         }
         k++;
     }

     while (i < n1)
     {
         arr[k] = L[i];
         i++;
         k++;
     }

     while (j < n2)
     {
         arr[k] = R[j];
         j++;
         k++;
     }
 }


   public int[] sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;

            sort(arr, l, m);
            sort(arr , m+1, r);
            merge(arr, l, m, r);
        }
        return arr;
    }

 /*******************************************************************/

 public int[] heap_sort(int arr[]) {
     int n = arr.length;

     // Build heap (rearrange array)
     for (int i = n / 2 - 1; i >= 0; i--)
         heapify(arr, n, i);

     // One by one extract an element from heap
     for (int i = n - 1; i >= 0; i--) {
         // Move current root to end
         int temp = arr[0];
         arr[0] = arr[i];
         arr[i] = temp;

         // call max heapify on the reduced heap
         heapify(arr, i, 0);
     }

     return arr;
 }

    void heapify(int arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    /**********************************************************************/

  public   int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


 public  int[] quick_sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);


            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
        return arr;
    }
/*************************************************************/
    public int[] bubbleSort(int arr[])
    {
    int n = arr.length;
    for (int i = 0; i < n-1; i++)
        for (int j = 0; j < n-i-1; j++)
            if (arr[j] > arr[j+1])
            {
                // swap temp and arr[i]
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
            return arr;
    }
}

