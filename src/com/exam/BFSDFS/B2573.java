package com.exam.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2573 {
    static int N,M;
    static int[][] Board;
    static boolean[][] visited;
    static int[][] D = {{-1,0},{1,0},{0,-1},{0,1}};

    static class Node{
        int row,col;
        Node(int r, int c){
            row=r;
            col=c;
        }
    }

    public static void day() {
        int num =0;
        int years =0;


        while(num<2){
            num =0;
            boolean melt = false;
            visited = new boolean[N][M];
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(Board[i][j]!=0 && !visited[i][j]){
                        bfs(new Node(i,j));
                        num ++;
                        melt = true;
                    }
                }
            }
            if(!melt){
                years=1;
                break;
            }
            years++;

            System.out.println(years + "년차 , " + num +"개");
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    System.out.print(Board[i][j]+" ");
                }
                System.out.println("");
            }
        }

        System.out.println(years-1);
    }

    private static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        visited[node.row][node.col] = true;
        queue.add(node);

        while(!queue.isEmpty()){
            Node temp = queue.remove();

            int zero =0;
            for(int i=0; i<4; i++){
                int nr = temp.row + D[i][0];
                int nc = temp.col + D[i][1];

                if(visited[nr][nc]) continue;
                if(Board[nr][nc]==0) {
                    zero +=1;
                    continue;
                }
                visited[nr][nc] = true;
                queue.add(new Node(nr,nc));
            }

            if(Board[temp.row][temp.col]<zero) {
                Board[temp.row][temp.col]=0;
            }else{
                Board[temp.row][temp.col] -= zero;
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //row
        M = sc.nextInt(); //col

        Board = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                Board[i][j] = sc.nextInt();
            }
        }
        day();
    }
}
