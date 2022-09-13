package com.exam.DP문제집;

// https://www.acmicpc.net/problem/11054
// 가장 긴 바이토닉 부분 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11054_slow {
    static int N;
    static int[] res;
    static int[] dp;
    static int[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board  = new int[N+1];
        dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 1;
        res = new int[N+1];
        int result = 1;
        while(idx<=N) {
            // 기준점을 오름차순과 내림차순에 넣거 값 구하기
            res[idx] = asc(idx) + desc(idx) -1;
            // 결과 저장
            if(result<res[idx]) result = res[idx];
            // idx 값 증가시키기
            idx++;
        }
        System.out.println(result);
        br.close();
    }

    // LIS
    private static int asc(int idx){
        dp = new int[N+1];
        dp[1] = 1;
        int res = 1;

        for (int i = 2; i <= idx; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (board[i] > board[j] && dp[i] <= dp[j]) {
                    dp[i] +=1;
                }
            }
            res = Math.max(res , dp[idx]);
        }
        return res;
    }

    private static int desc(int idx){
        dp = new int[N+1];
        dp[N] = 1;
        for (int i = N-1; i >= idx; --i) {
            dp[i] = 1;
            for (int j = N; j > idx; --j) {
                if (board[i] > board[j] && dp[i] <= dp[j]) {
                    dp[i] += 1;
                }
            }
        }
        return dp[idx];
    }
}
