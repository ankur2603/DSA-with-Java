Link : https://www.hackerrank.com/challenges/ctci-merge-sort/problem

import java.util.*;

class Solution {

    static long count = 0; // global count

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int d = sc.nextInt();   // number of datasets

        for (int t = 0; t < d; t++) {
            int n = sc.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            count = 0;                 // reset for each dataset
            ms(arr, 0, n - 1);
            System.out.println(count);
        }

        sc.close();
    }

    public static void ms(int arr[], int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;

        ms(arr, start, mid);
        ms(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static void merge(int arr[], int start, int mid, int end) {

        int temp[] = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += (mid - i + 1); // inversion count
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= end) temp[k++] = arr[j++];

        for (i = start, k = 0; k < temp.length; i++, k++) {
            arr[i] = temp[k];
        }
    }
}
