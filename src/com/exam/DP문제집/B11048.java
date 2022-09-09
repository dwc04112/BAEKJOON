package com.exam.DP문제집;

// https://www.acmicpc.net/problem/11048
// 이동하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11048 {
    static int N,M;
    static int[][] board;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N+1][M+1];
        dp =  new int[N+1][M+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 1; j < M+1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        calc();
    }

    private static void calc() {

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < M+1; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + board[i][j];
            }
        }
        System.out.println(dp[N][M]);
    }
}
