package sorting;

/**  A class that implements SortingInterface. Has various methods
 *   to sort a list of elements. */
public class SortingImplementation  implements SortingInterface {

    /**
     * Sorts the sublist of the given list (from lowindex to highindex)
     * using insertion sort
     * @param array array of Comparable-s
     * @param lowindex the beginning index of a sublist
     * @param highindex the end index of a sublist
     * @param reversed if true, the list should be sorted in descending order
     */
    @Override
    public void insertionSort(Comparable[] array, int lowindex, int highindex, boolean reversed) {
        // FILL ON CODE

        for (int i = lowIndex+1; i < highIndex; i++) {
            int key = arr[i];
            int j = i-1;

            while (j >= lowIndex && arr[j].compareTo(key) < 0) { 
                arr[j+1] = arr[j];


            arr[j+1] = key;
        }
    }
}

    /**
     * Sorts the sublist of the given list (from lowindex to highindex)
     *  using the shaker sort (see pdf for description)
     * @param array array of Comparable-s
     * @param lowindex the beginning index of a sublist
     * @param highindex the end index of a sublist
     * @param reversed if true, the list should be sorted in descending order
     */
    public void shakerSort(Comparable[] array, int lowindex, int highindex, boolean reversed) {

        while (reversed) {
            reversed = !reversed;

            for (int i = lowindex; i < highindex -1; i++) {
                if (arr[i] > arr[i+1]) {
                    Comparable temp = arr[i+1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    reversed = !reversed;
                }
            }
            if (!reversed) 
                return;

            reversed = !reversed;

            highindex--;

            for (int i = highindex - 1; i >= lowindex; i-- ) {
                if (arr[i] > arr[i + 1]) {
                    Comparable temp = arr[i + 1];
                    arr[i + 1] = arr[i];

                    arr[i] = temp;

                    reversed = !reversed;
                }
            }

            lowindex++;
        }




    }


    /**
     * Sorts the sublist of the given list (from lowindex to highindex)
     * using the following modification of quick sort:
     * At each pass, it picks three elements of the sub-list:
     *  - the first element in the sublist (at index lowindex),
     *  - the middle element of the sublist (in the middle between lowindex and highindex)
     *  - the last element of the sublist (at index highindex)
     * and chooses the median of these three elements as the pivot.
     * How do you compute a median of three values?
     * If we "sort" three elements, the median is the element in the middle
     * (for instance, if the three elements are 5, 2, 19, the median is 5);
     * note that it is different from mean! Do NOT take the average of the 3 numbers, pick the median instead.
     *
     * @param array array to sort
     * @param lowindex the beginning index of a sublist
     * @param highindex the end index of a sublist
     */
    @Override
    public void modifiedQuickSort(Comparable[] array, int lowindex, int highindex) {
        // FILL ON CODE
    }


    /**
     * Implements external sort method
     * @param inputFile The file that contains the input list
     * @param outputFile The file where to output the sorted list
     * @param k number of elements that fit into memory at once
     * @param m number of chunks
     */
    public void externalSort(String inputFile, String outputFile, int k, int m) {
        // FILL IN CODE

    }


    /**
     * Takes two sorted arrays and returns an array of all the elements that occur in both arrays.
     * For instance, if we pass the following two sorted arrays to the method:
     * int[] arr1= {2, 10, 12, 34, 90};
     * int[] arr2 = {4, 6, 8, 10, 11, 12, 14, 20, 26, 30, 34, 48, 50};
     * then the method should return: {10, 12, 34}
     * Note: your method should be general and work for any two sorted arrays of integers.
     * It is required that it runs in linear time: Theta(n1+n2),
     * where n1 and n2 are the sizes of the two lists and takes advantages of the fact that the input lists are sorted.
     * Hint: you can modify the merge helper method we wrote in class to solve this problem.
     * @param arr1 sorted array 1
     * @param arr2 sorted array 2
     * @return array of common elements in arr1 and arr2
     */
    public int[] intersectionOfSortedArrays(int[] arr1, int[] arr2) {
        // FILL IN CODE
        int[] res = new int[arr1.length]; // you can computer the actual number of common elements as you go,
        // and later return the array of the correct length using copyOf method in class Arrays

        int a = 0;
        int b = 0;
        int i = 0;

        while (a < arr1.length && b < arr2.length) {
            if (arr1[a] < arr2[b]) {
                res[i++] = arr1[a++];
            }
            else if (arr2[b] < arr1[a]) {
                res[i++] = arr2[b++];
            }
            else {
                res[i++] = arr2[b++];
                a++;
            }
        }

        while (a < arr1.length) {
            res[i++] = arr1[a++];
        }

        while (b < arr2.length) {
            res[i++] = arr2[b++]
        }

        return res;
    }

}
