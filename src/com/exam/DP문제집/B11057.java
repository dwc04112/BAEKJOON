package com.exam.DP문제집;


// 오르막 수
// https://www.acmicpc.net/problem/11057

import java.util.Scanner;

public class B11057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] dp = new long[1001][10];
        long[] sum = new long[1001];
        sum[1] = 10;
        for(int i =0; i<10; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=N; i++){
            dp[i][0] = 1;
            sum[i] = dp[i][0];
            for(int j=1; j<10; j++){
                dp[i][j] =  (dp[i][j-1] + dp[i-1][j])%10007;
                sum[i] += dp[i][j];
            }
        }
        System.out.println(sum[N]%10007);
    }
}
