package com.exam.알고리즘.플로이드워셜;

import java.util.Scanner;

public class B11403 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] nd = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                nd[i][j] = sc.nextInt();
            }
        }

        for (int n = 1; n <= N; n++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(nd[i][j]==1) continue;
                    if(nd[i][n] != 0 && nd[n][j] !=0) nd[i][j] = 1;
                }
            }
        }

        print(nd);
    }

    public static void print(int[][] board) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i==N && j==N) {
                    System.out.print(board[i][j]);
                    continue;
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
