package com.exam.BFSDFS;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class B11724 {
    static int N,M,res;
    static int[][] graph;
    static boolean[] visited;



    static void bfs(int node){
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(node);

        while (!queue.isEmpty()){
            int temp = queue.remove();
            for(int i =1; i<N+1; i++){
                if(!visited[i]&&graph[temp][i] ==1 ){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N+1];
        graph = new int[N+1][N+1];

        for(int i=1; i<M+1; i++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            graph[r][c] = graph[c][r] = 1;
        }

        res = 0;
        for(int i=1; i<N+1; i++){
            if(visited[i]) continue;
            bfs(i);
            res++;
        }
        System.out.println(res);
    }
}
