package com.exam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2178 {
    static int N,M;
    static int[][] Board;
    static int[][] D = {{-1,0},{1,0},{0,-1},{0,1}}; //상 하 좌 우
    static boolean[][] visited;

    static class Node{
        int row, col, count;
        Node(int r, int c, int ct){
            row = r;
            col = c;
            count = ct;
        }
    }

    public static int move(){
        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[N][M];
        visited[0][0] = true;
        queue.add(new Node(0,0,1));

        while(!queue.isEmpty()){
            Node temp = queue.remove();
            if(temp.row==N-1&&temp.col==M-1){
                return temp.count;
            }
            for(int i=0; i<4; i++){
                int rd = temp.row + D[i][0];
                int cd = temp.col + D[i][1];

                if(rd<0||rd>=N||cd<0||cd>=M) continue;
                if(Board[rd][cd]==0) continue;
                if(visited[rd][cd]) continue;
                visited[rd][cd] = true;
                queue.add(new Node(rd,cd,temp.count+1));
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        Board = new int[N][M];
        String str;
        for(int i=0; i<N; i++) {
            str= sc.next();
            for(int j=0; j<M; j++) {
                Board[i][j]= Integer.parseInt(str.charAt(j)+"");
            }
        }
        System.out.println(move());
    }
}
