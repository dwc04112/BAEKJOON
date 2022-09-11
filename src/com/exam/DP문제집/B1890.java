package com.exam.DP문제집;

// https://www.acmicpc.net/problem/1890
// 점프

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1890 {
    static int N;
    static int[][] board;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        board = new int[N][N];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        jump();
    }

    private static void jump() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(dp[i][j] == 0) continue;
                if(i == N-1 && j == N-1) {
                    break;
                }
                if(board[i][j]+i < N){
                    dp[board[i][j]+i][j] += dp[i][j];
                }
                if(board[i][j]+j < N){
                    dp[i][board[i][j]+j] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}
