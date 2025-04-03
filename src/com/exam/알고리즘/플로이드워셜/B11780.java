package com.exam.알고리즘.플로이드워셜;


import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;


public class B11780 {
    static int N;
    static int C;
    static int IFN = 1000000001;
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextInt();

        int[][] nd = new int[N+1][N+1];
        int[][][] visited = new int[N+1][N+1][N];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 방문한 노드 초기화
                visited[i][j] = new int[] {};

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
            // 방문한 노드 시작점 기록
            visited[x][y] = new int[] {x};
        }

        for (int n = 1; n <= N; n++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(nd[i][j] > nd[i][n] + nd[n][j]) {
                        nd[i][j] = nd[i][n] + nd[n][j];

                        // 방문한 노드 순차적으로 기록
                        // 더 빠른 노드 찾으면 엎어쓰기
                        int[] merge = IntStream.concat(Arrays.stream(visited[i][n]), Arrays.stream(visited[n][j]))
                            .distinct()
                            .toArray();
                        visited[i][j] = merge;
                    }
                }
            }
        }
        print(nd);
        printNode(visited);
    }

    public static void print(int[][] board) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(j==N) {
                    System.out.print(board[i][j] == IFN ? 0 : board[i][j]);
                    continue;
                }
                System.out.print(board[i][j] == IFN ? 0 + " " : board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printNode(int[][][] visited) {

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                int size = visited[i][j].length;
                if(size == 0) {
                    System.out.println(0);
                    continue;
                }else {
                    System.out.print(size+1+" ");
                }


                for (int n = 0; n < size; n++) {
                    System.out.print(visited[i][j][n]+" ");
                    if (n == size - 1) {
                        System.out.println(j);
                    }
                }

            }
        }

        System.out.println();
    }
}
