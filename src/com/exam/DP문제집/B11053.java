package com.exam.DP문제집;

// https://www.acmicpc.net/problem/11053
// 가장 긴 증가하는 부분 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] board  = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = 1;
        int res = 1;
        // i = 현재값 j = 비교값
        for (int i = 2; i <= N; i++) {
            // 무조건 경로 수는 1이상이니 (본인 길이 1) 로 초기화
            dp[i] = 1;

            //현재 값과 이전의 값들을 비교하며 현재값의 경로 수를 구한다.
            for (int j = 1; j < i; j++) {

                // dp[i] <= dp[j] 는 중복되는 수를 더하지 않게하기위해 사용한다.
                // 만약 dp[4] 를 계산할때 10 20 10을 차례대로 다 더하게되면
                // dp[4] 는 4가되게 된다.
                if(board[i]>board[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1;
                }
            }
            res = Math.max(res , dp[i]);
        }

        //System.out.println(Arrays.toString(dp));
        System.out.println(res);
        br.close();
    }
}
