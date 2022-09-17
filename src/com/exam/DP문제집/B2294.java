package com.exam.DP문제집;

// https://www.acmicpc.net/problem/2294
// 동전 2

import java.util.Arrays;
import java.util.Scanner;

public class B2294 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] dp = new int[k+1];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            dp[a] = 1;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j < i; j++) {
                if(dp[j]==0 || dp[i-j]==0) continue;
                if(dp[i]==0){
                    dp[i] = dp[i-j] + dp[j];
                }else{
                    dp[i] = Math.min(dp[i-j] + dp[j], dp[i]);
                }
            }
        }
        if(dp[k]==0) System.out.println(-1);
        else System.out.println(dp[k]);
    }
}
