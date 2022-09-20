package com.exam.DP문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/9095
// 1, 2, 3 더하기
public class B9095 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[16];
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            System.out.println(calc(a));
        }
    }

    private static int calc(int a) {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= a; i++) {
            dp[i] = dp[i-1] + dp[i-2]+ dp[i-3];
        }
        return dp[a];
    }
}
