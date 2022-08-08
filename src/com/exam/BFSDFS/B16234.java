package com.exam.BFSDFS;

import java.util.*;

public class B16234 {
    static final int MAX_N = 10;
    static int n,l,r, result;
    static int[][] Board = new int[MAX_N][MAX_N];
    static int[][] D = {{-1,0},{1,0},{0,-1},{0,1}};
    static ArrayList<Node> union;
    static Queue<Node> queue;
    static boolean[][] visited;

    static class Node{
        int col,row=0;
        Node(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public static int move(){
        while(true) {
            visited = new boolean[n][n];
            boolean isMove = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (!visited[i][j]) {
                        int avg = bfs(i, j);
                        if (avg == -1) {
                            continue;
                        }
                        if (union.size() > 1) {
                            setAvg(avg);
                            isMove = true;
                        }
                    }
                }
            }if(!isMove) return result;
            result ++;
        }
    }
    public static void setAvg(int avg){
        for(Node node : union){
            Board[node.row][node.col] = avg;
        }
    }

    public static int bfs(int sRow, int sCol){
        queue = new LinkedList<>();
        visited[sRow][sCol] = true;
        queue.add(new Node(sRow,sCol));
        union = new ArrayList<>();
        union.add(new Node(sRow,sCol));

        int sum = Board[sRow][sCol];

        while(!queue.isEmpty()){
            Node curr = queue.remove();
            for(int i=0; i<4; i++){
                int nr = curr.row+D[i][0];
                int nc = curr.col+D[i][1];

                if(nr<0 || nr>n-1 || nc<0 || nc>n-1)continue;
                if(visited[nr][nc])continue;
                int minus = Math.abs(Board[curr.row][curr.col]-Board[nr][nc]);
                if(minus>=l && minus<=r){
                    visited[nr][nc] = true;
                    queue.add(new Node(nr,nc));
                    union.add(new Node(nr,nc));
                    sum += Board[nr][nc];
                }
            }
        }
        if(union.size()>1) {
            return sum / union.size();
        }else{
            return -1;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        Board = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                Board[i][j] = sc.nextInt();
            }
        }
        System.out.println(move());
    }
}
