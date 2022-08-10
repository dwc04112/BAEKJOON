package com.exam.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14503 {
    static int N,M;
    static int res=0;
    static int[][] Board;
    static boolean[][] visited;
    static int[][] D = {{-1,0},{0,1},{1,0},{0,-1}}; //북동남서

    static class Node{
        int r,c,d,m;
        Node(int row, int col, int dir, int move){
            r=row;
            c=col;
            d=dir;
            m=move;
        }
    }
    public static void clear(Node node){
        Queue<Node> queue = new LinkedList<>();
        visited[node.r][node.c] = true;
        queue.add(node);

        while(!queue.isEmpty()){
            Node temp = queue.remove();
            boolean search = false;
            if(temp.m>res) res= temp.m;

            int nd= temp.d;
            for(int i=0; i<4; i++){
                if(nd==0) {
                    nd=3;
                } else {
                    nd = nd-1;
                }
                int nr = temp.r + D[nd][0];
                int nc = temp.c + D[nd][1];

                if(visited[nr][nc]||Board[nr][nc]==1) continue;
                visited[nr][nc] = true;
                queue.add(new Node(nr,nc,nd,temp.m+1));
                search = true;
                break;
            }
            if(!search){
                int back=0;
                if(temp.d==0) back=2;
                if(temp.d==1) back=3;
                if(temp.d==3) back=1;

                int br = temp.r + D[back][0];
                int bc = temp.c + D[back][1];
                if(Board[br][bc]==1) {
                    break;
                }
                queue.add(new Node(br, bc, temp.d, temp.m));
            }
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   //세로
        M = sc.nextInt();   //가로

        int sRow = sc.nextInt();
        int sCol = sc.nextInt();
        int sDir = sc.nextInt();

        Board = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                Board[i][j] = sc.nextInt();
            }
        }
        clear(new Node(sRow,sCol,sDir,1));
    }
}
