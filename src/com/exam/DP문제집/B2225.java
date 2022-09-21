package com.exam.DP문제집;

import java.util.Scanner;

public class B2225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        // k = 더하는 수의 갯수, n = 만드려는 목표값
        int[][] dp = new int[k+1][n+1];

        for (int i = 0; i <= n; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= k; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][j] %= 1000000000;
            }
        }
        System.out.println(dp[k][n]);
    }
}
