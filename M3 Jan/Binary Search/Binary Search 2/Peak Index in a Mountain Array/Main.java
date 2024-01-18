import java.io.*;
import java.util.*;

class Solution {
    // TC: O(log N), SC: O(1)
    public int peakIndexInMountainArray(int[] arr) {
        // Your code here.
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (mid + 1 == arr.length) {
                if (arr[mid - 1] < arr[mid]) {
                    return mid;
                }
            } else if (mid - 1 < 0) {
                if (arr[mid + 1] < arr[mid]) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                    // mid is peak
                    return mid;
                } else if (arr[mid - 1] < arr[mid]) {
                    // left side is increasing
                    lo = mid + 1;
                } else {
                    // left is not increasing
                    hi = mid - 1;
                }   
            }
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.peakIndexInMountainArray(arr1);
        System.out.print(result + " ");
        System.out.println('\n');
    }
}