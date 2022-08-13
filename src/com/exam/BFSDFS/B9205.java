package com.exam.BFSDFS;

import java.util.*;

public class B9205 {
    static int t, n;
    static int[][] Board;
    static boolean[] visited;
    static ArrayList<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int i=0; i<t; i++){
            n = sc.nextInt();
            Board = new int[n+2][2];
            visited = new boolean[n+2];

            for(int j=0; j<n+2; j++){
                Board[j][0] = sc.nextInt();
                Board[j][1] = sc.nextInt();
            }
            int sRow = Board[0][0];
            int sCol = Board[0][1];
            int fRow = Board[n+1][0];
            int fCol = Board[n+1][1];
            bfs(sRow , sCol, fRow ,fCol);
        }

        for(String r : res){
            System.out.println(r);
        }
    }


    private static void bfs(int sRow, int sCol, int fRow, int fCol) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sRow, sCol));
        visited[0] = true;

        boolean finish = false;
        while(!queue.isEmpty()){
            Node temp = queue.remove();
            if(temp.r == fRow && temp.c == fCol){
                finish = true;
                break;
            }
            for(int i = 0; i<n+2; i++){
                if(Math.abs(temp.r - Board[i][0]) + Math.abs(temp.c - Board[i][1]) > 1000) continue;
                if(visited[i]) continue;
                visited[i] = true;
                queue.add(new Node(Board[i][0] , Board[i][1]));
            }
        }
        if(finish) {
            res.add("happy");
        }else{
            res.add("sad");
        }
    }

    static class Node{
        int r,c;
        Node(int row, int col){
            r = row;
            c = col;
        }
    }
}
