package com.exam.DP문제집;

// https://www.acmicpc.net/problem/11052
// 카드 구매하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] board = new int[N+1];
        int[] dp = new int[N+1];
        // dp 에는 i개 에 쓰는 카드 값의 최대값을 저장

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = board[1];
        for (int i = 2; i < N+1; i++) {
            dp[i] = board[i];
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i-j]+dp[j] , dp[i]);
            }
            System.out.println(Arrays.toString(dp));
        }
        System.out.println(dp[N]);
        br.close();
    }
}
