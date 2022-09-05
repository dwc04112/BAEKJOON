package com.exam.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576 {
    static int N,M;
    static int[][] Board;
    static int[][] D = {{0,-1} , {0,1} , {-1,0} , {1,0}}; //상하좌우
    static Queue<Node> queue = new LinkedList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Board = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                Board[i][j] = Integer.parseInt(st.nextToken());
                if(Board[i][j]==1) queue.add(new Node(i,j,0));
            }
        }
        moveTomato();
    }

    private static void moveTomato() {
        int res = 0;
        while(!queue.isEmpty()){
            Node temp = queue.remove();
            if(res<temp.day) res = temp.day;

            for (int i = 0; i < 4; i++) {
                int nr = temp.row + D[i][0];
                int nc = temp.col + D[i][1];

                if(nr < 0 || nc < 0 || nr >= M || nc >= N) continue;

                if(visited[nr][nc]) continue;
                if(Board[nr][nc]==-1) continue;
                if(Board[nr][nc]==1) continue;

                visited[nr][nc] = true;
                Board[nr][nc] = 1;
                queue.add(new Node(nr,nc, temp.day+1));
            }
        }

        boolean isRipe = true;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (Board[i][j] == 0) {
                    isRipe = false;
                    break;
                }
            }
        }
        if(isRipe) System.out.println(res);
        else System.out.println(-1);
    }

    static class Node{
        int row,col,day;
        Node(int r, int c, int d){
            row = r;
            col = c;
            day = d;
        }
    }
}
