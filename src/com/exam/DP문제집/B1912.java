package com.exam.DP문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] board  = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        int res = board[1];
        dp[1] = board[1];

        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i-1] + board[i], board[i]);
            System.out.println(dp[i]);
            if (dp[i] > res) res = dp[i];
        }
        System.out.println(res);
    }
}
