package com.exam.기타등등;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B8979 {

    static int N;
    static int P;
    static long[] score;
    static long[] point = {1000001000001L, 1000001L, 1L};

    // 전체 메달 수 : 1,000,000
    // 동메달 점수 : 1
    // 은메달 점수 : 1,000,001
    // 금메달 점수 : 1,000,001,000,001

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        score = new long[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            score[a] += Integer.parseInt(st.nextToken()) * point[0];
            score[a] += Integer.parseInt(st.nextToken()) * point[1];
            score[a] += Integer.parseInt(st.nextToken()) * point[2];
        }

        int cnt = 1;
        for (int i = 1; i <= N; i++) {
            if(score[P] < score[i]) cnt++;
        }
        System.out.println(cnt);
    }
}
