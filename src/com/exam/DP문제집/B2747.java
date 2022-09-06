package com.exam.DP문제집;

// https://www.acmicpc.net/problem/2747
// 피보나치의 수

import java.util.Scanner;

public class B2747 {
    static int[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        memo = new int[N+1];
        System.out.println(fibonacci(N));
    }
    static public int fibonacci(int n) {
        if(n<=1) return n;
        memo[1] = 1;
        memo[2] = 1;
        for (int i = 3; i < n+1; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }

    /*

    static public int fibonacci(int n) {
        if (n <= 1)
            return n;
        else if (n == 2)
            return 1;
        else {
            if (memo[n] > 0)
                return memo[n];
            memo[n] = fibonacci(n-1) + fibonacci(n-2);
            return memo[n];
        }
    }
     */
}
