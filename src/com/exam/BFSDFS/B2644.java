package com.exam.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2644 {
    static int N,M,x,y;
    static int res=0;
    static int[][] Graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        M = sc.nextInt();
        Graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i = 0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            Graph[a][b] = Graph[b][a] = 1;
        }
        bfs();
    }


    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        visited[x]=true;
        queue.add(new Node(x,1));
        boolean match = false;

        while(!queue.isEmpty()){
            Node temp = queue.remove();
            if(temp.num == y){
                if(res==0) {
                    res = temp.count;
                }else{
                    if(res>temp.count) res = temp.count;
                }
                match = true;
            }

            for(int i=1; i<N+1; i++){
                if(!visited[i] && (Graph[temp.num][i] == 1)){
                    visited[i] = true;
                    queue.add(new Node(i , temp.count+1 ));
                }
            }
        }
        if(!match) System.out.println(-1);
        if(match) System.out.println(res-1);
    }

    static class Node{
        int num ,count;
        Node(int n, int c){
            num = n;
            count = c;
        }
    }
}
