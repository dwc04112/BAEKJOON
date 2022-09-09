package com.exam.DP문제집;

// https://www.acmicpc.net/problem/11048
// 이동하기
// bfs로 구현 : 메로리 초과

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11048error {
    static int N,M;
    static int[][] board;
    static int[][] D = {{1,0},{0,1},{1,1}}; // (r+1, c), (r, c+1), (r+1, c+1)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N+1][M+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 1; j < M+1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,1, board[1][1] ));
        int res = 0;
        while(!queue.isEmpty()){
            Node temp = queue.remove();

            if(temp.row == N && temp.col == M){
                if(res<temp.count) res = temp.count;
            }

            for (int i = 0; i < 3; i++) {
                int nr = temp.row+D[i][0];
                int nc = temp.col+D[i][1];

                if(nr<1 || nc<1 || nr>N || nc>M) continue;

                queue.add(new Node(nr,nc, temp.count+board[nr][nc] ));
            }
        }
        return res;
    }

    private static class Node{
        int row, col, count;
        Node(int r, int c,int  cnt){
            row = r;
            col = c;
            count = cnt;
        }
    }
}
