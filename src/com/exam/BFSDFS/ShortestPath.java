package com.exam.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPath {
    static final int MAX_N =10;
    static int N;
    static int[][] D = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[][] Board = new int[MAX_N][MAX_N];


    static class Point{
        int row; int col; int dist;
        Point(int r, int c, int d){
            row = r; col = c; dist = d;
        }
    }

    public static int bfs(int sRow, int sCol, int dRow, int dCol){
        boolean[][] visited = new boolean[N][N];
        Queue<Point> queue = new LinkedList<>();
        visited[sRow][sCol] = true;
        queue.add(new Point(sRow,sCol,0));

        while(!queue.isEmpty()){
            Point curr = queue.remove();
            if(curr.row == dRow && curr.col == dCol){
                return curr.dist;
            }

            for(int i=0; i<4; i++){
                int nr = curr.row+D[i][0];
                int nc = curr.col+D[i][1];
                if(nr<0||nr>N-1||nc<0||nc>N-1)continue;
                if(visited[nr][nc])continue;
                if(Board[nr][nc]==1)continue;
                visited[nr][nc] = true;
                queue.add(new Point(nr,nc,curr.dist+1));
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i =0; i<N; i++){
            for(int j=0; j<N; j++){
                Board[i][j] = sc.nextInt();
            }
        }
        int sRow = sc.nextInt();
        int sCol = sc.nextInt();
        int dRow = sc.nextInt();
        int dCol = sc.nextInt();
        System.out.println(bfs(sRow,sCol,dRow,dCol));
    }
}
