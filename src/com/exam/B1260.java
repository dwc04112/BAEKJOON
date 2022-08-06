package com.exam;

import java.util.*;

public class B1260 {
    static int N,L,S;
    static int[][] Board;
    static boolean[] visited;
    static ArrayList<Integer> compare;

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N];
        visited[S-1] = true;
        queue.add(S);

        while(!queue.isEmpty()){
            compare = new ArrayList<>();
            int curr = queue.remove();
            System.out.print(curr+" ");

            for(int i=0; i<L; i++){
                for(int j=0; j<2; j++){
                    if(Board[i][j]==curr){
                        if(j==0) compare.add(Board[i][j+1]);
                        if(j==1) compare.add(Board[i][j-1]);
                    }
                }
            }
            if(compare.size()==1){
                if(visited[compare.get(0)-1]) continue;
                visited[compare.get(0)-1] = true;
                queue.add(compare.get(0));
            }
            if(compare.size()>1){
                Collections.sort(compare);
                for(int node : compare){
                    if(visited[node-1]) continue;
                    visited[node-1] = true;
                    queue.add(node);
                }
            }
        }
    }

    public static void dfs(int node){
        visited[node-1] = true;
        compare = new ArrayList<>();
        System.out.print(node+" ");
        for(int i=0; i<L; i++){
            for(int j=0; j<2; j++){
                if(Board[i][j]==node){
                    if(j==0&& !visited[Board[i][j+1]-1]) compare.add(Board[i][j+1]);
                    if(j==1&& !visited[Board[i][j-1]-1]) compare.add(Board[i][j-1]);
                }
            }
        }
        Collections.sort(compare);
        for(int i : compare){
            if(visited[i-1]) continue;
            dfs(i);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        S = sc.nextInt();

        Board = new int[L][2];

        for(int i=0; i<L; i++){
            for(int j=0; j<2; j++){
                Board[i][j] = sc.nextInt();
            }
        }
        visited = new boolean[N];
        dfs(S);
        System.out.println();
        bfs();
    }
}
