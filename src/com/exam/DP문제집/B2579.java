package com.exam.DP문제집;

import java.util.Scanner;

public class B2579{
    static int N;
    static int[] board;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        board = new int[N+2];
        dp = new int[N+2];
        for (int i = 1; i <= N; i++) {
            board[i] = sc.nextInt();
        }
        dp[1] = board[1];
        dp[2] = board[1] + board[2];
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max( dp[i-3]+board[i-1]+board[i], dp[i-2]+board[i] );
        }
        System.out.println(dp[N]);
        sc.close();
    }
}