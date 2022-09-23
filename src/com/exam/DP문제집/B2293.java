package com.exam.DP문제집;

// https://www.acmicpc.net/problem/2293
// 동전 1

import java.util.Scanner;

public class B2293 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] dp = new int[k+1];
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if(j>=coin[i]) dp[j] += dp[j-coin[i]];
            }
        }
        System.out.println(dp[k]);
    }
}
