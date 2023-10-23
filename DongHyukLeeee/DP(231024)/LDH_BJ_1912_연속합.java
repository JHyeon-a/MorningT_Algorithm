package Study;

import java.util.*;

import java.io.*;

	
public class LDH_BJ_1912_연속합 {
	
	  public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();

	        int[] arr = new int[n];
	        for (int i = 0; i < n; i++) {
	            arr[i] = scanner.nextInt();
	        }

	        // Initialize DP array to store maximum subarray sum ending at each index
	        int[] dp = new int[n];
	        dp[0] = arr[0]; // Initialize the first element

	        for (int i = 1; i < n; i++) {
	            // Calculate the maximum subarray sum ending at the current index
	            // It can be either the current element itself or the sum of the previous subarray sum and the current element
	            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
	        }

	        // Find the maximum subarray sum from the DP array
	        int maxSum = dp[0];
	        for (int i = 1; i < n; i++) {
	            if (dp[i] > maxSum) {
	                maxSum = dp[i];
	            }
	        }

	        System.out.println(maxSum);
	    }
	
	
	static String input1 = "10\r\n"
			+ "10 -4 3 1 5 6 -35 12 21 -1";
	static String input2 = "10\r\n"
			+ "2 1 -4 3 4 -4 6 5 -5 1";
	static String input3 = "5\r\n"
			+ "-1 -2 -3 -4 -5";
}