package com.exam.DP문제집;

// 쉬운 계단 수
// https://www.acmicpc.net/problem/10844
import java.util.Scanner;

public class B10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // dp[자릿수][두번째 숫자]
        long[][] dp = new long[101][10];
        for (int i = 1; i <10; i++) {
            dp[0][i] = 1;
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < 10; j++) {
                if((j-1)==0) dp[i][j] += (dp[i-2][j] % 1000000000);
                else dp[i][j] += (dp[i-1][j-1] % 1000000000);

                if( (j+1) !=10) dp[i][j] += (dp[i-1][j+1] % 1000000000);
            }
        }
        long sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += dp[n][i];
        }
        System.out.println(sum%1000000000);
    }
}
