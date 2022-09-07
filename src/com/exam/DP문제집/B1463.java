package com.exam.DP문제집;

// 1로 만들기
// https://www.acmicpc.net/problem/1463
import java.util.Scanner;

public class B1463 {
    static int[] d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n+1];
        System.out.println(calc(n));
    }

    public static int calc(int n){
        d[0] = 0;
        d[1] = 0;
        // dp[n]에 연산횟수 i를 저장
        for (int i = 2; i <= n; i++) {
            // 1을 빼는 연산을 먼저한다 연산을 수행했으니 +1
            d[i] = d[i-1]+1;
            // 만약 2로 나눠지면 위에서 구한 d[i] 와 2로나눈 d[n/2]+1 비교
            // (나누기를 수행하면 횟수를 올려줘야해서 나누고 +1)
            // 비교 후 최소 값을 저장한다. 동일하면 동일값 저장
            if(i%2 == 0) d[i] = Math.min(d[i], d[i/2]+1);
            // 위에서 구한 최소값과 3으로 나눈 값을 비교
            if(i%3 == 0) d[i] = Math.min(d[i], d[i/3]+1);
        }
        return d[n];
    }
}
