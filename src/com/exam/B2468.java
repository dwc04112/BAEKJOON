package com.exam;


import java.util.*;

public class B2468 {
    static int N;
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

    static void rain(){
        ArrayList<Integer> rainData = new ArrayList<>();
        for(int r =0; r<=100; r++) {
            visited = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (Board[i][j] > r && !visited[i][j]) {
                        count += bfs(i,j,r);
                    }
                }
            }
            rainData.add(count);
        }
        rainData.sort(Collections.reverseOrder());
        System.out.println(rainData.get(0));
    }

    static int bfs(int r, int c, int rain){
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
                if(Board[rd][cd]<=rain) continue;
                visited[rd][cd] = true;
                queue.add(new Node(rd, cd));
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Board = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                Board[i][j] = sc.nextInt();
            }
        }
        rain();
    }
}
