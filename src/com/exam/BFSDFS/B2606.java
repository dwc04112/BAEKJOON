package com.exam.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2606 {
    static int N,M;
    static int count = 0;
    static int[][] Graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        Graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i = 0; i<M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            Graph[x][y] = Graph[y][x] = 1;
        }
        bfs();
        System.out.println(count);
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        visited[1]=true;
        queue.add(1);
        while(!queue.isEmpty()){
            int temp = queue.remove();

            for(int i=1; i<N+1; i++){
                if(!visited[i] && (Graph[temp][i] == 1)){
                    visited[i] = true;
                    queue.add(i);
                    count ++;
                }
            }
        }
    }
}
