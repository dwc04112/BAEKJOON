package com.exam.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 랜선자르기
// https://www.acmicpc.net/problem/1654
public class B1654 {
    static int N,M;
    static int[] intArr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        intArr = new int[N];
        for (int i = 0; i < N; i++) {
            intArr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(intArr);
        binarySearch();
    }

    private static void binarySearch() {
        long max = intArr[N-1];
        max++;
        long min = 0;
        while(max > min){
            long sum = 0;
            long mid = (min+max)/2;

            for(int i : intArr){
                sum += (i/mid);
            }
            if(sum < M){
                max = mid;
            }else{
                //sum == M 일때 min을 옮겨준다
                min = mid+1;
            }
        }
        System.out.println(min-1);
    }
}
