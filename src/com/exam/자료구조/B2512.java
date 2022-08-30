package com.exam.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2512 {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
        }
        Arrays.sort(arr);
        M = Integer.parseInt(br.readLine());
        long max = arr[N-1];
        long min = 0;
        long res = 0;

        while(min <= max){
            long mid = (max+min)/2;
            long sum = 0;
            for(int m : arr){
                if(m>=mid) {
                    sum += mid;
                }else{
                    sum += m;
                }
            }
            if(sum > M){
                // 만약 예산을 초과할 경우
                // 최대값을 절반으로 줄여서
                max = mid -1;
            }else{
                // 예산이 남으면 최소값을 min으로 두고 계산
                min = mid +1;
                res = mid;
            }
        }
        System.out.println(res);
    }
}
