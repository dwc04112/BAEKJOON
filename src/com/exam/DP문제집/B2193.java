package com.exam.DP문제집;

// https://www.acmicpc.net/problem/2193
// 이친수


import java.util.Scanner;

public class B2193 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] dp = new long[N+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[N-1]);
    }
}
