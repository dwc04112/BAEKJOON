package com.exam;

import java.util.*;

public class B2667 {
    static int N;
    static int[][] Board;
    static int[][] D = {{-1,0},{1,0},{0,-1},{0,1}}; //상하좌우
    static boolean[][] visited;
    static ArrayList<Integer> town = new ArrayList<>();

    static class Node{
        int row,col;
        Node(int r, int c){
            row = r;
            col = c;
        }
    }

    static void move(){
        for(int i=0;i<N; i++){
            for(int j=0;j<N; j++){
                if(Board[i][j]==1 && !visited[i][j]){
                    town.add(bfs(i,j));
                }
            }
        }
        Collections.sort(town);
        System.out.println(town.size());
        for(int t : town){
            System.out.println(t);
        }
    }

    static int bfs(int r, int c){
        int count =1;
        Queue<Node> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.add(new Node(r,c));

        while(!queue.isEmpty()){
            Node temp = queue.remove();
            for(int i=0; i<4; i++){
                int rd = temp.row - D[i][0];
                int cd = temp.col - D[i][1];

                if(rd<0||rd>=N||cd<0||cd>=N) continue;
                if(visited[rd][cd]) continue;
                if(Board[rd][cd]==0) continue;

                visited[rd][cd] = true;
                queue.add(new Node(rd,cd));
                count+=1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        visited = new boolean[N][N];
        Board = new int[N][N];
        String str;
        for(int i=0; i<N; i++){
            str= sc.next();
            for(int j=0; j<N; j++){
                Board[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }
        move();
    }
}
