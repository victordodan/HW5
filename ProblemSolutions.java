/******************************************************************
 *
 *   Victor Dodan / 002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     * <p>
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     * Input: [1,50,55,80,90], [55,90]
     * Output: true
     * Input: [1,50,55,80,90], [55,90, 99]
     * Output: false
     * <p>
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        HashSet<Integer> set = new HashSet<>();
        for (int x : list1) {
            set.add(x);
        }
        for (int x : list2) {
            if (!set.contains(x)) return false;
        }

        return true;
    }


    /**
     * Method: findKthLargest
     * <p>
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     * Input: [1,7,3,10,34,5,8], 4
     * Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : array) {
            queue.add(x);
        }
        while (k > 1 && queue.peek() != null) {
            queue.poll();
            k--;
        }
        if (queue.peek() == null) return -1;
        return queue.poll();
    }


    /**
     * Method: sort2Arrays
     * <p>
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     * Input: [4,1,5], [3,2]
     * Output: 1 2 3 4 5
     *
     * @param array1 - Input array 1
     * @param array2 - Input array 2
     * @return - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int x : array1) {
            queue.add(x);
        }
        for (int x : array2) {
            queue.add(x);
        }
        int[] ret = new int[array1.length + array2.length];
        for (int k = 0; k < ret.length && queue.peek() != null; k++) {
            ret[k] = queue.poll();
        }
        return ret;

    }
}
