package com.exam.알고리즘.플로이드워셜;

import java.util.Scanner;


public class B11404 {
    static int N;
    static int C;
    static int IFN = 999999;
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextInt();

        int[][] nd = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i==j) {
                    nd[i][j] = 0;
                    continue;
                }
                nd[i][j] = IFN;
            }
        }

        for (int i = 1; i <= C; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int cost = sc.nextInt();

            nd[x][y] = Math.min(nd[x][y], cost);
        }

        // 중간에 방문하는 노드 n
        for (int n = 1; n <= N; n++) {
            // 시작노드
            for (int i = 1; i <= N; i++) {
                // 도착노드
                for (int j = 1; j <= N; j++) {
                    // 현재 노드 > 시작노드->중간노드 중간노드->도착노드
                    if(nd[i][j] > nd[i][n] + nd[n][j]) {
                        nd[i][j] = nd[i][n] + nd[n][j];
                    }
                }
            }
        }
        print(nd);
    }

    public static void print(int[][] board) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i==N && j==N) {
                    System.out.print(board[i][j] == IFN ? 0 : board[i][j]);
                    continue;
                }
                System.out.print(board[i][j] == IFN ? 0 + " " : board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
