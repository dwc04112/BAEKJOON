package com.exam.DP문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] board  = new int[N+1];
        int[] ascDp = new int[N+1];
        int[] descDp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }
        // 오름차순 결과 구하기
        ascDp[1] = 1;
        for (int i = 2; i <= N; i++) {
            ascDp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (board[i] > board[j] && ascDp[i] <= ascDp[j]) {
                    ascDp[i] +=1;
                }
            }
        }
        // 내림차순 결과 구하기
        descDp[N] = 1;
        for (int i = N-1; i >= 1; --i) {
            descDp[i] = 1;
            for (int j = N; j > i; --j) {
                if (board[i] > board[j] && descDp[i] <= descDp[j]) {
                    descDp[i] += 1;
                }
            }
        }
        // 오름차순 + 내림차순 중 가장 큰값 구하기
        // 결과에 -1
        int res = 1;
        for (int i = 0; i <= N; i++) {
            res = Math.max(res, (ascDp[i]+descDp[i]) );
        }
        System.out.println(res-1);
    }
}
