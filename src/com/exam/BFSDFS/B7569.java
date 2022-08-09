package com.exam.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7569 {
    static int M,N,H;
    static int[][][] box;
    static boolean[][][] visited;
    static int[][] D = {{-1,0,0},{1,0,0},{0,-1,0},{0,1,0},{0,0,-1},{0,0,1}}; // 위 아래 상하좌우
    static int res=0;
    static Queue<tomato> queue = new LinkedList<>();

    static class tomato{
        int h,r,c,count;
        tomato(int high, int row, int col, int move){
            h=high;
            r=row;
            c=col;
            count=move;
        }
    }

    private static void move() {

        while(!queue.isEmpty()){
            tomato temp = queue.remove();
            if(res < temp.count) res= temp.count;

            for(int i=0; i<6; i++){
                int nh = temp.h + D[i][0];
                int nr = temp.r + D[i][1];
                int nc = temp.c + D[i][2];

                if(nh<0 || nh>=H || nr<0 || nr>=N || nc<0 || nc>=M) continue;
                if(visited[nh][nr][nc]) continue;
                if(box[nh][nr][nc]==-1) continue;


                visited[nh][nr][nc]=true;
                if(box[nh][nr][nc]==0) {
                    box[nh][nr][nc]=1;
                    queue.add(new tomato(nh,nr,nc, temp.count+1));
                }
                if(box[nh][nr][nc]==1) {
                    queue.add(new tomato(nh,nr,nc, temp.count));
                }
            }
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        box = new int[H][N][M];
        visited = new boolean[H][N][M];

        for(int h=0; h<H; h++){
            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    box[h][n][m] = sc.nextInt();
                    if(box[h][n][m]==1){
                        visited[h][n][m] = true;
                        queue.add(new tomato(h,n,m,0));
                    }
                }
            }
        }
        move();
        for(int h=0; h<H; h++){
            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if (box[h][n][m] == 0) {
                        res = -1;
                        break;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
